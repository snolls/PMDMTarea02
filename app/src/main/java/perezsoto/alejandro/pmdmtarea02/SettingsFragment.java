package perezsoto.alejandro.pmdmtarea02;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Locale;

import perezsoto.alejandro.pmdmtarea02.databinding.FragmentSettingsBinding;

/**
 * La clase SettingsFragment permite al usuario configurar las preferencias de la aplicación.
 * En esta clase, los usuarios pueden cambiar el idioma de la aplicación.
 */
public class SettingsFragment extends Fragment {

    private static final String PREFS_NAME = "AppPrefs";
    private static final String LANGUAGE_KEY = "language";

    private FragmentSettingsBinding binding;

    /**
     * Infla la vista para el fragmento de configuración.
     *
     * @param inflater Objeto LayoutInflater para inflar la vista.
     * @param container ViewGroup que contiene la vista.
     * @param savedInstanceState Bundle que contiene el estado guardado de la vista.
     * @return La vista inflada del fragmento.
     */
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSettingsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    /**
     * Se ejecuta cuando la vista ha sido creada.
     *
     * @param view La vista creada para el fragmento.
     * @param savedInstanceState Bundle con el estado guardado de la vista.
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Cargar el idioma actual desde SharedPreferences
        SharedPreferences prefs = requireActivity().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String languageCode = prefs.getString(LANGUAGE_KEY, "es"); // Español por defecto

        // Configurar el estado del switch según el idioma
        binding.switchLanguage.setChecked("en".equals(languageCode));

        // Escuchar cambios en el SwitchCompat
        binding.switchLanguage.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /**
             * Controla los cambios en el SwitchCompat para cambiar el idioma de la aplicación.
             *
             * @param buttonView El SwitchCompat que se ha pulsado.
             * @param isChecked Indica si el SwitchCompat está activado o desactivado.
             */
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    changeLanguage("en"); // Cambiar a inglés
                } else {
                    changeLanguage("es"); // Cambiar a español
                }
            }
        });
    }

    /**
     * Cambia el idioma de la aplicación y reinicia la actividad principal para aplicar los cambios.
     *
     * @param languageCode El código de idioma que se aplicará (por ejemplo, "es" para español, "en" para inglés).
     */
    private void changeLanguage(String languageCode) {
        // Guardar el idioma en SharedPreferences
        SharedPreferences prefs = requireActivity().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(LANGUAGE_KEY, languageCode);
        editor.apply();

        // Cambiar la configuración de idioma
        setLocale(languageCode);

        // Reiniciar la actividad para aplicar el nuevo idioma
        requireActivity().recreate();
    }

    /**
     * Establece la configuración de idioma para la aplicación.
     *
     * @param languageCode El código de idioma que se aplicará.
     */
    private void setLocale(String languageCode) {
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.setLocale(locale);
        requireActivity().getResources().updateConfiguration(config, requireActivity().getResources().getDisplayMetrics());
    }

    /**
     * Se llama cuando la vista del fragmento se destruye.
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null; // Evitar pérdidas de memoria
    }
}
