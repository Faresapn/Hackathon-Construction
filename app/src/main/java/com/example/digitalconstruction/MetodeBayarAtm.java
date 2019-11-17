package com.example.digitalconstruction;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MetodeBayarAtm extends AppCompatActivity {
    CardView bni,bca,mandiri,bri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metode_bayar_atm);
        bni = findViewById(R.id.bni);
        bni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentt();
            }
        });
        bca = findViewById(R.id.bca);
        bca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentt();
            }
        });
        mandiri = findViewById(R.id.mandiri);
        mandiri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentt();
            }
        });
        bri = findViewById(R.id.bri);
        bri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentt();
            }
        });
    }

    void intentt(){
        startActivity(new Intent(MetodeBayarAtm.this,Pembayaran.class));

    }
}
