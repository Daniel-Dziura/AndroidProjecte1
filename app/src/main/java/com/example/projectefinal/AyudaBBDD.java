package com.example.projectefinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class AyudaBBDD extends SQLiteOpenHelper {
    public static final String GAME_TABLE = "GAME_TABLE";
    public static final String TITOL = "titol";
    public static final String ANY = "any";
    public static final String CATEGORIA = "categoria";
    public static final String VALORACIO = "valoracio";
    public static final String IMG = "img";
    public static final String DESAROLLADOR = "desarollador";
    public static final String VIDEO_URL = "videoURL";
    public static final String STEAM_URL = "steamURL";
    public static final String STEAM_PRICE = "steamPrice";
    public static final String G_2_A_URL = "g2aURL";
    public static final String G_2_A_PRICE = "g2aPrice";
    public static final String IG_URL = "igURL";
    public static final String IG_PRICE = "igPrice";
    public static final String ID = "ID";
    private AyudaBBDD ajuda;


    private SQLiteDatabase db;


    public AyudaBBDD(@Nullable Context context) {
        super(context, "game.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + GAME_TABLE + " (" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                TITOL + " TEXT, " + ANY + " TEXT, " + CATEGORIA + " TEXT, " + VALORACIO + " TEXT, " + IMG + " INTEGER, " +
                DESAROLLADOR + " TEXT, " + VIDEO_URL + " TEXT," +
                STEAM_URL + " TEXT, " + STEAM_PRICE + " TEXT, " + G_2_A_URL + " TEXT, " +
                G_2_A_PRICE + " TEXT, " + IG_URL + " TEXT, " + IG_PRICE + " TEXT)";

        db.execSQL(createTableStatement);

        //Añadir juegos
        Game game = new Game(-1, "Grand Theft Auto V", "2013", "Accion, Aventura, FPS", "5", R.drawable.gta, "Rockstar", "https://www.youtube.com/watch?v=AVBvKx6_AEs","https://store.steampowered.com/agecheck/app/271590/?l=spanish", "29,99", "https://www.g2a.com/es-es/grand-theft-auto-v-pc-rockstar-key-global-i10000000788017", "23,99", "https://www.instant-gaming.com/es/186-comprar-juego-rockstar-grand-theft-auto-v/", "22,00");
        Game game2 = new Game(-1, "Cyberpunk 2077", "2020", "Aventura, FPS, RPG", "4", R.drawable.cyberpunk, "CD Projekt RED", "https://www.youtube.com/watch?v=fATYs_oPJFk", "https://store.steampowered.com/agecheck/app/1091500/", "59,99", "https://www.g2a.com/es-es/cyberpunk-2077-gogcom-key-global-i10000156543001", "45,55", "https://www.instant-gaming.com/es/840-comprar-juego-gog-com-cyberpunk-2077/", "30,99");
        Game game3 = new Game(-1, "Forza Horizon 4", "2019", "Carreras, Deporte", "3", R.drawable.forza, "Microsoft", "https://www.youtube.com/watch?v=AhJJpLaJyoA", "https://store.steampowered.com/search?l=spanish&term=Forza+Horizon+4", "30,00", "https://www.g2a.com/es-es/forza-horizon-4-standard-edition-xbox-live-key-global-i10000156553001", "44,00", "https://www.instant-gaming.com/es/2682-comprar-juego-xbox-play-anywhere-forza-horizon-4-pc-xbox-one/", "22,99");
        Game game4 = new Game(-1, "Dead by Daylight", "2019", "Acción, Cooperación, Multijugador", "4", R.drawable.dead, "Microsoft", "https://www.youtube.com/watch?v=qj2MSFMsObc", "https://store.steampowered.com/agecheck/app/381210/?l=spanish", "33,00", "https://www.g2a.com/es/dead-by-daylight-steam-key-global-i10000018558012", "22,00", "https://www.instant-gaming.com/es/1904-comprar-juego-steam-dead-by-daylight/", "20,00");
        Game game5 = new Game(-1,"Dead Cells", "2017", "Acción, Roguelike, Sous-like", "4", R.drawable.cells, "Microsoft", "https://www.youtube.com/watch?v=gX4cGcwmdsY", "https://store.steampowered.com/app/588650/Dead_Cells/", "24,99", "https://www.g2a.com/es-es/dead-cells-steam-key-global-i10000041807004", "17,50", "https://www.instant-gaming.com/es/2090-comprar-juego-steam-dead-cells/", "12,10");


        try {
            this.addDefaultGames(db, game);
            this.addDefaultGames(db, game2);
            this.addDefaultGames(db, game3);
            this.addDefaultGames(db, game4);
            this.addDefaultGames(db, game5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addOne(Game game){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(TITOL, game.getTitol());
        cv.put(ANY, game.getAny());
        cv.put(CATEGORIA, game.getCategoria());
        cv.put(VALORACIO, game.getValoracio());
        cv.put(IMG, game.getImg());
        cv.put(DESAROLLADOR, game.getDesarollador());
        cv.put(VIDEO_URL, game.getVideoURL());
        cv.put(STEAM_URL, game.getSteamURL());
        cv.put(STEAM_PRICE, game.getSteamPrice());
        cv.put(G_2_A_URL, game.getG2aURL());
        cv.put(G_2_A_PRICE, game.getG2aPrice());
        cv.put(IG_URL, game.getIgURL());
        cv.put(IG_PRICE, game.getIgPrice());

        long insert = db.insert(GAME_TABLE, null, cv);
        if (insert == -1){
            return false;
        }
        else {
         return true;
        }

    }

    public ArrayList<Game> getGames(){

        ArrayList<Game> returnGames = new ArrayList<>();

        String queryString = "SELECT * FROM " + GAME_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();

        //Loop de todas las filas
        Cursor cursor = db.rawQuery(queryString, null);
        if (cursor.moveToFirst()){
            do {
                int gameID = cursor.getInt(0);
                String titol = cursor.getString(1);
                String any = cursor.getString(2);
                String categoria = cursor.getString(3);
                String valoracio = cursor.getString(4);
                int img = cursor.getInt(5);
                String desarollador = cursor.getString(6);
                String videoURL = cursor.getString(7);
                String steamURL = cursor.getString(8);
                String steamPrice = cursor.getString(9);
                String g2aURL = cursor.getString(10);
                String g2aPrice = cursor.getString(11);
                String igURL = cursor.getString(12);
                String igPrice = cursor.getString(13);

                Game game = new Game(gameID, titol, any, categoria, valoracio, img, desarollador, videoURL, steamURL,
                        steamPrice, g2aURL, g2aPrice, igURL, igPrice);
                returnGames.add(game);

            }while (cursor.moveToNext());
        }
        else {

        }
        cursor.close();
        db.close();
        return  returnGames;
    }

    public void addDefaultGames(SQLiteDatabase db, Game game) throws InterruptedException {

        ContentValues cv = new ContentValues();

        cv.put(TITOL, game.getTitol());
        cv.put(ANY, game.getAny());
        cv.put(CATEGORIA, game.getCategoria());
        cv.put(VALORACIO, game.getValoracio());
        cv.put(IMG, game.getImg());
        cv.put(DESAROLLADOR, game.getDesarollador());
        cv.put(VIDEO_URL, game.getVideoURL());
        cv.put(STEAM_URL, game.getSteamURL());
        cv.put(STEAM_PRICE, game.getSteamPrice());
        cv.put(G_2_A_URL, game.getG2aURL());
        cv.put(G_2_A_PRICE, game.getG2aPrice());
        cv.put(IG_URL, game.getIgURL());
        cv.put(IG_PRICE, game.getIgPrice());

        long insert = db.insert(GAME_TABLE, null, cv);
        if (insert == -1){
        }
        else {
        }

    }

    public boolean deleteGame(String IDFila) {
        return db.delete(AyudaBBDD.GAME_TABLE, AyudaBBDD.TITOL+ " = " + IDFila, null) > 0;
    }

    public void tanca() {
        ajuda.close();
    }
}

