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


public class MainFragment extends Fragment {

    private FragmentMainBinding binding;
    private ArrayList<Item> itemList;
    private NavController navController;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentMainBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Crear Lista con los datos

        createData();

        // Muestra el Snackbar después de cargar la lista
        Snackbar.make(
                binding.recyclerView, // Vista raíz donde se mostrará el Snackbar
                "Bienvenidos al mundo de Mario", // Mensaje del Snackbar
                Snackbar.LENGTH_LONG // Duración del mensaje
        ).show();


        // Configurar el RecyclerView
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
        MyAdapter adapter = new MyAdapter(itemList, navController);
        binding.recyclerView.setAdapter(adapter);

    }


    private void createData() {

        itemList = new ArrayList<>();
        itemList.add(new Item(getString(R.string.mario_name), R.drawable.mario, getString(R.string.description_mario), getString(R.string.abilities_mario)));
        itemList.add(new Item("Luigi Mario", R.drawable.luigi, "Description 2", "Abilities 2"));
        itemList.add(new Item("Princesa Peach", R.drawable.peach, "Description 1", "Abilities 1"));
        itemList.add(new Item("Yoshi", R.drawable.yoshi, "Description 2", "Abilities 2"));
        itemList.add(new Item("Toad", R.drawable.toad, "Description 1", "Abilities 1"));
        itemList.add(new Item("Waluigi", R.drawable.waluigi, "Description 2", "Abilities 2"));
        itemList.add(new Item("Warrio", R.drawable.warrio, "Description 1", "Abilities 1"));

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}