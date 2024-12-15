package perezsoto.alejandro.pmdmtarea02;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.Locale;

import perezsoto.alejandro.pmdmtarea02.databinding.ActivityMainBinding;

/**
 * La clase MainActivity representa la actividad principal de la aplicación.
 * Se encarga de gestionar la navegación entre fragmentos y la configuración del idioma de la aplicación.
 */
public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private NavHostFragment navHostFragment;
    private NavController navController;
    private DrawerLayout drawerLayout;
    private AppBarConfiguration appBarConfiguration;

    private static final String PREFS_NAME = "AppPrefs";
    private static final String LANGUAGE_KEY = "language";

    /**
     * Método onCreate que se ejecuta cuando se crea la actividad.
     *
     * @param savedInstanceState Bundle que contiene el estado guardado de la actividad.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Cargar idioma desde SharedPreferences antes de establecer el diseño
        loadLanguagePreference();

        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Configurar Toolbar
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        // Obtener NavController y DrawerLayout
        navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        navController = navHostFragment.getNavController();
        drawerLayout = binding.drawerLayout;

        // Configurar AppBarConfiguration
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph())
                .setOpenableLayout(drawerLayout) // Vincular el DrawerLayout
                .build();

        // Vincular Toolbar con NavController y AppBarConfiguration
        NavigationUI.setupWithNavController(binding.toolbar, navController, appBarConfiguration);

        // Configurar NavigationView con NavController
        NavigationUI.setupWithNavController(binding.navView, navController);

        // Manejar selecciones del menú del Drawer
        binding.navView.setNavigationItemSelectedListener(item -> {
            if (item.getItemId() == R.id.nav_home) {
                navController.navigate(R.id.mainFragment);
            } else if (item.getItemId() == R.id.nav_settings) {
                navController.navigate(R.id.settingsFragment); // Abrir el fragmento de configuración
            }

            // Cerrar el Drawer después de la selección
            drawerLayout.closeDrawers();
            return true;
        });
    }

    /**
     * Carga el idioma almacenado en SharedPreferences.
     */
    private void loadLanguagePreference() {
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String languageCode = prefs.getString(LANGUAGE_KEY, "es"); // Español por defecto
        setLocale(languageCode);
    }

    /**
     * Configura la aplicación para usar el idioma seleccionado.
     *
     * @param languageCode El código de idioma a utilizar (por ejemplo, "es" para español, "en" para inglés).
     */
    private void setLocale(String languageCode) {
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.setLocale(locale);
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());
    }

    /**
     * Método que permite la navegación hacia arriba en la jerarquía de la aplicación.
     *
     * @return true si la navegación hacia arriba fue exitosa, de lo contrario llama al método de la superclase.
     */
    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, appBarConfiguration) || super.onSupportNavigateUp();
    }

    /**
     * Infla el menú de opciones cuando la actividad se crea.
     *
     * @param menu El objeto Menu donde se agregarán los elementos de menú.
     * @return true para mostrar el menú; de lo contrario, false.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu); // Infla el archivo de menú
        return true;
    }

    /**
     * Maneja las selecciones de los elementos del menú de opciones.
     *
     * @param item El elemento de menú seleccionado.
     * @return true si la acción fue manejada correctamente; de lo contrario, llama al método de la superclase.
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_about) { // El ID del ítem "Acerca de..."
            showAboutDialog();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Muestra un diálogo de "Acerca de" con información de la aplicación.
     */
    private void showAboutDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Acerca de")
                .setMessage("Aplicación desarrollada por Alejandro Perez Soto. Versión 1.0")
                .setPositiveButton("Aceptar", (dialog, which) -> dialog.dismiss())
                .show();
    }
}
