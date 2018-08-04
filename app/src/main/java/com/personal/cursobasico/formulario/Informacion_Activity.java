package com.personal.cursobasico.formulario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Informacion_Activity extends AppCompatActivity {

    TextView nombre, apellido, email, cumple, animal, juego;

    ListView amigos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_);
        amigos = findViewById(R.id.showfriends);
        nombre = findViewById(R.id.showname);

        apellido= findViewById(R.id.showlastname);

        email = findViewById(R.id.showemail);

        cumple = findViewById(R.id.showbirthday);

        animal = findViewById(R.id.showfavoriteanimal);

        juego = findViewById(R.id.showfavoritegames);


        Intent loquesea=getIntent();

        Bundle bundle= loquesea.getBundleExtra("bundle");

        nombre.setText(bundle.getString("Nombre"));
        apellido.setText(bundle.getString("Apellido"));
        email.setText(bundle.getString("Email"));
        cumple.setText(bundle.getString("FechaDeNacimiento"));
        animal.setText(bundle.getString("animal"));
        juego.setText(bundle.getString("Juego_selecionado"));

        ArrayList<String> amg = (ArrayList<String>) getIntent().getSerializableExtra("amigos");

         amigos.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,amg));
    }

}
