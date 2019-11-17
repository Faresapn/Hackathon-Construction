package com.example.digitalconstruction.Calendar;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.ParseException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import com.example.digitalconstruction.Data.Items;
import com.example.digitalconstruction.R;
import com.example.digitalconstruction.activity.DetailRentActivity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Calendar_Activity2 extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    TextView date;
    Long datekembali;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_2);
        date = findViewById(R.id.date1);

        View button1 = findViewById(R.id.card22);
        final Items detailitems = getIntent().getParcelableExtra("data");
        final long datepinjam = getIntent().getLongExtra("datepinjam",-1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment datePicker1 = new Kembali();
                datePicker1.show(getSupportFragmentManager(),"date picker1");
            }
        });
        Button buttonr = findViewById(R.id.rent);

        buttonr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Items mItems = new Items();
                mItems.setImg(detailitems.getImg());
                mItems.setNama(detailitems.getNama());
                mItems.setHarga(detailitems.getHarga());
                mItems.setKota(detailitems.getKota());
                mItems.setJam(detailitems.getJam());
                mItems.setUnit(detailitems.getUnit());

                Intent intent = new Intent(getApplicationContext(), Detail_Rent.class);
                intent.putExtra("data",mItems);

                intent.putExtra("datepinjam",datepinjam);
                intent.putExtra("datekembali",datekembali);

                startActivity(intent);
            }
        });


    }
    public void onDateSet(DatePicker view, int year, int month, int day){
        Calendar c1 = Calendar.getInstance();
        c1.set(Calendar.YEAR, year);
        c1.set(Calendar.MONTH,month);
        c1.set(Calendar.DAY_OF_MONTH, day);
        datekembali = c1.getTime().getTime();
        String current1 = DateFormat.getDateInstance(DateFormat.FULL).format(c1.getTime());

        date.setText(current1);
    }
}
