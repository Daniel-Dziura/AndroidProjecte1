package com.example.android_projecte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    private ListView lv;
    private Button bt;
    private ArrayList<Game> gamesList = new ArrayList<>();
    public static final int CODI_PETICIO = 1;
    public Adaptador gameAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Añadir objetos Game al ArrayList
        gamesList.add(new Game(1, "Grand Theft Auto V", "2015", "Accion, Aventura, FPS", "5", R.drawable.gta, "Rockstar"));
        gamesList.add(new Game(2, "Cyberpunk 2077", "2020", "Aventura, FPS, RPG", "4", R.drawable.cyberpunk, "CD Projekt RED"));
        gamesList.add(new Game(3, "Forza Horizon 4", "2019", "Carreras, Deporte", "3", R.drawable.forza, "Microsoft"));
        gamesList.add(new Game(4, "Dead by Daylight", "2019", "Acción, Cooperación, Multijugador", "4", R.drawable.dead, "Microsoft"));

        lv = findViewById(R.id.idLlista);
        bt = findViewById(R.id.btGame);

        //Añadir lista de juegos al layout_games
        gameAdapter = new Adaptador(this, R.layout.layout_game, gamesList);
        lv.setAdapter(gameAdapter);


        //onClick Listener para lista de juegos
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(view.getContext(), Detalles.class);
                i.putExtra("Pelicula", gamesList.get(position));
                startActivity(i);
            }
        });

        //onClick para añadir juego
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AddGame.class);
                startActivityForResult(intent, CODI_PETICIO);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(CODI_PETICIO==requestCode && resultCode == RESULT_OK)
        {
            //Actualizar la lista con el juego nuevo
            Game game = data.getParcelableExtra("novaPeli");
            gamesList.add(game);
            gameAdapter.notifyDataSetChanged();
        }
    }}