package com.example.recyclerviewpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Item> exampleArrayList = new ArrayList<>();

        exampleArrayList.add(new Item(R.drawable.oner,"Clicked at home"));
        exampleArrayList.add(new Item(R.drawable.twor,"Clicked at random place"));
        exampleArrayList.add(new Item(R.drawable.threer,"Clicked at home"));
        exampleArrayList.add(new Item(R.drawable.fourr,"Clicked at home"));
        exampleArrayList.add(new Item(R.drawable.fiver,"Clicked at home"));
        exampleArrayList.add(new Item(R.drawable.sixr,"Clicked at home"));

        recyclerView =findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(true); // to enhance the performance

        layoutManager=new LinearLayoutManager(this);
        adapter = new Adapter(exampleArrayList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);



    }
}