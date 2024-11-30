package perezsoto.alejandro.pmdmtarea02;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import perezsoto.alejandro.pmdmtarea02.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private NavHostFragment navHostFragment;
    private NavController navController;
    private DrawerLayout drawerLayout;
    private AppBarConfiguration appBarConfiguration;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, appBarConfiguration) || super.onSupportNavigateUp();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu); // Infla el archivo de menú
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_about) { // El ID del ítem "Acerca de..."
            showAboutDialog();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // Método para mostrar el AlertDialog
    private void showAboutDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Acerca de")
                .setMessage("Aplicación desarrollada por Alejandro Perez Soto. Versión 1.0")
                .setPositiveButton("Aceptar", (dialog, which) -> dialog.dismiss())
                .show();
    }

}