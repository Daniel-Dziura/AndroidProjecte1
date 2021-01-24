package com.example.android_projecte;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.pierfrancescosoffritti.androidyoutubeplayer.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.player.YouTubePlayerView;
import com.pierfrancescosoffritti.androidyoutubeplayer.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.player.listeners.YouTubePlayerInitListener;

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

        Button joutube = findViewById(R.id.joutube);
        joutube.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        openWeb();
    }

    public void openWeb() {
        Intent i = getIntent();
        Game gameL = i.getParcelableExtra("Pelicula");
        String videoURL = gameL.getVideoURL();

        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(videoURL));
        startActivity(browserIntent);
    }
}