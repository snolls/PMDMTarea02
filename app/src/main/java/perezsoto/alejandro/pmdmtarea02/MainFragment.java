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
        itemList.add(new Item(getString(R.string.luigi_name), R.drawable.luigi, getString(R.string.description_luigi), getString(R.string.abilities_luigi)));
        itemList.add(new Item(getString(R.string.peach_name), R.drawable.peach, getString(R.string.description_peach), getString(R.string.abilities_peach)));
        itemList.add(new Item(getString(R.string.yoshi_name), R.drawable.yoshi, getString(R.string.description_yoshi), getString(R.string.abilities_yoshi)));
        itemList.add(new Item(getString(R.string.toad_name), R.drawable.toad, getString(R.string.description_toad), getString(R.string.abilities_toad)));
        itemList.add(new Item(getString(R.string.waluigi_name), R.drawable.waluigi, getString(R.string.description_waluigi), getString(R.string.abilities_waluigi)));
        itemList.add(new Item(getString(R.string.warrio_name), R.drawable.warrio, getString(R.string.description_warrio), getString(R.string.abilities_warrio)));

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}