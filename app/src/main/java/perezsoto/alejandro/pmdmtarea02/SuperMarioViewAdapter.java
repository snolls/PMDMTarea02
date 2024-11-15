package perezsoto.alejandro.pmdmtarea02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import perezsoto.alejandro.pmdmtarea02.databinding.SuperMarioCardviewBinding;

public class SuperMarioViewAdapter extends RecyclerView.Adapter<SuperMarioViewHolder> {

    private final ArrayList<SuperMarioData> supermarioList;
    private final Context context;

    public SuperMarioViewAdapter(ArrayList<SuperMarioData> supermarioList, Context context) {
        this.supermarioList = supermarioList;
        this.context = context;
    }


    @NonNull
    @Override
    public SuperMarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        SuperMarioCardviewBinding binding = SuperMarioCardviewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new SuperMarioViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SuperMarioViewHolder holder, int position) {
        SuperMarioData supermario = supermarioList.get(position);
        holder.bindTo(supermario);

        holder.itemView.setOnClickListener(view -> {
            itemClicked(supermario, view);
        });

    }

    @Override
    public int getItemCount() {
        return supermarioList.size();
    }

    private void itemClicked(SuperMarioData supermario, View view) {
        ((MainActivity)context).pJClicked(supermario, view);
    }
}
