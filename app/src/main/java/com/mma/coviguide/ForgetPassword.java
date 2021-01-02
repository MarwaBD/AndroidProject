package com.mma.coviguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

public class ForgetPassword extends AppCompatActivity {
    private EditText emailEditText;
    private Button resetPasswordButton;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        //initialise
        emailEditText = (EditText) findViewById(R.id.Email);
        resetPasswordButton = (Button) findViewById(R.id.Reset);
        auth = FirebaseAuth.getInstance();
        resetPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetPassword();
            }
        });
    }

    private void resetPassword() {
      String email = emailEditText.getText().toString().trim();
      if(email.isEmpty()){
          emailEditText.setError("Email is required!");
          emailEditText.requestFocus();
          return;
      }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailEditText.setError("Please provide valid email");
            emailEditText.requestFocus();
            return;
        }
        auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(ForgetPassword.this, "Check your email to rest your password", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(ForgetPassword.this, "Try again! Somthing wrong happened!", Toast.LENGTH_LONG).show();
                }
            }
        });

        }
    }
