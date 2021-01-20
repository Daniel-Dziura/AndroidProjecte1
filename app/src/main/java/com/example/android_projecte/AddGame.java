package com.example.android_projecte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddGame extends AppCompatActivity {

    public EditText eTitol, eAny, eCat, eVal, eDir;
    public Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_addgame);

        eTitol = findViewById(R.id.editTextTitol);
        eCat = findViewById(R.id.editTextCat);
        eAny = findViewById(R.id.editTextAny);

        eVal = findViewById(R.id.editTextVal);
        eDir = findViewById(R.id.editTextDesar);
        bt = findViewById(R.id.addGame);

        final Game game = new Game(11,"","", "", "", R.drawable.imgdefault, "", "");

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();

                Editable titol = eTitol.getText();
                game.setTitol(titol.toString());

                Editable cat = eCat.getText();
                game.setCategoria(cat.toString());

                Editable any = eAny.getText();
                game.setAny(any.toString());

                Editable val = eVal.getText();
                game.setValoracio(val.toString());

                Editable dir = eDir.getText();
                game.setDesarollador(dir.toString());

                i.putExtra("novaPeli", game);
                setResult(RESULT_OK,i);
                finish();
            }
        });
    }
}