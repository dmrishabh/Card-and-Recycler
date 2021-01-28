package com.example.recyclerviewpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Item> exampleArrayList;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private EditText insert, delete;
    private Button bIn,bOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generateFakeData();
       recyclerViewConfig();
       findBtnAndEditText();

       bIn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               String value = insert.getText().toString();
              if(value.length()== 0){ insert.setError("Please Pass Index Value");
              }
              else {
                  int position = Integer.parseInt(value);         // insert.getText().toString()
                  addCard(position);
              }
           }
       });
        bOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String value = delete.getText().toString();
                if(value.length()== 0){ delete.setError("Please Pass Index Value");
                }
                else {
                    int position = Integer.parseInt(value) ;
                    deleteCard(position);
                }
              }
        });

    }
    public void findBtnAndEditText() {
        insert = findViewById(R.id.edittextadd);
        delete = findViewById(R.id.edittextdelete);
        bIn = findViewById(R.id.buttonadd);
        bOut = findViewById(R.id.buttondelete);
    }
    public void recyclerViewConfig(){
        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(true); // to enhance the performance

        layoutManager = new LinearLayoutManager(this);
        adapter = new Adapter(exampleArrayList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
    public void generateFakeData(){

        exampleArrayList = new ArrayList<>();

        exampleArrayList.add(new Item(R.drawable.oner, "Clicked at home"));
        exampleArrayList.add(new Item(R.drawable.twor, "Clicked at random place"));
        exampleArrayList.add(new Item(R.drawable.threer, "Clicked at home"));
        exampleArrayList.add(new Item(R.drawable.fourr, "Clicked at home"));
        exampleArrayList.add(new Item(R.drawable.fiver, "Clicked at home"));
        exampleArrayList.add(new Item(R.drawable.sixr, "Clicked at home"));
    }
    public void addCard(int position){
        exampleArrayList.add(position,new Item(R.drawable.oner , "new card added"));
//        adapter.notifyDataSetChanged();
        adapter.notifyItemInserted(position);
    }
    public void deleteCard(int position){
        exampleArrayList.remove(position);
        adapter.notifyItemInserted(position);
    }
}