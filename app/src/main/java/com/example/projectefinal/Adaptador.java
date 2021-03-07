package com.example.projectefinal;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Adaptador extends ArrayAdapter
{
    private Context Context;
    private List<Game> games;

    public Adaptador(@NonNull Context context, int resource, @NonNull ArrayList<Game> objects)
    {
        super(context, resource, objects);
        this.Context = context;
        this.games = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        //Añadir juego
        Game game = games.get(position);
        LayoutInflater inflater = (LayoutInflater)Context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.layout_game, null);

        TextView textTittle = (TextView) view.findViewById(R.id.titol);
        TextView textCategory =  (TextView) view.findViewById(R.id.categoria);
        TextView textAny =  (TextView) view.findViewById(R.id.any);
        RatingBar ratingBar = (RatingBar) view.findViewById(R.id.ratingBar);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);

        textTittle.setText(game.getTitol());
        textCategory.setText(game.getCategoria());
        textAny.setText(game.getAny());
        ratingBar.setRating(Float.valueOf(game.getValoracio()));
        imageView.setImageResource(game.getImg());

        return view;
    }

}
