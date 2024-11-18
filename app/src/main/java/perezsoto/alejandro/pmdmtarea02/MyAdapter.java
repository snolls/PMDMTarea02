package perezsoto.alejandro.pmdmtarea02;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import perezsoto.alejandro.pmdmtarea02.databinding.ItemCardBinding;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private ArrayList<Item> itemList;
    private NavController navController;

    public MyAdapter(ArrayList<Item> itemList, NavController navController) {
        this.itemList = itemList;
        this.navController = navController;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new MyViewHolder(ItemCardBinding.inflate(android.view.LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Item item = this.itemList.get(position);
        holder.bind(item);

        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("itemList", itemList );

                navController.navigate(R.id.action_mainFragment_to_detailsFragment, bundle);

            }
        });


    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
