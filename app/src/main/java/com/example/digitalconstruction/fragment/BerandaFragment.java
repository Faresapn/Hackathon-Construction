package com.example.digitalconstruction.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.digitalconstruction.R;
import com.example.digitalconstruction.activity.RentActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class BerandaFragment extends Fragment {

    CardView cd ;
    public BerandaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v;
        v = inflater.inflate(R.layout.fragment_beranda, container, false);
        cd = v.findViewById(R.id.shop);
        cd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), RentActivity.class);
                startActivity(intent);
            }
        });

        return v;




    }

}
