package com.example.projectefinal;

import android.os.Parcel;
import android.os.Parcelable;

public class Game implements Parcelable
{
    int codi, img;
    String titol, any, categoria, valoracio, desarollador, videoURL, steamURL, steamPrice, g2aURL, g2aPrice, igURL, igPrice;

    public Game(int codi, String titol, String any, String categoria, String valoracio, int img, String dev, String videoURL, String steamURL, String steamPrice,  String g2aURL, String g2aPrice, String igURL, String igPrice)
    {
        this.codi = codi;
        this.titol = titol;
        this.any = any;
        this.categoria = categoria;
        this.valoracio = valoracio;
        this.img = img;
        this.desarollador = dev;
        this.videoURL = videoURL;
        this.steamURL = steamURL;
        this.steamPrice = steamPrice;
        this.g2aURL = g2aURL;
        this.g2aPrice = g2aPrice;
        this.igURL = igURL;
        this.igPrice = igPrice;
    }

    public Game() {
    }

    protected Game(Parcel in) {
        codi = in.readInt();
        img = in.readInt();
        titol = in.readString();
        any = in.readString();
        categoria = in.readString();
        valoracio = in.readString();
        desarollador = in.readString();
        videoURL = in.readString();
        steamURL = in.readString();
        steamPrice = in.readString();
        g2aURL = in.readString();
        g2aPrice = in.readString();
        igURL = in.readString();
        igPrice = in.readString();
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

    public void setVideoURL(String videoURL) { this.videoURL = videoURL; }

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

    public String getVideoURL() { return  videoURL; }

    public String getSteamURL() {
        return steamURL;
    }

    public void setSteamURL(String steamURL) {
        this.steamURL = steamURL;
    }

    public String getSteamPrice() {
        return steamPrice;
    }

    public void setSteamPrice(String steamPrice) {
        this.steamPrice = steamPrice;
    }

    public String getG2aURL() {
        return g2aURL;
    }

    public void setG2aURL(String g2aURL) {
        this.g2aURL = g2aURL;
    }

    public String getG2aPrice() {
        return g2aPrice;
    }

    public void setG2aPrice(String g2aPrice) {
        this.g2aPrice = g2aPrice;
    }

    public String getIgURL() {
        return igURL;
    }

    public void setIgURL(String igURL) {
        this.igURL = igURL;
    }

    public String getIgPrice() {
        return igPrice;
    }

    public void setIgPrice(String igPrice) {
        this.igPrice = igPrice;
    }

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
        dest.writeString(videoURL);
        dest.writeString(steamURL);
        dest.writeString(steamPrice);
        dest.writeString(g2aURL);
        dest.writeString(g2aPrice);
        dest.writeString(igURL);
        dest.writeString(igPrice);
    }

    @Override
    public String toString() {
        return "Game{" +
                "codi=" + codi +
                ", img=" + img +
                ", titol='" + titol + '\'' +
                ", any='" + any + '\'' +
                ", categoria='" + categoria + '\'' +
                ", valoracio='" + valoracio + '\'' +
                ", desarollador='" + desarollador + '\'' +
                ", videoURL='" + videoURL + '\'' +
                ", steamURL='" + steamURL + '\'' +
                ", steamPrice='" + steamPrice + '\'' +
                ", g2aURL='" + g2aURL + '\'' +
                ", g2aPrice='" + g2aPrice + '\'' +
                ", igURL='" + igURL + '\'' +
                ", igPrice='" + igPrice + '\'' +
                '}';
    }
}