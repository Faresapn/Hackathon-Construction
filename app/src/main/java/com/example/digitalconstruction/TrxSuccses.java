package com.example.digitalconstruction;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.digitalconstruction.activity.RentActivity;

public class TrxSuccses extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trx_succses);

        Thread thread = new Thread() {
            public void run(){
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    startActivity(new Intent(TrxSuccses.this, RentActivity.class));
                    finish();
                }
            }
        };
        thread.start();
    }
}
