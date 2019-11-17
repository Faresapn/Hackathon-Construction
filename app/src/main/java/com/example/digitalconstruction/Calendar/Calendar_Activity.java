package com.example.digitalconstruction.Calendar;

import android.app.DatePickerDialog;
import android.content.Intent;
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

import java.text.DateFormat;
import java.util.Calendar;

public class Calendar_Activity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{
    TextView date;
    Long datepinjam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_activiry);

        View button = findViewById(R.id.card12);
        date = findViewById(R.id.date);
        final Items detailitems = getIntent().getParcelableExtra("data");
        Log.d("check",detailitems.getNama());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment datePicker = new Pinjam();
                datePicker.show(getSupportFragmentManager(),"date picker");
            }
        });
        Button button1 = findViewById(R.id.next);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Items mItems = new Items();
                mItems.setImg(detailitems.getImg());
                mItems.setNama(detailitems.getNama());
                mItems.setHarga(detailitems.getHarga());
                mItems.setKota(detailitems.getKota());
                mItems.setJam(detailitems.getJam());
                mItems.setUnit(detailitems.getUnit());
//                String datepinjam = date.getText().toString();
                Intent intent = new Intent(getApplicationContext(), Calendar_Activity2.class);
                intent.putExtra("data",mItems);
                intent.putExtra("datepinjam",datepinjam);
                startActivity(intent);
            }
        });

    }
    public void onDateSet(DatePicker view, int year, int month, int day){
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH,month);
        c.set(Calendar.DAY_OF_MONTH, day);
        datepinjam = c.getTime().getTime();
        String current = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());

        date.setText(current);

    }
}
