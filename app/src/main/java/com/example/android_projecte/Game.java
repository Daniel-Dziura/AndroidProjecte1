package com.example.android_projecte;

import android.os.Parcel;
import android.os.Parcelable;

public class Game implements Parcelable
{
    int codi, img;
    String titol, any, categoria, valoracio, desarollador;

    public Game(int codi, String titol, String any, String categoria, String valoracio, int img, String dev)
    {
        this.codi = codi;
        this.titol = titol;
        this.any = any;
        this.categoria = categoria;
        this.valoracio = valoracio;
        this.img = img;
        this.desarollador = dev;
    }

    protected Game(Parcel in) {
        codi = in.readInt();
        img = in.readInt();
        titol = in.readString();
        any = in.readString();
        categoria = in.readString();
        valoracio = in.readString();
        desarollador = in.readString();
    }

    public static final Creator<Game> CREATOR = new Creator<Game>() {
        @Override
        public Game createFromParcel(Parcel in) {
            return new Game(in);
        }

        @Override
        public Game[] newArray(int size) {
            return new Game[size];
        }
    };

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public void setAny(String any) {
        this.any = any;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }


    public void setValoracio(String valoracio) {
        this.valoracio = valoracio;
    }

    public void setDesarollador(String desarollador) {
        this.desarollador = desarollador;
    }

    public String getAny() {
        return any;
    }

    public String getCategoria() {
        return categoria;
    }


    public String getValoracio() {
        return valoracio;
    }

    public int getImg() {
        return img;
    }

    public String getDesarollador() {return desarollador; }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(codi);
        dest.writeInt(img);
        dest.writeString(titol);
        dest.writeString(any);
        dest.writeString(categoria);
        dest.writeString(valoracio);
        dest.writeString(desarollador);
    }
}