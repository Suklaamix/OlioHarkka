package com.kaapo.olioharkka;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kaapo.olioharkka.LutemonFolder.Lutemon;
import com.kaapo.olioharkka.StorageFolder.BattleField;



public class LutemonBattleActivity extends AppCompatActivity {
    private EditText LutemonID, LutemonID2;
    private Button BattleButton;
    private BattleField storage;


    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lutemon_battle);
        LutemonID = findViewById(R.id.editTextInsertName);
        LutemonID2 = findViewById(R.id.editTextInsertName2);
        BattleButton = findViewById(R.id.btnBattle);

        storage = BattleField.getInstance();

        recyclerView = findViewById(R.id.rvTrainList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new LutemonTrainAdapter(getApplicationContext(), storage.getLutemonList(), "BattleField"));

    }

    public void battle(View view) {
        int id = Integer.parseInt(LutemonID.getText().toString());
        int id2 = Integer.parseInt(LutemonID2.getText().toString());
        Lutemon lutemon = storage.getLutemonById(id);
        Lutemon lutemon2 = storage.getLutemonById(id2);

        if (lutemon != null && lutemon2 != null && lutemon2 != lutemon) {
            Intent intent = new Intent(this, LutemonBattlefieldActivity.class);
            intent.putExtra("Lutemon_ID_1", id);
            intent.putExtra("Lutemon_ID_2", id2);
            startActivity(intent);
        } else if (id == id2){
            Toast.makeText(this, "Lutemon can't fight itself", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Lutemons not found!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        recyclerView.getAdapter().notifyDataSetChanged();
    }
}