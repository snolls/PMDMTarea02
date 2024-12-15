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

/**
 * La clase DetailsFragment se encarga de mostrar los detalles de un elemento seleccionado de la lista.
 * Presenta información sobre el nombre, la descripción, las habilidades y la imagen del elemento.
 */
public class DetailsFragment extends Fragment {

    private FragmentDetailsBinding binding;

    /**
     * Infla la vista del fragmento de detalles.
     *
     * @param inflater Objeto LayoutInflater para inflar la vista.
     * @param container ViewGroup que contiene la vista.
     * @param savedInstanceState Bundle que contiene el estado guardado de la vista.
     * @return La vista inflada del fragmento.
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentDetailsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    /**
     * Se ejecuta cuando la vista ha sido creada.
     *
     * @param view La vista creada para el fragmento.
     * @param savedInstanceState Bundle con el estado guardado de la vista.
     */
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

    /**
     * Se llama cuando la vista del fragmento se destruye.
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
