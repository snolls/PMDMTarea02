package perezsoto.alejandro.pmdmtarea02;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import perezsoto.alejandro.pmdmtarea02.databinding.ItemCardBinding;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private ArrayList<Item> itemList;
    private final Context context;

    public MyAdapter(ArrayList<Item> itemList, Context context) {
        this.itemList = itemList;
        this.context = context;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemCardBinding binding = ItemCardBinding.inflate(inflater, parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Item item = this.itemList.get(position);
        Log.d("MyAdapter", "Binding item: " + item.getName());
        holder.bind(item);

        /*holder.itemView.setOnClickListener(view -> {
            // Manejar el clic en el elemento
            ((MainActivity) context).itemClicked(item,view);
        });*/


    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
