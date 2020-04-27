package com.example.trabalhofragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;


public class ThirdFragment extends Fragment {
    private GridView gridView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_third, container, false);

        int lista[] = new int[]{R.drawable.cansaco,R.drawable.faltadear,
                R.drawable.tosse,R.drawable.termometro
        };
        gridView = (GridView) view.findViewById(R.id.gridView);
        gridView.setAdapter(new Adaptador(getContext(), lista));


        return view;
    }
}
