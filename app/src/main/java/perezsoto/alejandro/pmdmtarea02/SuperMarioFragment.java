package perezsoto.alejandro.pmdmtarea02;

import android.os.Bundle;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import perezsoto.alejandro.pmdmtarea02.databinding.FragmentSuperMarioBinding;


public class SuperMarioFragment extends Fragment {

    private FragmentSuperMarioBinding binding;
    private ArrayList<SuperMarioData> data;
    private SuperMarioViewAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSuperMarioBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadPJ();

        // Configurar el RecyclerView
        adapter = new SuperMarioViewAdapter(data, requireContext());
        binding.recyclerViewSuperMario.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.recyclerViewSuperMario.setAdapter(adapter);

    }

    private void loadPJ() {
        data = new ArrayList<>();
        data.add(new SuperMarioData(R.drawable.mario,
                "Mario Mario",
                "Mario (anteriormente conocido como Jumpman, y desarrollado bajo el " +
                        "sobrenombre Sr. Video), es la mascota de Nintendo y el protagonista " +
                        "principal de la franquicia de Mario. Mario hizo su primera aparición como " +
                        "el protagonista del juego de arcade Donkey Kong, lanzado en 1981. Desde " +
                        "Super Mario Bros., sus habilidades han sido sus poderes de saltos y pisotones, " +
                        "con los que derrota a la mayoría de sus enemigos; y su habilidad para ganar " +
                        "poderes con una plétora de elementos, como el Súper Champiñon, la Flor de " +
                        "Fuego y la Súper Estrella. Los juegos generalmente han retratado a Mario " +
                        "como un personaje silencioso sin una personalidad distinta (Fortune Street " +
                        "es una excepción notable). De acuerdo con la filosofía de Nintendo, esto " +
                        "permite que Mario encaje en muchos géneros y roles diferentes. En la mayoría " +
                        "de los juegos, es el héroe que va en una aventura para salvar a la Princesa " +
                        "Peach de su archienemigo, Bowser, pero se le ha mostrado realizando muchas " +
                        "otras actividades además de aventurarse, como competir y hacer deportes con " +
                        "su hermano gemelo menor y otros.",
                "La habilidad más " +
                "notable de Mario es su Salto, que es su movimiento básico en el que confía " +
                "para derrotar a los enemigos, evitar obstáculos y activar objetos útiles como " +
                "Bloques e Interruptores P. Aunque Luigi tiene saltos superiores, Mario es más " +
                "conocido. También es capaz de realizar varias maniobras acrobáticas, como el" +
                " Salto largo, el Retroceso, el Salto Giro y el Salto escalada, siendo el Salto " +
                "escalada una de sus habilidades más recurrentes. Mario también puede usar una " +
                "variedad de ataques de artes marciales básicas, incluyendo golpes y patadas; a " +
                "pesar de que en la mayoría de los juegos, el salto es su principal forma de ataque. " +
                "La principal arma de Mario es el Martillo en Donkey Kong, aunque Mario a menudo usa " +
                "el Martillo como un arma en los juegos de rol de Mario."));
    }
}