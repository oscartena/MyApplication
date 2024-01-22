package com.example.myapplication.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment {
    private List<Integer> photos = List.of(R.drawable.image1, R.drawable.image2,R.drawable.image3, R.drawable.image4 , R.drawable.image5, R.drawable.image6, R.drawable.image7, R.drawable.image8, R.drawable.image9)
            ;
    private RecyclerView recyclerView;
    private GalleryAdapter galleryAdapter;

    public GalleryFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_gallery, container, false);

        // Inicializar el RecyclerView
        recyclerView = rootView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

        // Inicializar el adaptador
        galleryAdapter = new GalleryAdapter(getContext(), photos);
        recyclerView.setAdapter(galleryAdapter);

        registerForContextMenu(recyclerView);

        return rootView;

    }

}
