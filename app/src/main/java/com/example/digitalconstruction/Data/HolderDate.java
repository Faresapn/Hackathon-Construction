package com.example.digitalconstruction.Data;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.digitalconstruction.R;

public class HolderDate extends RecyclerView.ViewHolder {
    private TextView date;

    public TextView getDate() {
        return date;
    }

    public void setDate(TextView date) {
        this.date = date;
    }

    public HolderDate(View v) {
        super(v);
        date = v.findViewById(R.id.tv_date);


    }
}
