package com.jah.playlist;

import android.content.Context;
import android.widget.SeekBar;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//Clase controladora de las canciones. Tambien inicializa la playlist.
public class GestionCanciones implements Serializable {

    public static List<Cancion> arrCanciones;
    public static boolean hasPausado;

    public static boolean isHasPausado() {
        return hasPausado;
    }

    public static void setHasPausado(boolean hasPausado) {
        GestionCanciones.hasPausado = hasPausado;
    }

    public static List<Cancion> getArrCanciones() {
        return arrCanciones;
    }

    public static void setArrCanciones(List<Cancion> arrCanciones) {
        GestionCanciones.arrCanciones = arrCanciones;
    }

    public static void iniciarValor(){
        hasPausado = false;
    }

    public static void cargarCanciones(Context context){
        Cancion c;
        arrCanciones = new ArrayList<>();
        c = new Cancion(1, "To Ashes and blood", "Woodkid", R.drawable.portada, R.raw.to_ashes_and_blood, new SeekBar(context));
        arrCanciones.add(c);
        c = new Cancion(2, "Hellfire", "Fever 333", R.drawable.portada, R.raw.hellfire_, new SeekBar(context));
        arrCanciones.add(c);
        c = new Cancion(3, "Playground", "Bea Miller", R.drawable.portada, R.raw.playground, new SeekBar(context));
        arrCanciones.add(c);
        c = new Cancion(4, "Cant hear it now", "Freya Ridings", R.drawable.portada, R.raw.can_t_hear_it_now, new SeekBar(context));
        arrCanciones.add(c);
        c = new Cancion(5, "Heavy is the crown", "Mike Shinoda", R.drawable.portada, R.raw.heavy_is_the_crown, new SeekBar(context));
        arrCanciones.add(c);
        c = new Cancion(6, "Ma meilleure ennemie", "Strommae Pomme", R.drawable.portada, R.raw.ma_meilleure_ennemie, new SeekBar(context));
        arrCanciones.add(c);
        c = new Cancion(7, "Enemy", "Imagine Dragons", R.drawable.portada, R.raw.imagine_dragons, new SeekBar(context));
        arrCanciones.add(c);
        c = new Cancion(8, "Paint the town blue", "Ashnikko", R.drawable.portada, R.raw.paint_the_town_blue, new SeekBar(context));
        arrCanciones.add(c);
        c = new Cancion(9, "Remember me", "D4dv", R.drawable.portada, R.raw.remember_me, new SeekBar(context));
        arrCanciones.add(c);
        c = new Cancion(10, "Sucker", "Marcus King", R.drawable.portada, R.raw.sucker, new SeekBar(context));
        arrCanciones.add(c);
        c = new Cancion(11, "The line", "Twenty One Pilots", R.drawable.portada, R.raw.the_line, new SeekBar(context));
        arrCanciones.add(c);
        c = new Cancion(12, "Wasteland", "Royal the serpent", R.drawable.portada, R.raw.wasteland, new SeekBar(context));
        arrCanciones.add(c);
    }
}
