package com.kaapo.olioharkka;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kaapo.olioharkka.LutemonFolder.Lutemon;
import com.kaapo.olioharkka.StorageFolder.TrainArea;

public class LutemonTrainActivity extends AppCompatActivity {
    private EditText LutemonID;
    private Button TrainButton;
    private TrainArea storage;

    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lutemon_train);
        LutemonID = findViewById(R.id.editTextInsertName);
        TrainButton = findViewById(R.id.btnTrain);

        storage = TrainArea.getInstance();

        recyclerView = findViewById(R.id.rvTrainList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new LutemonTrainAdapter(getApplicationContext(), storage.getLutemonList(), "TrainArea"));
    }

    public void train(View view) {
        int id = Integer.parseInt(LutemonID.getText().toString());
        Lutemon lutemon = storage.getLutemonById(id);
        if (lutemon != null) {
            lutemon.lvlUp();
            lutemon.setTrainingCount(lutemon.getTrainingCount()+1);
            recyclerView.getAdapter().notifyDataSetChanged();
        } else {
            Toast.makeText(this, "Lutemon not found!", Toast.LENGTH_SHORT).show();
        }
    }

}