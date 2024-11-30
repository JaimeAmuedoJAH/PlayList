package com.jah.playlist;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.widget.SeekBar;
//Clase controladora del reproductor.
public class GestionReproductor {

    public static MediaPlayer reproductor;
    static Runnable handlerTask;
    static Handler handler = new Handler();
    static boolean pausada;
    static boolean parada;
    //Para la musica. Si vuelves a darle al play comenzara desde el inicio
    public static void stopMusic(Cancion c) {
        reproductor.stop();
        c.getSbCancion().setProgress(0);
        parada = true;
    }
    //Pausa la musica. Si vuelves a darle al play se reproducira por donde la dejes pausada.
    public static void pauseMusic() {
        if(reproductor.isPlaying()){
            reproductor.pause();
            pausada = true;
        }

    }
    /*Metodo para empezar a escuchar la cancion.
    Si hay una reproduciendose y has pulsado otra se para y se reproduce la que has maracado.
    */
    public static void playMusic(Cancion c, Context context) {
        if (reproductor == null) {
            reproductor = MediaPlayer.create(context, c.getCancion());
        } else {
            if (reproductor.isPlaying()) {
                reproductor.stop();
            }
            reproductor.reset();
            reproductor.release();
            reproductor = MediaPlayer.create(context, c.getCancion());
        }
        reproductor.start();
        pausada = false;
        parada = false;
        startTimer(c.getSbCancion());
    }
    //Metodo para controlar la barra de progreso de la cancion.
    public static void startTimer(SeekBar sbBarra) {
        handlerTask = new Runnable() {
            @Override
            public void run() {
                if (reproductor != null && reproductor.isPlaying()) {
                    int position = reproductor.getCurrentPosition();
                    sbBarra.setProgress(position);
                    sbBarra.setMax(reproductor.getDuration());
                }
                handler.postDelayed(this, 1000);
            }
        };
        handler.post(handlerTask);
    }
    //Mueve a la posicion que indiquemos la barra de la cancion y la cancion se reproduce por donde le indiques.
    public static void moverSeekbar(int posicion){
        reproductor.seekTo(posicion);
    }
}
