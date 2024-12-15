package perezsoto.alejandro.pmdmtarea02;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Objects;

import perezsoto.alejandro.pmdmtarea02.databinding.FragmentMainBinding;

/**
 * La clase MainFragment representa el fragmento principal de la aplicación.
 * Se encarga de mostrar una lista de personajes y permite la navegación entre fragmentos.
 */
public class MainFragment extends Fragment {

    private FragmentMainBinding binding;
    private ArrayList<Item> itemList;
    private NavController navController;

    /**
     * Método onCreate que se ejecuta cuando se crea el fragmento.
     *
     * @param savedInstanceState Bundle que contiene el estado guardado del fragmento.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * Infla la vista de este fragmento.
     *
     * @param inflater Objeto LayoutInflater para inflar la vista.
     * @param container ViewGroup padre que contiene la vista.
     * @param savedInstanceState Bundle con el estado guardado de la vista.
     * @return La vista inflada para el fragmento.
     */
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMainBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    /**
     * Método que se llama cuando la vista se ha creado completamente.
     *
     * @param view La vista creada para el fragmento.
     * @param savedInstanceState Bundle con el estado guardado de la vista.
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Crear Lista con los datos
        createData();

        // Muestra el Snackbar después de cargar la lista
        Snackbar.make(
                binding.recyclerView,
                "Bienvenidos al mundo de Mario",
                Snackbar.LENGTH_LONG
        ).show();

        // Configurar el RecyclerView
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
        MyAdapter adapter = new MyAdapter(itemList, navController);
        binding.recyclerView.setAdapter(adapter);
    }

    /**
     * Crea la lista de datos para los personajes.
     */
    private void createData() {
        itemList = new ArrayList<>();
        itemList.add(new Item(getString(R.string.mario_name), R.drawable.mario, getString(R.string.description_mario), getString(R.string.abilities_mario)));
        itemList.add(new Item(getString(R.string.luigi_name), R.drawable.luigi, getString(R.string.description_luigi), getString(R.string.abilities_luigi)));
        itemList.add(new Item(getString(R.string.peach_name), R.drawable.peach, getString(R.string.description_peach), getString(R.string.abilities_peach)));
        itemList.add(new Item(getString(R.string.yoshi_name), R.drawable.yoshi, getString(R.string.description_yoshi), getString(R.string.abilities_yoshi)));
        itemList.add(new Item(getString(R.string.toad_name), R.drawable.toad, getString(R.string.description_toad), getString(R.string.abilities_toad)));
        itemList.add(new Item(getString(R.string.waluigi_name), R.drawable.waluigi, getString(R.string.description_waluigi), getString(R.string.abilities_waluigi)));
        itemList.add(new Item(getString(R.string.warrio_name), R.drawable.warrio, getString(R.string.description_warrio), getString(R.string.abilities_warrio)));
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
