package com.example.activitat12_lv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class Detalles extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_detalles);

        Intent intent = getIntent();

        Game game = intent.getParcelableExtra("Pelicula");

        int img2 = game.getImg();
        String titol2 = game.getTitol();
        String categoria2 = game.getCategoria();
        String any2 = game.getAny();
        String valoracio2 = game.getValoracio();
        String director = game.getDesarollador();

        ImageView imageView = findViewById(R.id.imageView);
        imageView.setImageResource(img2);

        TextView textTitol = findViewById(R.id.titulo);
        textTitol.setText(titol2);
        //TextView textAny = findViewById(R.id.any2);
        //textAny.setText(any2);
        TextView textCat = findViewById(R.id.descTxt);
        textCat.setText(categoria2);
        //TextView textDirector = findViewById(R.id.desar);
       // textDirector.setText(director);

        //RatingBar ratingBar = findViewById(R.id.ratingBar2);
        //ratingBar.setRating(Float.valueOf(valoracio2));
    }
}