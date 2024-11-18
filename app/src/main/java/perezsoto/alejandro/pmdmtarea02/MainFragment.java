package perezsoto.alejandro.pmdmtarea02;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

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

        // Crear algunos datos de ejemplo

        createData();

        // Configurar el RecyclerView
        MyAdapter adapter = new MyAdapter(itemList,navController);
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }


    private void createData() {

        itemList = new ArrayList<>();
        itemList.add(new Item("Title 1",R.drawable.mario , "Description 1", "Abilities 1"));
        itemList.add(new Item("Title 2",R.drawable.luigi, "Description 2", "Abilities 2"));
        itemList.add(new Item("Title 1",R.drawable.mario , "Description 1", "Abilities 1"));
        itemList.add(new Item("Title 2",R.drawable.luigi, "Description 2", "Abilities 2"));
        itemList.add(new Item("Title 1",R.drawable.mario , "Description 1", "Abilities 1"));
        itemList.add(new Item("Title 2",R.drawable.luigi, "Description 2", "Abilities 2"));
        itemList.add(new Item("Title 1",R.drawable.mario , "Description 1", "Abilities 1"));
        itemList.add(new Item("Title 2",R.drawable.luigi, "Description 2", "Abilities 2"));

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}