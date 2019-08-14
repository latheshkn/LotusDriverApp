package com.example.drivercab.DriverBankDetailModel;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drivercab.Activities.DriverDocumentsActivity;
import com.example.drivercab.Activities.EditBankDetailsActivity;
import com.example.drivercab.R;

import java.util.List;

public class DriverBankDetailrecyclerAdapter extends RecyclerView.Adapter<DriverBankDetailrecyclerAdapter.Vhholder> {
    List<Bank> detailRecipes;

    public DriverBankDetailrecyclerAdapter(List<Bank> detailRecipes) {
        this.detailRecipes = detailRecipes;
    }

    @NonNull
    @Override
    public Vhholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.driverdocumentrecyclerviewitem,parent,false);
        return new DriverBankDetailrecyclerAdapter.Vhholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Vhholder holder, int position) {
        final Bank recipe = detailRecipes.get(position);
        holder.txtaccountno.setText(recipe.account_number);
        holder.txtifscno.setText(recipe.ifsc_code);
        holder.txtbanknameenter.setText(recipe.bank_name);

        holder.txtedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(holder.txtaccountno.getContext(), EditBankDetailsActivity.class);
                holder.txtaccountno.getContext().startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount()
    {
        return detailRecipes.size();
    }

    public class Vhholder extends RecyclerView.ViewHolder {
        TextView txtaccountno,txtifscno,txtbanknameenter,txtedit;
        public Vhholder(@NonNull View itemView) {
            super(itemView);
            txtaccountno=itemView.findViewById(R.id.txtaccountno);
            txtifscno=itemView.findViewById(R.id.txtifscno);
            txtbanknameenter=itemView.findViewById(R.id.txtbanknameenter);
            txtedit=itemView.findViewById(R.id.txtedit);


        }
    }
}
