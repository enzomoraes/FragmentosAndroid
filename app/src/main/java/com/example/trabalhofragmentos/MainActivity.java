package com.example.trabalhofragmentos;

import android.app.Activity;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private ListView listView;
    FragmentManager fm = getSupportFragmentManager();
    FragmentTransaction ft = fm.beginTransaction();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null){
            FirstFragment frag1 = new FirstFragment();
            SecondFragment frag2 = new SecondFragment();
            //ThirdFragment frag3 = new ThirdFragment();
            ft.add(R.id.layout_direito, frag1);
        }

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView = findViewById(R.id.listView);
        ArrayList<String> lista = new ArrayList<>(); lista.add("Fragmento 1"); lista.add("Fragmento 2"); lista.add("Fragmento 3");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_expandable_list_item_1,lista);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                if(position==0){

                    FirstFragment frag1 = new FirstFragment();
                    ft = fm.beginTransaction();
                    ft.replace(R.id.layout_direito, frag1, "frag1");
                    ft.addToBackStack("pilha");
                    ft.commit();

                }else if(position==1) {
                    SecondFragment frag2 = new SecondFragment();
                    ft = fm.beginTransaction();
                    ft.replace(R.id.layout_direito, frag2, "frag2");
                    ft.addToBackStack("pilha");
                    ft.commit();
                }else if(position==2){
                    ThirdFragment frag3 = new ThirdFragment();
                    ft = fm.beginTransaction();
                    ft.replace(R.id.layout_direito,frag3,"frag3");
                    ft.addToBackStack("pilha");
                    ft.commit();
                }

            }

        });

    }


}


