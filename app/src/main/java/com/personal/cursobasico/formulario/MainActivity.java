package com.personal.cursobasico.formulario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {
Amigos amigo ;

    EditText nombre, apellido, email , FN ;
    RadioGroup Seccion_Juegos;
   int Juego_Favorito;
   Spinner ElSpinner;
   String[]  animales= {"Perro","Gato","Jakes","Cerdos"};
   String juegoSeleccionado = null;
    private ArrayList<Amigos> amigos = new ArrayList<Amigos>();
    ArrayList<String> areglos = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ElSpinner = findViewById(R.id.animal);

        ArrayAdapter<String> adapteranimal= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,animales);
        adapteranimal.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ElSpinner.setAdapter(adapteranimal);
        nombre = findViewById(R.id.name);
        apellido = findViewById(R.id.lastName);
        email = findViewById(R.id.emsil);
        FN = findViewById(R.id.birthDat);
        Seccion_Juegos = findViewById(R.id.Lojuego);


        findViewById(R.id.agregar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText textAmigo = findViewById(R.id.amigoText);
                Calendar calendar = Calendar.getInstance();
                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                int minutes = calendar.get(Calendar.MINUTE);

                Date x = new Date();
                SimpleDateFormat eso = new SimpleDateFormat("hh:mm a");
                amigo = new Amigos(textAmigo.getText().toString(), eso.format(x));
                areglos.add(textAmigo.getText().toString());
            }
        });
        findViewById(R.id.enviar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Juego_Favorito = Seccion_Juegos.getCheckedRadioButtonId();
                switch (Juego_Favorito){
                    case 1: juegoSeleccionado="Fornite";
                        break;
                    case 2: juegoSeleccionado="Call of Duty";
                        break;
                    case 3: juegoSeleccionado="Minecraft";
                        break;
                }


                Intent in = new Intent(MainActivity.this, Informacion_Activity.class);

                Bundle mm = new Bundle();

                mm.putString("Nombre", nombre.getText().toString());
                mm.putString("Apellido", apellido.getText().toString());
                mm.putString("Email", email.getText().toString());
                mm.putString("FechaDeNacimiento", FN.getText().toString());
                mm.putString("animal",ElSpinner.getSelectedItem().toString());
                mm.putString("Juego_selecionado", juegoSeleccionado);
                in.putExtra("amigos",areglos);

                // in.putExtra("amigos",amigos);
                in.putExtra("bundle",mm);
                startActivity(in);

            }
        });
    }


}
