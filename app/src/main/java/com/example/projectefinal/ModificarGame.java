package com.example.projectefinal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ModificarGame extends AppCompatActivity implements View.OnClickListener  {

    private static SQLiteDatabase db;
    private ArrayList<Game> game = new ArrayList<>();
    public static int codi;
    public EditText eTitol, eAny, eCat, eVal, eDir, eyou;
    public Button updt, del;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_modificar);

        eTitol = findViewById(R.id.editTextTitolMod);
        eCat = findViewById(R.id.editTextCatMod);
        eAny = findViewById(R.id.editTextAnyMod);
        eVal = findViewById(R.id.editTextValMod);
        eDir = findViewById(R.id.editTextDesarMod);
        eyou = findViewById(R.id.editTextYoutubeMod);
        updt = findViewById(R.id.modButton);
        del = findViewById(R.id.btDelete);


        Intent intent = getIntent();

        Game game = intent.getParcelableExtra("Pelicula");

        String titol = game.getTitol();
        String cat= game.getCategoria();
        String any = game.getAny();
        String val = game.getValoracio();
        String des = game.getDesarollador();
        String yout = game.getVideoURL();
        codi = game.getCodi();


        TextView textTitol = findViewById(R.id.editTextTitolMod);
        textTitol.setText(titol);

        TextView textCat = findViewById(R.id.editTextCatMod);
        textCat.setText(cat);

        TextView textAny = findViewById(R.id.editTextAnyMod);
        textAny.setText(any);

        TextView textVal = findViewById(R.id.editTextValMod);
        textVal.setText(val);

        TextView textDes = findViewById(R.id.editTextDesarMod);
        textDes.setText(des);

        TextView textYou = findViewById(R.id.editTextYoutubeMod);
        textYou.setText(yout);

        String tit = eTitol.getText().toString();
        String ccat = eCat.getText().toString();
        String aany = eAny.getText().toString();
        String vval = eVal.getText().toString();
        String dir = eDir.getText().toString();
        String youy = eyou.getText().toString();

        updt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update(tit,ccat,aany,vval,dir,youy);
            }
        });

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete();

                Toast.makeText(getApplicationContext(),"S'ha borrat", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
           /* case R.id.btDelete:
                delete();
                finish();
                Toast.makeText(getApplicationContext(),"S0ha borrat", Toast.LENGTH_SHORT).show();
                break;*/
        }
    }

    public void update(String tit, String cat, String any, String val, String des, String you){
        if (db != null){
            db.execSQL("UPDATE GAME_TABLE SET titol = " + tit + " categoria = " + cat + " any = " + any + " valoracio =" + val + " desarollador = " + des + " videoURL = " + you + " WHERE codi = " + codi);
            db.close();
        }

    }
    public static void delete(){
        db.execSQL("DELETE FROM GAME_TABLE WHERE codi =" + codi);
        db.close();
    }

}
