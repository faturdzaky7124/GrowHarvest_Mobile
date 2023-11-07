package com.features.growharvest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    private EditText edtLoginEmail;
    private EditText edtLoginPassword;
    private Button btnLogin;
    private Button btnLoginGoogle;
    private TextView txtToRegis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtToRegis = findViewById(R.id.txt_to_register);
        edtLoginEmail = findViewById(R.id.txt_login_email);
        edtLoginPassword = findViewById(R.id.txt_login_password);
        btnLogin = findViewById(R.id.btn_login);
        btnLoginGoogle = findViewById(R.id.btn_login_google);
        txtToRegis.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}