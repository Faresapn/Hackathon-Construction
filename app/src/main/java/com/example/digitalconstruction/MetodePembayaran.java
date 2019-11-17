package com.example.digitalconstruction;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MetodePembayaran extends AppCompatActivity {
    LinearLayout atm,bayarlangsung;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metode_pembayaran);
        atm = findViewById(R.id.atm);
        atm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MetodePembayaran.this,MetodeBayarAtm.class));
            }
        });
        bayarlangsung = findViewById(R.id.bayarlangsung);
        bayarlangsung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MetodePembayaran.this, "Under Development", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
