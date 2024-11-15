package perezsoto.alejandro.pmdmtarea02;


import androidx.recyclerview.widget.RecyclerView;

import perezsoto.alejandro.pmdmtarea02.databinding.SuperMarioCardviewBinding;


public class SuperMarioViewHolder extends RecyclerView.ViewHolder {

    private final SuperMarioCardviewBinding binding;
    public SuperMarioViewHolder(SuperMarioCardviewBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
    public void bindTo(SuperMarioData supermario) {
        binding.iVSuperMario.setImageResource(supermario.getImage());
        binding.tVSuperMario.setText(supermario.getName());
        binding.executePendingBindings();
    }
}
