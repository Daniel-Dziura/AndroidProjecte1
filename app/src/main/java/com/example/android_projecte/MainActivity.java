package com.example.android_projecte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    private ListView lv;
    private FloatingActionButton bt;
    private ArrayList<Game> gamesList = new ArrayList<>();
    public static final int CODI_PETICIO = 1;
    public Adaptador gameAdapter;
    AyudaBBDD ayudaBBDD = new AyudaBBDD(MainActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            //Añadir objetos Game al ArrayList
            //gamesList.add(new Game(1, "Grand Theft Auto V", "2013", "Accion, Aventura, FPS", "5", R.drawable.gta, "Rockstar", "https://www.youtube.com/watch?v=AVBvKx6_AEs","https://store.steampowered.com/agecheck/app/271590/?l=spanish", "29,99", "https://www.g2a.com/es-es/grand-theft-auto-v-pc-rockstar-key-global-i10000000788017", "23,99", "https://www.instant-gaming.com/es/186-comprar-juego-rockstar-grand-theft-auto-v/", "22,00"));
            //gamesList.add(new Game(2, "Cyberpunk 2077", "2020", "Aventura, FPS, RPG", "4", R.drawable.cyberpunk, "CD Projekt RED", "https://www.youtube.com/watch?v=fATYs_oPJFk", "https://store.steampowered.com/agecheck/app/1091500/", "59,99", "https://www.g2a.com/es-es/cyberpunk-2077-gogcom-key-global-i10000156543001", "45,55", "https://www.instant-gaming.com/es/840-comprar-juego-gog-com-cyberpunk-2077/", "30,99"));
            //gamesList.add(new Game(3, "Forza Horizon 4", "2019", "Carreras, Deporte", "3", R.drawable.forza, "Microsoft", "https://www.youtube.com/watch?v=AhJJpLaJyoA", "https://store.steampowered.com/search?l=spanish&term=Forza+Horizon+4", "30,00", "https://www.g2a.com/es-es/forza-horizon-4-standard-edition-xbox-live-key-global-i10000156553001", "44,00", "https://www.instant-gaming.com/es/2682-comprar-juego-xbox-play-anywhere-forza-horizon-4-pc-xbox-one/", "22,99"));
            //gamesList.add(new Game(4, "Dead by Daylight", "2019", "Acción, Cooperación, Multijugador", "4", R.drawable.dead, "Microsoft", "https://www.youtube.com/watch?v=qj2MSFMsObc", "https://store.steampowered.com/agecheck/app/381210/?l=spanish", "33,00", "https://www.g2a.com/es/dead-by-daylight-steam-key-global-i10000018558012", "22,00", "https://www.instant-gaming.com/es/1904-comprar-juego-steam-dead-by-daylight/", "20,00"));
            //gamesList.add(new Game(5,"Dead Cells", "2017", "Acción, Roguelike, Sous-like", "4", R.drawable.cells, "Microsoft", "https://www.youtube.com/watch?v=gX4cGcwmdsY", "https://store.steampowered.com/app/588650/Dead_Cells/", "24,99", "https://www.g2a.com/es-es/dead-cells-steam-key-global-i10000041807004", "17,50", "https://www.instant-gaming.com/es/2090-comprar-juego-steam-dead-cells/", "12,10"));

            lv = findViewById(R.id.idLlista);
            bt = findViewById(R.id.btGame);

            gamesList = ayudaBBDD.getGames();

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

                    ////////////////
                    //boolean success = ayudaBBDD.addOne(game);
                    //ArrayList<Game> games = ayudaBBDD.getGames();
                    //Toast.makeText(MainActivity.this, games.toString(), Toast.LENGTH_LONG).show();
                    ////////////////
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

            //Guardar nuevo juego en bbdd
            boolean success = ayudaBBDD.addOne(game);
            Toast.makeText(MainActivity.this, "Guardado = " + success, Toast.LENGTH_LONG).show();
        }
    }}