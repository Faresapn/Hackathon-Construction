package com.example.digitalconstruction.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.digitalconstruction.Calendar.Calendar_Activity;
import com.example.digitalconstruction.Data.Conversation;
import com.example.digitalconstruction.Data.Items;
import com.example.digitalconstruction.R;

public class DetailRentActivity extends AppCompatActivity {
    TextView detailNama, detailHarga, detailKota,detailUnit,titleToolbar;
    ImageView detailImage;
    Button btn_RentNow, btn_contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_rent);

        final Items detailitems = getIntent().getParcelableExtra("data");

        detailNama = findViewById(R.id.detail_items_nama);
        detailHarga = findViewById(R.id.detail_items_harga);
        detailKota = findViewById(R.id.detail_items_lokasi);
        detailUnit = findViewById(R.id.detail_items_unit);
        detailImage = findViewById(R.id.detail_items_image);
        btn_RentNow = findViewById(R.id.btn_rent);
        btn_contact = findViewById(R.id.btn_contact_rent);
        titleToolbar = findViewById(R.id.detail_items_title_toolbar);
        Toolbar toolbar = findViewById(R.id.toolbardetailrent);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_arrow_back_black_24dp));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


//        String txt_title = detailitems.getNama();
//        titleToolbar.setText(txt_title);

        String txt_nama = detailitems.getNama();
        detailNama.setText(txt_nama);
        titleToolbar.setText(txt_nama);

        String txt_harga = detailitems.getHarga();
        detailHarga.setText(txt_harga);

        String txt_kota = detailitems.getKota();
        detailKota.setText(txt_kota);

        String txt_unit = detailitems.getUnit();
        detailUnit.setText(txt_unit);

        int Image = detailitems.getImg();
        Glide.with(this).load(Image).into(detailImage);
        btn_RentNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Items mItems = new Items();
                mItems.setImg(detailitems.getImg());
                mItems.setNama(detailitems.getNama());
                mItems.setHarga(detailitems.getHarga());
                mItems.setKota(detailitems.getKota());
                mItems.setJam(detailitems.getJam());
                mItems.setUnit(detailitems.getUnit());
                Intent pindahchat = new Intent(DetailRentActivity.this, Calendar_Activity.class);
                pindahchat.putExtra("data",mItems);
                startActivity(pindahchat);
            }
        });
        btn_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindahchat = new Intent(DetailRentActivity.this, Conversation.class);
                startActivity(pindahchat);
            }
        });
    }
}
