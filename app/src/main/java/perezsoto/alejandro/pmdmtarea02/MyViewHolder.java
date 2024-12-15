package perezsoto.alejandro.pmdmtarea02;

import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.core.content.ContextCompat;
import androidx.navigation.NavController;
import androidx.palette.graphics.Palette;
import androidx.recyclerview.widget.RecyclerView;

import perezsoto.alejandro.pmdmtarea02.databinding.ItemCardBinding;

/**
 * La clase MyViewHolder representa una vista de elemento individual en un RecyclerView.
 * Su propósito es vincular y mostrar los datos de un objeto Item en la interfaz de usuario.
 */
public class MyViewHolder extends RecyclerView.ViewHolder {

    private final ItemCardBinding binding;

    /**
     * Constructor de la clase MyViewHolder.
     *
     * @param binding Objeto ItemCardBinding que proporciona acceso a las vistas en la interfaz de usuario.
     */
    public MyViewHolder(ItemCardBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    /**
     * Vincula los datos de un objeto Item a la vista correspondiente.
     *
     * @param item El objeto Item que contiene los datos que se mostrarán.
     * @param navController Controlador de navegación para gestionar la navegación entre fragmentos.
     */
    public void bind(Item item, NavController navController) {
        // Configurar las vistas con los datos del Item
        binding.image.setImageResource(item.getImage());
        binding.tvname.setText(item.getName());

        binding.getRoot().setOnClickListener(new View.OnClickListener() {
            /**
             * Controla el clic en el elemento y navega a la pantalla de detalles del elemento.
             *
             * @param view La vista que se ha hecho clic.
             */
            @Override
            public void onClick(View view) {
                if (navController != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("name", item.getName());
                    bundle.putInt("image", item.getImage());
                    bundle.putString("description", item.getDescription());
                    bundle.putString("abilities", item.getAbilities());
                    navController.navigate(R.id.action_mainFragment_to_detailsFragment, bundle);
                }
            }
        });

        // Generar el gradiente basado en la imagen
        binding.image.post(() -> {
            Bitmap bitmap = binding.image.getDrawingCache();
            if (bitmap != null) {
                Palette.from(bitmap).generate(palette -> {
                    if (palette != null) {
                        int vibrantColor = palette.getVibrantColor(
                                ContextCompat.getColor(binding.getRoot().getContext(), android.R.color.darker_gray));
                        int mutedColor = palette.getMutedColor(
                                ContextCompat.getColor(binding.getRoot().getContext(), android.R.color.darker_gray));

                        GradientDrawable gradient = new GradientDrawable(
                                GradientDrawable.Orientation.TOP_BOTTOM,
                                new int[]{vibrantColor, mutedColor});
                        gradient.setCornerRadius(16); // Opcional, redondear esquinas
                        binding.cardView.setBackground(gradient);
                    }
                });
            } else {
                Log.e("Palette", "No se pudo extraer el bitmap de la imagen.");
            }
        });

        binding.image.setDrawingCacheEnabled(true);
    }
}
