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
        adapter = new SuperMarioViewAdapter(data, getContext());
        binding.recyclerViewSuperMario.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerViewSuperMario.setAdapter(adapter);

    }

    private void loadPJ() {
        data = new ArrayList<>();
        data.add(new SuperMarioData(R.drawable.mario,"Mario Mario",
                "es el protagonista de la serie de videojuegos Super Mario y la mascota " +
                        "de Nintendo. Fue creado por Shigeru Miyamoto en 1981 " +
                        "e hizo su primera aparición en el videojuego arcade Donkey Kong. " +
                        "Es un fontanero estadounidense de origen italiano que actualmente vive en " +
                        "el Reino Champiñón. Como el héroe que es, se encarga de salvar a la gente, " +
                        "especialmente a la Princesa Peach, a quien ha salvado muchísimas veces de las " +
                        "garras del temible Bowser, quien es su archi-enemigo","La habilidad más " +
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