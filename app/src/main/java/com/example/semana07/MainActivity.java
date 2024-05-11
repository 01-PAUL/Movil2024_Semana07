package com.example.semana07;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Spinner spnSelector;

    String [] arreglos = {"Cuando empezamos a jugar, teníamos 90 minutos para demostrar quién era el mejor. Ahora, solo tienes 90 minutos para demostrar que no eres el peor.",
                          "Mi motivación siempre ha sido ser el mejor que puedo ser, concentrarme en mis propios objetivos y seguir adelante, sin importar lo que digan los demás.",
                          "Siempre es difícil seguir adelante cuando te equivocas, pero eso es parte del juego. Tienes que aceptar tus errores y seguir adelante."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        spnSelector = findViewById(R.id.spnSelector);
        spnSelector.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 1://Orange
                        Intent x = new Intent(MainActivity.this, OrangeActivity.class);
                        x.putExtra("DATA_FRASE_CELEBRES",arreglos[0]);
                        startActivity(x);
                        break;
                    case 2://Blue
                        Intent y = new Intent(MainActivity.this, BlueActivity.class);
                        y.putExtra("DATA_FRASE_CELEBRES",arreglos[1]);
                        startActivity(y);
                        break;
                    case 3://Green
                        Intent z = new Intent(MainActivity.this, GreenActivity.class);
                        z.putExtra("DATA_FRASE_CELEBRES",arreglos[2]);
                        startActivity(z);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
    public void mensajeAlert(String titulo, String msg){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setMessage(msg);
        alertDialog.setTitle(titulo);
        alertDialog.setCancelable(true);
        alertDialog.show();
    }

    public void mensajeAlert(String msg){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setMessage(msg);
        alertDialog.setCancelable(true);
        alertDialog.show();
    }

    void mensajeToast(String mensaje){
        Toast toast1 =  Toast.makeText(getApplicationContext(),mensaje, Toast.LENGTH_LONG);
        toast1.show();
    }


}