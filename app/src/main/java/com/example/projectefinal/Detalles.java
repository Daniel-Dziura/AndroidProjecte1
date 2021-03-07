package com.example.projectefinal;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Detalles extends AppCompatActivity implements View.OnClickListener {

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

        TextView preuSteam = findViewById(R.id.preuSteam);
        preuSteam.setText(game.getSteamPrice()+"$");
        TextView preuG2 = findViewById(R.id.g2aPrice);
        preuG2.setText(game.getG2aPrice()+"$");
        TextView preuinst = findViewById(R.id.instantPrice);
        preuinst.setText(game.getIgPrice()+"$");

        Button joutube = findViewById(R.id.joutube);
        joutube.setOnClickListener(this);

        Button bt2 = findViewById(R.id.buttSteam);
        bt2.setOnClickListener(this);

        Button bt3 = findViewById(R.id.buttG2a);
        bt3.setOnClickListener(this);

        Button bt4 = findViewById(R.id.buttInstant);
        bt4.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        Intent intent = getIntent();
        Game game = intent.getParcelableExtra("Pelicula");
        //String videoURL = game.getVideoURL();

        switch(v.getId()){

            case R.id.joutube:
                openWeb(game.getVideoURL());
                break;
            case R.id.buttSteam:
                openWeb(game.getSteamURL());
                break;
            case R.id.buttG2a:
                openWeb(game.getG2aURL());
                break;
            case R.id.buttInstant:
                openWeb(game.getIgPrice());
                break;
        }
    }

    public void openWeb(String url) {
        Intent i = getIntent();
        Game gameL = i.getParcelableExtra("Pelicula");
        String videoURL = gameL.getVideoURL();

        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(browserIntent);
    }
}