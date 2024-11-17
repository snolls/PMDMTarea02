package perezsoto.alejandro.pmdmtarea02;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import perezsoto.alejandro.pmdmtarea02.databinding.FragmentMainBinding;


public class MainFragment extends Fragment {

    private FragmentMainBinding binding;
    private ArrayList<Item> itemList;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMainBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Crear algunos datos de ejemplo
        itemList = new ArrayList<>();
        itemList.add(new Item("Title 1",R.drawable.mario , "Description 1", "Abilities 1"));
        itemList.add(new Item("Title 2",R.drawable.luigi, "Description 2", "Abilities 2"));

        // Configurar el RecyclerView
        MyAdapter adapter = new MyAdapter(itemList,getActivity());
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.setAdapter(adapter);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}