package perezsoto.alejandro.pmdmtarea02;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import perezsoto.alejandro.pmdmtarea02.databinding.FragmentDetailsBinding;

public class DetailsFragment extends Fragment {

    private FragmentDetailsBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Usar ViewBinding para inflar el diseño
        binding = FragmentDetailsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        
        // Obtener los datos del Bundle
        if (getArguments() != null) {
            String name = getArguments().getString("name", "Sin nombre");

            // Muestra el Toast con el nombre del personaje
            Toast.makeText(this.requireContext(),
                    "Se ha seleccionado el personaje " + name,
                    Toast.LENGTH_LONG).show();

            int imageResId = getArguments().getInt("image", -1);
            String description = getArguments().getString("description", "Sin descripción");
            String abilities = getArguments().getString("abilities", "Sin habilidades");

            // Configurar las vistas con los datos
            binding.nameViewDetails.setText(name);
            binding.descriptionViewDetails.setText(description);
            binding.abilitiesViewDetails.setText(abilities);
            if (imageResId != -1) {
                binding.imageViewDetails.setImageResource(imageResId);
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}