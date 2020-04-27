package com.example.trabalhofragmentos;

import android.app.FragmentTransaction;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


import java.util.ArrayList;

public class SecondFragment extends Fragment {
    private Button button;
    private Spinner spinner;
    private ImageView imgView;
    private int selecionado = 0;
    MediaPlayer mediaPlayer;




    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        spinner = view.findViewById(R.id.spinner);
        ArrayList<String> lista = new ArrayList<>(); lista.add("Não vou sair!") ; lista.add("Vou sair!");
        spinner.setAdapter(new ArrayAdapter<String>(getContext(), R.layout.support_simple_spinner_dropdown_item, lista));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selecionado = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        button = view.findViewById(R.id.button);
        imgView = view.findViewById(R.id.imgView);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selecionado == 0){
                    imgView.setImageResource(R.drawable.attitudecontagieuse);
                    imgView.setVisibility(View.VISIBLE);

                    if (mediaPlayer != null) {
                            mediaPlayer.release();
                    }

                    mediaPlayer = MediaPlayer.create(getContext(), R.raw.claps);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mediaPlayer.release();
                        }
                    });

                }
                if(selecionado == 1){
                    imgView.setImageResource(R.drawable.caixao);
                    imgView.setVisibility(View.VISIBLE);

                    if (mediaPlayer != null) {
                            mediaPlayer.release();
                    }

                    mediaPlayer = MediaPlayer.create(getContext(), R.raw.astronomia);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mediaPlayer.release();
                        }
                    });

                }
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mediaPlayer != null) mediaPlayer.release();
    }

}
