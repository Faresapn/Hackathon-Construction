package com.example.digitalconstruction.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.digitalconstruction.Adapter.ItemAdapter;
import com.example.digitalconstruction.Data.Items;
import com.example.digitalconstruction.R;
import com.example.digitalconstruction.fragment.BerandaFragment;

import java.util.ArrayList;

public class RentActivity extends AppCompatActivity {
    String [] namaData;
    String [] kotaData;
    String [] jamdata;
    String [] hargaData;
    String [] unitData;
    TypedArray imgData;
    TextView titleToolbar;
    RecyclerView rv;
    ItemAdapter adapter;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent);
        toolbar = findViewById(R.id.toolbarrent);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        titleToolbar = findViewById(R.id.items_title_toolbar);
        titleToolbar.setText("Sewa Alat");

        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_arrow_back_black_24dp));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RentActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        rv = findViewById(R.id.rvitems);
        adapter = new ItemAdapter(this);
        rv.setHasFixedSize(true);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));

        prepare();
        addItem();

        adapter.setOnItemClickListener(new ItemAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Items mItems = new Items();
                mItems.setImg(imgData.getResourceId(position,-1));
                mItems.setNama(namaData[position]);
                mItems.setHarga(hargaData[position]);
                mItems.setKota(kotaData[position]);
                mItems.setJam(jamdata[position]);
                mItems.setUnit(unitData[position]);
                Intent pindahDetail = new Intent(getApplicationContext(),DetailRentActivity.class);
                pindahDetail.putExtra("data",mItems);
                startActivity(pindahDetail);
            }
        });
    }

    public void prepare(){
        unitData = getResources().getStringArray(R.array.rent_unit);
        imgData = getResources().obtainTypedArray(R.array.rent_image);
        namaData = getResources().getStringArray(R.array.rent_name);
        hargaData = getResources().getStringArray(R.array.rent_harga);
        kotaData = getResources().getStringArray(R.array.rent_kota);
        jamdata = getResources().getStringArray(R.array.rent_jam);
    }

    public void addItem(){
        ArrayList<Items> mItems = new ArrayList<>();
        for (int x = 0; x<namaData.length;x++){
            Items rentItems = new Items();
            rentItems.setImg(imgData.getResourceId(x,-1));
            rentItems.setNama(namaData[x]);
            rentItems.setJam(jamdata[x]);
            rentItems.setKota(kotaData[x]);
            rentItems.setHarga(hargaData[x]);
            mItems.add(rentItems);
        }
        adapter.setRentItems(mItems);
    }
}
