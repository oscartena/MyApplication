package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;


import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment {
    private List<Integer> imagenes = List.of(R.drawable.image1, R.drawable.image2,R.drawable.image3, R.drawable.image4 , R.drawable.image5, R.drawable.image6, R.drawable.image7, R.drawable.image8, R.drawable.image9);
    private RecyclerView recyclerView;
    private GalleryAdapter galleryAdapter;

    public GalleryFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gallery, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<Gallery> fotos = new ArrayList<>();
        int numeroFoto = 1;

        for (Integer imagen : imagenes) {
            fotos.add(new Gallery(imagen, "Foto " + numeroFoto));
            numeroFoto++;
        }

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager((new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)));

        galleryAdapter = new GalleryAdapter(fotos);
        recyclerView.setAdapter(galleryAdapter);
    }

}
