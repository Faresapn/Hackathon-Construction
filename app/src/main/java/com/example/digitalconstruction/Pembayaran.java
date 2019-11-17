package com.example.digitalconstruction;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Pembayaran extends AppCompatActivity {
    Button konfirmasi;
    CardView changeMethod;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembayaran);
        konfirmasi = findViewById(R.id.button5);
        konfirmasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Pembayaran.this,TrxSuccses.class));
            }
        });
        changeMethod =findViewById(R.id.changeMethod);
        changeMethod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Pembayaran.this,MetodeBayarAtm.class));

            }
        });
    }
}
