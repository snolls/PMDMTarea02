package perezsoto.alejandro.pmdmtarea02;

import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageSwitcher;

import androidx.core.content.ContextCompat;
import androidx.navigation.NavController;
import androidx.palette.graphics.Palette;
import androidx.recyclerview.widget.RecyclerView;

import perezsoto.alejandro.pmdmtarea02.databinding.ItemCardBinding;

public class MyViewHolder extends RecyclerView.ViewHolder {
    private final ItemCardBinding binding;


    public MyViewHolder(ItemCardBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(Item item, NavController navController) {
        // Configurar las vistas con los datos del Item
        binding.image.setImageResource(item.getImage());
        binding.tvname.setText(item.getName());

        binding.getRoot().setOnClickListener(new View.OnClickListener() {

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
