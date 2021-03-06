package com.example.digitalconstruction.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.digitalconstruction.R;
import com.example.digitalconstruction.registrasi.Login;
import com.example.digitalconstruction.registrasi.Register;

public class StartRegisterActivity extends AppCompatActivity {
    Button btn_login, btn_signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_register);

        btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindahBeranda = new Intent(getApplicationContext(), Login.class);
                startActivity(pindahBeranda);
            }
        });

        btn_signup = findViewById(R.id.btnregis);
        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindahcoba = new Intent(getApplicationContext(), Register.class);
                startActivity(pindahcoba);
            }
        });
    }
}
