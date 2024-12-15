package perezsoto.alejandro.pmdmtarea02;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import perezsoto.alejandro.pmdmtarea02.databinding.ItemCardBinding;

/**
 * La clase MyAdapter actúa como un adaptador para el RecyclerView.
 * Su propósito es vincular los datos de una lista de objetos Item con las vistas que se muestran en el RecyclerView.
 */
public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private ArrayList<Item> itemList;
    private NavController navController;

    /**
     * Constructor de la clase MyAdapter.
     *
     * @param itemList Lista de objetos Item que se mostrarán en el RecyclerView.
     * @param navController Controlador de navegación para gestionar la navegación entre fragmentos.
     */
    public MyAdapter(ArrayList<Item> itemList, NavController navController) {
        this.itemList = itemList;
        this.navController = navController;
    }

    /**
     * Crea un nuevo ViewHolder cuando el RecyclerView lo necesite.
     *
     * @param parent El ViewGroup padre que contiene la vista.
     * @param viewType Tipo de vista que se va a crear.
     * @return Un nuevo MyViewHolder con la vista inflada.
     */
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(ItemCardBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    /**
     * Vincula los datos de un objeto Item a una vista especificada.
     *
     * @param holder El ViewHolder que se encargará de mostrar los datos.
     * @param position La posición del elemento dentro de la lista.
     */
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Item item = this.itemList.get(position);
        holder.bind(item, navController);
    }

    /**
     * Retorna la cantidad de elementos que hay en la lista de datos.
     *
     * @return El tamaño de la lista de elementos Item.
     */
    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
