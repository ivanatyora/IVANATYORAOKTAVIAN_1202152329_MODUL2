package com.example.android.ivanatyoraoktavian_1202152329_modul2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.LinkedList;

public class Menu extends AppCompatActivity {

    private final LinkedList<String> foods = new LinkedList<>(); //membuat variabel bebas bernama foods
    private final LinkedList<Integer> priceses = new LinkedList<>(); //membuat variabel bebas bernama priceses
    private final LinkedList<Integer> photos = new LinkedList<>(); ////membuat variabel bebas bernama photos
    //private int mCount = 0;

    private RecyclerView mRecyclerView; //membuat variable bebas
    private MenuAdapter mAdapter; //memanggil class menuAdapter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        dummiesData(); //membuat method

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview); //inisiasi id dimana id nya ada di layout menu
        mAdapter = new MenuAdapter(this, foods, priceses, photos); //memanggil dari menuAdapter dimana didalamnya ada linkedlist foods,priceses, photos
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this)); //mengatur layout menjadi linearlayout
    }

    private void dummiesData(){
        for (int i = 0;i < 2; i++){ //ada 2x looping, jadi total itemnya 10
            foods.add("chick'n");
            foods.add("chunky fries");
            foods.add("nugget munch box");
            foods.add("poutine");
            foods.add("sweet potato fries");

            priceses.add(32000);
            priceses.add(15000);
            priceses.add(25000);
            priceses.add(35000);
            priceses.add(17000);

            photos.add(R.drawable.chickn);
            photos.add(R.drawable.chunkyfries);
            photos.add(R.drawable.nuggetmunchbox);
            photos.add(R.drawable.poutine);
            photos.add(R.drawable.sweetpotato);
        }
    }
}
