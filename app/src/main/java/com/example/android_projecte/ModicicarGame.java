package com.example.android_projecte;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ModicicarGame extends AppCompatActivity implements View.OnClickListener  {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_modificar);

        Intent intent = getIntent();

        Game game = intent.getParcelableExtra("Pelicula");

        String titol = game.getTitol();
        String categoria = game.getCategoria();
        String any = game.getAny();
        String valoracio = game.getValoracio();
        String director = game.getDesarollador();

        //EditText tit = findViewById(R.id.editTextTitolMod);
        //tit.setText(titol);
    }

    @Override
    public void onClick(View v) {

    }
}
