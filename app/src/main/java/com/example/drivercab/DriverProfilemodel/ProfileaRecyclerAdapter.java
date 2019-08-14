package com.example.drivercab.DriverProfilemodel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drivercab.Activities.DriverDocumentsActivity;
import com.example.drivercab.Activities.DriverProfileActivity;
import com.example.drivercab.Activities.SharedPrefManager;
import com.example.drivercab.DriverBankDetailModel.Bank;
import com.example.drivercab.DriverBankDetailModel.DriverBankDetailrecyclerAdapter;
import com.example.drivercab.OtpVarificationModel.Otp;
import com.example.drivercab.R;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import static android.app.Activity.RESULT_OK;

public class ProfileaRecyclerAdapter extends RecyclerView.Adapter<ProfileaRecyclerAdapter.Vhadapter> {

  int  PICK_IMAGE=1;
    List<Profile> detailRecipes;

    public ProfileaRecyclerAdapter(List<Profile> detailRecipes) {
        this.detailRecipes = detailRecipes;
    }

    @NonNull
    @Override
    public Vhadapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.profilerecycleritem,parent,false);
        return new ProfileaRecyclerAdapter.Vhadapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Vhadapter holder, int position) {
        final Profile recipe = detailRecipes.get(position);
        holder.name.setText(recipe.name);
        holder.mobile.setText(recipe.mobile);
//        Otp otp = SharedPrefManager.getInstance(holder.constraintdriverdoc.getContext()).getUser();
//        String s =otp.getMobile();
//
//        holder.mobile.setText(s);



       holder.constraintdriverdoc.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(holder.constraintdriverdoc.getContext(), DriverDocumentsActivity.class);
               holder.constraintdriverdoc.getContext().startActivity(intent);
           }
       });
    }


    @Override
    public int getItemCount() {
        return detailRecipes.size();
    }

    public class Vhadapter extends RecyclerView.ViewHolder {
    TextView name,mobile;
        ConstraintLayout constraintdriverdoc, constraintprofile;
        public Vhadapter(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            mobile=itemView.findViewById(R.id.mobile);
            constraintprofile = itemView.findViewById(R.id.constraintprofile);
            constraintdriverdoc = itemView.findViewById(R.id.constraintdriverdoc);

        }
    }


}
