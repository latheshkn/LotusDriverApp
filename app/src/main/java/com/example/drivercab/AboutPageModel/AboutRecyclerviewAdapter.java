package com.example.drivercab.AboutPageModel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drivercab.R;

import java.util.List;

public class AboutRecyclerviewAdapter extends RecyclerView.Adapter<AboutRecyclerviewAdapter.Vhholder> {
    List<About> detailRecipes;

    public AboutRecyclerviewAdapter(List<About> detailRecipes) {
        this.detailRecipes = detailRecipes;
    }

    @NonNull
    @Override
    public Vhholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycleraboutitem,parent,false);
        return new Vhholder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull Vhholder holder, int position) {
        final About recipe = detailRecipes.get(position);
        holder.textView.setText(recipe.getDetail());
    }



    @Override
    public int getItemCount() {
        return detailRecipes.size();
    }

    public class Vhholder extends RecyclerView.ViewHolder {
        TextView textView;
        public Vhholder(@NonNull View itemView) {
            super(itemView);

            textView=itemView.findViewById(R.id.txtabout);
        }
    }

}
