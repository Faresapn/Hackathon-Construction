package com.example.digitalconstruction.Calendar;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class Kembali extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Calendar c1 = Calendar.getInstance();
        int year = c1.get(Calendar.YEAR);
        int month = c1.get(Calendar.MONTH);
        int day =  c1.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(), (DatePickerDialog.OnDateSetListener) getActivity(), year,month,day);
    }

}
