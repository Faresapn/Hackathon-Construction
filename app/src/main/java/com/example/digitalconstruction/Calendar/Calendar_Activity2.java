package com.example.digitalconstruction.Calendar;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import com.example.digitalconstruction.R;

import java.text.DateFormat;
import java.util.Calendar;

public class Calendar_Activity2 extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_2);

        View button1 = findViewById(R.id.card22);

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
                Intent intent = new Intent(getApplicationContext(), Calendar_Activity2.class);
                startActivity(intent);
            }
        });


    }
    public void onDateSet(DatePicker view, int year, int month, int day){
        Calendar c1 = Calendar.getInstance();
        c1.set(Calendar.YEAR, year);
        c1.set(Calendar.MONTH,month);
        c1.set(Calendar.DAY_OF_MONTH, day);
        String current1 = DateFormat.getDateInstance(DateFormat.FULL).format(c1.getTime());

        TextView date1 = findViewById(R.id.date1);
        date1.setText(current1);
    }
}
