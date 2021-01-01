package com.mma.coviguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity implements View.OnClickListener {
    private TextView register;
    private EditText editTextEmail , editTextPassword;
    private Button signIn;
    private CheckBox saveLoginCheckBox;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Boolean saveLogIn;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        register = (TextView) findViewById(R.id.registerText);
        register.setOnClickListener(this);

        signIn = (Button) findViewById(R.id.login);
        signIn.setOnClickListener(this);
        editTextEmail = (EditText) findViewById(R.id.Email);
        editTextPassword = (EditText) findViewById(R.id.Password);
        sharedPreferences = getSharedPreferences("LoginRef",MODE_PRIVATE);
        saveLoginCheckBox = (CheckBox) findViewById(R.id.Check);
        editor = sharedPreferences.edit();
        mAuth = FirebaseAuth.getInstance();
        saveLogIn = sharedPreferences.getBoolean("saveLogIn",true);
        if (saveLogIn==true){
            editTextEmail.setText(sharedPreferences.getString("userEmail",null));
            editTextPassword.setText((sharedPreferences.getString("userPassword",null)));
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.registerText:
                startActivity(new Intent(this,SignUp.class));
                break;

            case R.id.login:
                userLogin();
                break;
        }

    }

    private void userLogin() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (email.isEmpty()){
            editTextEmail.setError("Email is required");
            editTextEmail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextEmail.setError("Please enter a valid email");
            editTextEmail.requestFocus();
            return;
        }
        if (password.isEmpty()){
            editTextPassword.setError("password is required");
            editTextPassword.requestFocus();
            return;
        }
        if (password.length() < 6){
            editTextPassword.setError("min password length is 6 character");
            editTextPassword.requestFocus();
            return;
        }
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    startActivity(new Intent(Login.this,Home.class));
                    if (saveLoginCheckBox.isChecked()){
                        editor.putBoolean("saveLogIn",true);
                        editor.putString("userEmail",email);
                        editor.putString("userPassword",password);
                        editor.commit();

                    }
                }else {
                    Toast.makeText(Login.this,"Failed to login please check your credentials",Toast.LENGTH_LONG).show();

                }
            }
        });

    }
}