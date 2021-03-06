package com.example.digitalconstruction.registrasi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.digitalconstruction.R;
import com.example.digitalconstruction.activity.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private ProgressDialog progressDialog;

    EditText username,password,email,passwordulang,skill,nope;
    Button register,user2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();


        username =  findViewById(R.id.nama);
        password = findViewById(R.id.password);
        email = findViewById(R.id.email);
        passwordulang = findViewById(R.id.passwordulang);
        skill =  findViewById(R.id.skill);
        nope = findViewById(R.id.nope);
        user2 = findViewById(R.id.button3);
        register = findViewById(R.id.button4);
        progressDialog = new ProgressDialog(this);

        user2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this,Register2.class);
                startActivity(intent);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String txt_username =  username.getText().toString();
                String txt_email =  email.getText().toString();
                String txt_password =  password.getText().toString();
                String txt_passwordulang =  passwordulang.getText().toString();
                String txt_skill =  skill.getText().toString();
                String txt_nope =  nope.getText().toString();

                boolean isEmptyFields = false;

                if (TextUtils.isEmpty(txt_username)) {
                    isEmptyFields = true;
                    username.setError("Field ini tidak boleh kosong");
                }

                if (TextUtils.isEmpty(txt_email)) {
                    isEmptyFields = true;
                    email.setError("Field ini tidak boleh kosong");
                }

                if (TextUtils.isEmpty(txt_password)) {
                    isEmptyFields = true;
                    password.setError("Field ini tidak boleh kosong");
                }
                if (TextUtils.isEmpty(txt_passwordulang)) {
                    isEmptyFields = true;
                    passwordulang.setError("Field ini tidak boleh kosong");
                }
                if (TextUtils.isEmpty(txt_skill)) {
                    isEmptyFields = true;
                    skill.setError("Field ini tidak boleh kosong");
                }
                if (TextUtils.isEmpty(txt_nope)) {
                    isEmptyFields = true;
                    nope.setError("Field ini tidak boleh kosong");
                }
                if (!isEmptyFields) {
                    register(txt_username, txt_email, txt_password, txt_passwordulang, txt_skill, txt_nope);


                }



            }

            private void register(final String txt_username, final String txt_email, final String txt_password, final String txt_passwordulang, final String txt_skill, final String txt_nope) {
                mAuth.createUserWithEmailAndPassword(txt_email, txt_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.setTitle("Registration User");
                        progressDialog.setMessage("Please Wait Your Account !");
                        progressDialog.setCanceledOnTouchOutside(false);
                        progressDialog.show();

                            if (task.isSuccessful()){
                                Intent intent = new Intent(Register.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                            }else{
                                Toast.makeText(Register.this, "you dont register", Toast.LENGTH_LONG).show();
                            }


                    }
                });
            }

        });
    }

}