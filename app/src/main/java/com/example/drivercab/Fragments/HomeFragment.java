package com.example.drivercab.Fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.drivercab.Activities.AboutActivity;
import com.example.drivercab.Activities.BalanceAndPaymentActivity;
import com.example.drivercab.Activities.BankDetailsActivity;
import com.example.drivercab.Activities.CarProfileActivity;
import com.example.drivercab.Activities.ContactActivity;
import com.example.drivercab.Activities.DriverProfileActivity;
import com.example.drivercab.Activities.MapActivity;
import com.example.drivercab.Activities.SettingActivity;
import com.example.drivercab.Activities.Support;
import com.example.drivercab.Activities.WorkDetailsActivity;
import com.example.drivercab.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    CardView cardprofile, cardcontact, cardmap, cardbook, cardeducation, cardvehicle,aboutcard,incentivecard,supportcard;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        cardprofile=view.findViewById(R.id.driver_detail_cardview);
        cardcontact=view.findViewById(R.id.car_detail_cardview);
        cardmap=view.findViewById(R.id.fleet_cardview);
        cardbook=view.findViewById(R.id.money_cardview);
        cardeducation=view.findViewById(R.id.track_cardview);
        cardvehicle=view.findViewById(R.id.setting_cardview);
        aboutcard=view.findViewById(R.id.aboutcard);
        incentivecard=view.findViewById(R.id.incentivecard);
        supportcard=view.findViewById(R.id.supportcard);


        supportcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), Support.class);
                startActivity(intent);
            }
        });

        incentivecard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), ContactActivity.class);
                startActivity(intent);
            }
        });

        aboutcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), AboutActivity.class);
                startActivity(intent);
            }
        });

        cardvehicle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), SettingActivity.class);
                startActivity(intent);
            }
        });

        cardeducation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), MapActivity.class);
                startActivity(intent);
            }
        });

        cardbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), BankDetailsActivity.class);
                startActivity(intent);
            }
        });

        cardprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), DriverProfileActivity.class);
                startActivity(intent);

            }
        });
        cardcontact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), CarProfileActivity.class);
                startActivity(intent);

            }
        });
        cardmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), WorkDetailsActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

    }
