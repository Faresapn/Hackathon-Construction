package com.example.digitalconstruction.Calendar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.digitalconstruction.Data.Items;
import com.example.digitalconstruction.MetodePembayaran;
import com.example.digitalconstruction.Pembayaran;
import com.example.digitalconstruction.R;

import java.util.concurrent.TimeUnit;

public class Detail_Rent extends AppCompatActivity {
    TextView noPesanan,nameProduct,location,timerent,harga;
    Button bayar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail__rent);
        noPesanan = findViewById(R.id.noPesanan);
        nameProduct= findViewById(R.id.nameProduct);
        location  = findViewById(R.id.location);
        timerent = findViewById(R.id.timeRent);
        bayar = findViewById(R.id.button5);
        harga = findViewById(R.id.hargarent);
        final Items detailitems = getIntent().getParcelableExtra("data");
        final long datepinjam = getIntent().getLongExtra("datepinjam",-1);
        final long datekembali = getIntent().getLongExtra("datekembali",-1);
        long duration  = datekembali - datepinjam;
        long diffInHours = TimeUnit.MILLISECONDS.toHours(duration) + 24;
        Log.d("diff", String.valueOf(diffInHours));
        long diffInDays = TimeUnit.MILLISECONDS.toDays(duration) + 1;
        Log.d("diff", String.valueOf(diffInDays));

        noPesanan.setText("No Pesanan : 1187625636782ABG");
        nameProduct.setText(detailitems.getNama());
        location.setText("Lokasi : " +detailitems.getKota());
        timerent.setText("Waktu Sewa : " + diffInDays + " Hari ( " + diffInHours +" )");
        harga.setText("Total harga : " + 1000000*diffInDays);

        bayar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Detail_Rent.this, MetodePembayaran.class));
            }
        });
    }
}
