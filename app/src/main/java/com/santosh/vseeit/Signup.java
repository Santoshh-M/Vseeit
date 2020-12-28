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
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Signup extends Fragment {

    public Signup() {
        // Required empty public constructor
    }

    private TextView alreadyHaveanaccount;
    private FrameLayout parentFrameLayout;

    private EditText firstname;
    private EditText lastname;
    private EditText email;
    private EditText password;
    private EditText confirmpassword;
    private FirebaseFirestore firebaseFirestore;
    private ImageButton closebtnsignup;
    private Button signup;
    private ProgressBar progress;
    private FirebaseAuth firebaseAuth;
    private String emailpattern="^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_signup, container, false);
        alreadyHaveanaccount = view.findViewById(R.id.alreadyhaveacc);
        parentFrameLayout = getActivity().findViewById(R.id.registerlayout);

        firstname = view.findViewById(R.id.input_firstname);
        lastname = view.findViewById(R.id.input_lastname);
        email = view.findViewById(R.id.input_email);
        password = view.findViewById(R.id.input_password);
        confirmpassword = view.findViewById(R.id.input_confirmpassword);
        closebtnsignup = view.findViewById(R.id.close);
        signup = view.findViewById(R.id.button_styledi);
        progress = view.findViewById(R.id.progressignup);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        alreadyHaveanaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new Login());
            }
        });

        email.addTextChangedListener(new TextWatcher() {
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
        firstname.addTextChangedListener(new TextWatcher() {
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
        lastname.addTextChangedListener(new TextWatcher() {
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
        password.addTextChangedListener(new TextWatcher() {
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
        confirmpassword.addTextChangedListener(new TextWatcher() {
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
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Todo send data to firebase
                checkemailandpasswrd();
            }
        });
    }


    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_left, R.anim.slideout_from_right);
        fragmentTransaction.replace(parentFrameLayout.getId(), fragment);
        fragmentTransaction.commit();

    }
    private void checkInputs() {
        if (!TextUtils.isEmpty(email.getText())) {
            if (!TextUtils.isEmpty(firstname.getText())) {
                if (!TextUtils.isEmpty(lastname.getText())) {
                    if (!TextUtils.isEmpty(password.getText()) && password.length() >= 0) {
                        if (!TextUtils.isEmpty(confirmpassword.getText())) {
                            signup.setEnabled(true);
                            signup.setTextColor(Color.rgb(255,255,255));
                        } else {
                            signup.setEnabled(false);
                            signup.setTextColor(Color.argb(50,255,255,255));
                        }
                    } else {
                        signup.setEnabled(false);
                        signup.setTextColor(Color.argb(50,255,255,255));
                    }
                } else {
                    signup.setEnabled(false);
                    signup.setTextColor(Color.argb(50,255,255,255));
                }
            }else{
                signup.setEnabled(false);
                signup.setTextColor(Color.argb(50,255,255,255));
            }
        }else{
            signup.setEnabled(false);
            signup.setTextColor(Color.argb(50,255,255,255));
        }
    }
    private void checkemailandpasswrd(){
        if(email.getText().toString().matches(emailpattern)){
            if(password.getText().toString().equals(confirmpassword.getText().toString())){
                progress.setVisibility(View.VISIBLE);
                signup.setEnabled(true);
                signup.setTextColor(Color.rgb(255,255,255));
                firebaseAuth.createUserWithEmailAndPassword(email.getText().toString(),password.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){

                                    Map<Object,String> userdata = new HashMap<>();
                                    userdata.put("Firstname",firstname.getText().toString());
                                    userdata.put("Lastname",lastname.getText().toString());
                                    userdata.put("Email",email.getText().toString());
                                    firebaseFirestore.collection("USERS")
                                            .add(userdata)
                                            .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                                                @Override
                                                public void onComplete(@NonNull Task<DocumentReference> task) {
                                                if (task.isSuccessful()){
                                                    Intent mainintent = new Intent (getActivity(),MainActivity.class);
                                                    startActivity(mainintent);
                                                    getActivity().finish();
                                                }else{

                                                    progress.setVisibility(View.INVISIBLE);
                                                    signup.setEnabled(true);
                                                    signup.setTextColor(Color.rgb(255,255,255));
                                                    String error = task.getException().getMessage();
                                                    Toast.makeText(getActivity(), "error", Toast.LENGTH_SHORT).show();
                                                }
                                                }
                                            });

                                }else{
                                    progress.setVisibility(View.INVISIBLE);
                                    signup.setEnabled(true);
                                    signup.setTextColor(Color.rgb(255,255,255));
                                    String error = task.getException().getMessage();
                                    Toast.makeText(getActivity(), "error", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }else{
                    confirmpassword.setError("password doesn't matched !");
            }
        }else{
            email.setError("Invalid email");
        }
    }
}