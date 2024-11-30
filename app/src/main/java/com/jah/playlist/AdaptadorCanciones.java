package com.jah.playlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

//Clase para mostrar en pantalla cada una de las canciones que hay para reproducir con el formato que queremos.
public class AdaptadorCanciones extends RecyclerView.Adapter<AdaptadorCanciones.HolderCanciones> {

    List<Cancion> dataSet;
    Context context;
    Cancion c;

    public AdaptadorCanciones(List<Cancion> dataSet) {
        this.dataSet = dataSet;
    }

    @NonNull
    @Override
    public AdaptadorCanciones.HolderCanciones onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.cancion, parent, false);
        return new HolderCanciones(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorCanciones.HolderCanciones holder, int position) {
        c = dataSet.get(position);

        holder.imgPortada.setImageResource(c.getPortada());
        //Libreria para modificar la imagen. En este caso la pone circular.
        Glide.with(context)
                .load(R.drawable.portada)
                .circleCrop()
                .into(holder.imgPortada);

        holder.lblNombreArtista.setText(c.getAutor());
        holder.lblNombreCancion.setText(c.getTitulo());
        holder.btnPlay.setOnClickListener(view -> {
            holder.sbBarra.setId(R.id.sbBarra + holder.getAdapterPosition());
            dataSet.get(holder.getAdapterPosition()).setSbCancion(holder.sbBarra);
            GestionReproductor.playMusic(dataSet.get(holder.getAdapterPosition()), context);
        });
        holder.btnPause.setOnClickListener(view -> {
            holder.sbBarra.setId(R.id.sbBarra + holder.getAdapterPosition());
            dataSet.get(holder.getAdapterPosition()).setSbCancion(holder.sbBarra);
            GestionReproductor.pauseMusic();
        });
        holder.btnStop.setOnClickListener(view -> {
            holder.sbBarra.setId(R.id.sbBarra + holder.getAdapterPosition());
            dataSet.get(holder.getAdapterPosition()).setSbCancion(holder.sbBarra);
            GestionReproductor.stopMusic(dataSet.get(holder.getAdapterPosition()));
        });
        //Listener para controlar la barra. Si el usuario la mueve la musica se reproduce por donde ha marcado.
        holder.sbBarra.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int posicion, boolean fromUser) {
                if(fromUser){
                    GestionReproductor.moverSeekbar(posicion);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public static class HolderCanciones extends RecyclerView.ViewHolder {

        ImageView imgPortada, btnPlay, btnPause, btnStop;
        TextView lblNombreArtista, lblNombreCancion;
        SeekBar sbBarra;

        public HolderCanciones(@NonNull View itemView) {
            super(itemView);
            imgPortada = itemView.findViewById(R.id.imgPortada);
            btnPlay = itemView.findViewById(R.id.btnPlay);
            btnPause = itemView.findViewById(R.id.btnPause);
            btnStop = itemView.findViewById(R.id.btnStop);
            lblNombreArtista = itemView.findViewById(R.id.lblNombreArtista);
            lblNombreCancion = itemView.findViewById(R.id.lblNombreCancion);
            sbBarra = itemView.findViewById(R.id.sbBarra);
        }
    }
}
