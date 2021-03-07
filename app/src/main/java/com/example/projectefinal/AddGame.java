package com.example.projectefinal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddGame extends AppCompatActivity {
    private String PREFS_KEY = "mispreferencias";
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

        eTitol.setText(getValue(getApplicationContext(), "tit"));
        eCat.setText(getValue(getApplicationContext(), "cat"));
        eAny.setText(getValue(getApplicationContext(), "any"));
        eVal.setText(getValue(getApplicationContext(), "val"));
        eDir.setText(getValue(getApplicationContext(), "dir"));

        final Game game = new Game(-1,"","", "", "", R.drawable.imgdefault, "", "", "https://store.steampowered.com/?l=spanish", "N/A", "https://www.g2a.com/", "N/A", "https://www.instant-gaming.com/es/", "N/A");

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

                Editable val;
                val = eVal.getText();
                if (val.equals("")){
                    game.setValoracio(val.toString());
                }else{
                    game.setValoracio("4.5");
                }


                Editable dir = eDir.getText();
                game.setDesarollador(dir.toString());

                i.putExtra("novaPeli", game);
                setResult(RESULT_OK,i);
                finish();
            }
        });

        eTitol.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                saveValue(getApplicationContext(), s.toString(), "tit");
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        eCat.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                saveValue(getApplicationContext(), s.toString(),"cat");
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        eAny.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                saveValue(getApplicationContext(), s.toString(), "any");
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        eVal.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                saveValue(getApplicationContext(), s.toString(), "val");
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        eDir.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                saveValue(getApplicationContext(), s.toString(), "dir");
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

    }

    public void saveValue(Context context, String text, String key) {
        SharedPreferences settings = context.getSharedPreferences(PREFS_KEY, MODE_PRIVATE);
        SharedPreferences.Editor editor;
        editor = settings.edit();
        editor.putString(key, text);
        editor.commit();
    }

    public String getValue(Context context, String key) {
        SharedPreferences preferences = context.getSharedPreferences(PREFS_KEY, MODE_PRIVATE);
        return  preferences.getString(key, "");
    }

}