package perezsoto.alejandro.pmdmtarea02;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;

import java.util.Locale;

import perezsoto.alejandro.pmdmtarea02.databinding.FragmentSettingsBinding;

public class SettingsFragment extends Fragment {

    private FragmentSettingsBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Inflar el layout usando ViewBinding
        binding = FragmentSettingsBinding.inflate(inflater, container, false);

        // Configurar el Switch de idioma
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(requireContext());
        String currentLanguage = preferences.getString("language", "es");

        // Configurar el estado inicial del Switch
        binding.switchLanguage.setChecked("en".equals(currentLanguage));

        // Manejar el cambio de idioma cuando el Switch cambia de estado
        binding.switchLanguage.setOnCheckedChangeListener((buttonView, isChecked) -> {
            String newLanguage = isChecked ? "en" : "es";
            setLocale(newLanguage);

            // Guardar la selección en SharedPreferences
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("language", newLanguage);
            editor.apply();

            // Recargar la actividad para aplicar el cambio de idioma
            requireActivity().recreate();
        });

        return binding.getRoot();
    }

    private void setLocale(String languageCode) {
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.setLocale(locale);
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null; // Evitar fugas de memoria
    }
}
