package com.example.drivercab.CarProfileModel;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drivercab.Activities.CarDocumentActivity;
import com.example.drivercab.DriverBankDetailModel.Bank;
import com.example.drivercab.DriverBankDetailModel.DriverBankDetailrecyclerAdapter;
import com.example.drivercab.DriverProfilemodel.Profile;
import com.example.drivercab.R;

import java.util.List;

public class CarProfilerecyclerAdapter extends RecyclerView.Adapter<CarProfilerecyclerAdapter.Vhadapter> {
List<CarProfire> car;

    public CarProfilerecyclerAdapter(List<CarProfire> car) {
        this.car = car;
    }

    @NonNull
    @Override
    public Vhadapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.carrecyclerviewitem,parent,false);
        return new CarProfilerecyclerAdapter.Vhadapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Vhadapter holder, int position) {
        final CarProfire recipe = car.get(position);
        holder.txtmodel.setText(recipe.vehicle_model);
        holder.txtvehicleno.setText(recipe.vehicle_no);

        holder.constraintdocument.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(holder.txtvehicleno.getContext(), CarDocumentActivity.class);
                holder.txtmodel.getContext().startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return car.size();
    }

    public class Vhadapter extends RecyclerView.ViewHolder {
        TextView txtmodel,txtvehicleno;
        ConstraintLayout constraintdocument;
        public Vhadapter(@NonNull View itemView) {
            super(itemView);
            txtmodel=itemView.findViewById(R.id.txtmodel);
            txtvehicleno=itemView.findViewById(R.id.txtvehicleno);
            constraintdocument=itemView.findViewById(R.id.constraintdocument);

        }
    }
}
