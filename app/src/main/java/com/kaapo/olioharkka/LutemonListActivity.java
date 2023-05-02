package com.kaapo.olioharkka;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.kaapo.olioharkka.StorageFolder.Home;

public class LutemonListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private Home home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lutemon_list);


        home = Home.getInstance();

        recyclerView = findViewById(R.id.rvLutemonList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new LutemonListAdapter(getApplicationContext(), home.getLutemonList()));
    }
}