package com.santosh.vseeit;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import static com.santosh.vseeit.register.onResetPasswordFragment;

public class Login extends Fragment {

    public Login() {
        // Required empty public constructor
    }
private TextView donthaveanaccount;
private FrameLayout parentFrameLayout;

private EditText emailnum;
private EditText passwordd;

private ImageButton closebtnlog;
private Button loginbtn;

private TextView forgot_password;
private FirebaseAuth firebaseAuth;
private ProgressBar logonprogress;

private String Emailpattern = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_login, container, false);
        parentFrameLayout = getActivity().findViewById(R.id.registerlayout);
        donthaveanaccount = view.findViewById(R.id.donthaveaccsignup);

        emailnum = view.findViewById(R.id.username);
        passwordd = view.findViewById(R.id.password);

        forgot_password = view.findViewById(R.id.forgot_pass);
        closebtnlog = view.findViewById(R.id.login_close);
        logonprogress = view.findViewById(R.id.progresslogin);

        loginbtn = view.findViewById(R.id.btn_sign);

        firebaseAuth = FirebaseAuth.getInstance();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        donthaveanaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new Signup());
            }
        });
        forgot_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 onResetPasswordFragment = true;
                setFragment(new Forgotpassword());
            }
        });
        closebtnlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeintent();
            }
        });
        emailnum.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            checkInputs();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        passwordd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkemailandpassword();
            }
        });
    }

    private void setFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_right,R.anim.slideout_from_left);
        fragmentTransaction.replace(parentFrameLayout.getId(),fragment);
        fragmentTransaction.commit();
    }
    private void checkInputs(){
        if (!TextUtils.isEmpty(emailnum.getText())){
            if (!TextUtils.isEmpty(passwordd.getText())){
                loginbtn.setEnabled(true);
                loginbtn.setTextColor(Color.rgb(255,255,255));
            }else{
                loginbtn.setEnabled(false);
                loginbtn.setTextColor(Color.argb(50,255,255,255));
            }
        }else{
            loginbtn.setEnabled(false);
            loginbtn.setTextColor(Color.argb(50,255,255,255));
        }
    }
    private void checkemailandpassword(){
        if (emailnum.getText().toString().matches(Emailpattern)){
            if (passwordd.length()>=5){
                logonprogress.setVisibility(View.VISIBLE);
                loginbtn.setEnabled(false);
                loginbtn.setTextColor(Color.argb(50,255,255,255));
                    firebaseAuth.signInWithEmailAndPassword(emailnum.getText().toString(),passwordd.getText().toString())
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    closeintent();
                                }else{
                                    logonprogress.setVisibility(View.INVISIBLE);
                                    loginbtn.setEnabled(true);
                                    loginbtn.setTextColor(Color.rgb(255,255,255));
                                    String Error = task.getException().getMessage();
                                    Toast.makeText(getActivity(), Error, Toast.LENGTH_SHORT).show();
                                }

                                }
                            });
            }else{
                Toast.makeText(getActivity(), "Invalid email & password", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(getActivity(), "Invalid email & password", Toast.LENGTH_SHORT).show();
        }
    }
    private void closeintent(){
        Intent intent = new Intent(getActivity(),MainActivity.class);
        startActivity(intent);
        getActivity().finish();
    }
}