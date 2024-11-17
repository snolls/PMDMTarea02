package perezsoto.alejandro.pmdmtarea02;

import androidx.recyclerview.widget.RecyclerView;

import perezsoto.alejandro.pmdmtarea02.databinding.ItemCardBinding;

public class MyViewHolder extends RecyclerView.ViewHolder {
    private final ItemCardBinding binding;

    public MyViewHolder(ItemCardBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(Item item) {
        binding.image.setImageResource(item.getImage());
        binding.name.setText(item.getName());
        binding.executePendingBindings();
    }
}
