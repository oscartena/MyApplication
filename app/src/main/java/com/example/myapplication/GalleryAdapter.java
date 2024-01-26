package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder> {
    private List<Gallery> fotos;

    public static class GalleryViewHolder extends RecyclerView.ViewHolder {
        public ImageView imagen;
        public TextView titulo;
        public GalleryViewHolder(View v) {
            super(v);
            imagen = v.findViewById(R.id.foto);
            titulo = v.findViewById(R.id.nombreFoto);
        }

        public void bindCard(Gallery foto){
            imagen.setImageResource(foto.getImagen());
            titulo.setText(foto.getTitulo());
        }
    }

    public GalleryAdapter(List<Gallery> fotos) {
        this.fotos = fotos;
    }

    @NonNull
    @Override
    public GalleryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gallery, parent, false);
        return new GalleryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryViewHolder holder, int position) {
        holder.bindCard(fotos.get(position));

        Context context = holder.itemView.getContext();

        holder.imagen.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
            @Override
            public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
                MenuInflater inflater = new MenuInflater(context);
                inflater.inflate(R.menu.context_menu, menu);
            }
        });

        holder.imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity activity = (Activity) context;
                ActionMode actionMode = activity.startActionMode(new ActionMode.Callback() {
                    @Override
                    public boolean onCreateActionMode(ActionMode mode, android.view.Menu menu) {
                        MenuInflater inflater = mode.getMenuInflater();
                        inflater.inflate(R.menu.action_mode, menu);
                        return true;
                    }

                    @Override
                    public boolean onPrepareActionMode(ActionMode mode, android.view.Menu menu) {
                        return false;
                    }

                    @Override
                    public boolean onActionItemClicked(ActionMode mode, android.view.MenuItem item) {
                        return false;
                    }

                    @Override
                    public void onDestroyActionMode(ActionMode mode) {

                    }
                });
            }
        });


    }

    @Override
    public int getItemCount() {
        return fotos.size();
    }
}

