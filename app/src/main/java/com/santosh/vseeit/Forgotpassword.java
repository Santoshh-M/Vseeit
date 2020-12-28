package com.santosh.vseeit;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class Forgotpassword extends Fragment {
    public Forgotpassword() {
        // Required empty public constructor
    }
    private EditText forgot_user;
    private TextView goback;
    private Button reset_btn;
    private FrameLayout parentFrameLayout;
    private FirebaseAuth firebaseAuth;

    private ViewGroup emailicon;
    private ImageView icon;
    private TextView text;
    private ProgressBar progressBar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_forget, container, false);
        forgot_user = view.findViewById(R.id.forgot_password);
        reset_btn = view.findViewById(R.id.forgot_button);
        goback = view.findViewById(R.id.go_back);
        parentFrameLayout = getActivity().findViewById(R.id.registerlayout);
        firebaseAuth = FirebaseAuth.getInstance();

        emailicon = view.findViewById(R.id.forgot_password_icon_container);
        icon = view.findViewById(R.id.recovery_img);
        text = view.findViewById(R.id.recovery_text);
        progressBar = view.findViewById(R.id.forgot_progress);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        forgot_user.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkvalue();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
       reset_btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               TransitionManager.beginDelayedTransition(emailicon);
               text.setVisibility(View.GONE);

               TransitionManager.beginDelayedTransition(emailicon);
               icon.setVisibility(View.VISIBLE);
               progressBar.setVisibility(View.VISIBLE);

               reset_btn.setEnabled(false);
               reset_btn.setTextColor(Color.argb(50,255,255,255));
               firebaseAuth.sendPasswordResetEmail(forgot_user.getText().toString())
                       .addOnCompleteListener(new OnCompleteListener<Void>() {
                           @Override
                           public void onComplete(@NonNull Task<Void> task) {
                               if (task.isSuccessful()){

                                   ScaleAnimation scaleAnimation = new ScaleAnimation(1,0,1,0,icon.getWidth()/2,icon.getHeight()/2);
                                   scaleAnimation.setDuration(100);
                                   scaleAnimation.setInterpolator(new AccelerateInterpolator());
                                   scaleAnimation.setRepeatMode(Animation.REVERSE);
                                   scaleAnimation.setRepeatCount(1);
                                   scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
                                       @Override
                                       public void onAnimationStart(Animation animation) {

                                       }
                                       @Override
                                       public void onAnimationEnd(Animation animation) {
                                           text.setText("Recovery mail sent successfully !");
                                           text.setTextColor(getResources().getColor(R.color.successgreen));
                                           TransitionManager.beginDelayedTransition(emailicon);
                                           icon.setVisibility(View.VISIBLE);
                                       }

                                       @Override
                                       public void onAnimationRepeat(Animation animation) {
                                           icon.setImageResource(R.drawable.email_green);
                                       }
                                   });
                                   icon.startAnimation(scaleAnimation);
                               }else{
                                String error = task.getException().getMessage();
                                  progressBar.setVisibility(View.GONE);

                                  text.setText(error);
                                  text.setTextColor(getResources().getColor(R.color.red));
                                  TransitionManager.beginDelayedTransition(emailicon);
                                  text.setVisibility(View.VISIBLE);
                               }
                               reset_btn.setEnabled(true);
                               reset_btn.setTextColor(Color.rgb(255,255,255));
                           }
                       });
           }
       });
        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new Login());
            }
        });
    }

    private void checkvalue(){
        if (TextUtils.isEmpty(forgot_user.getText())){
            reset_btn.setEnabled(false);
            reset_btn.setTextColor(Color.argb(50,255,255,255));
        }else{
            reset_btn.setEnabled(true);
            reset_btn.setTextColor(Color.rgb(255,255,255));
        }
    }
    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_left, R.anim.slideout_from_right);
        fragmentTransaction.replace(parentFrameLayout.getId(), fragment);
        fragmentTransaction.commit();
    }
}