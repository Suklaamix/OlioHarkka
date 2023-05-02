package com.kaapo.olioharkka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.kaapo.olioharkka.LutemonFolder.Lutemon;
import com.kaapo.olioharkka.StorageFolder.BattleField;
import com.kaapo.olioharkka.StorageFolder.LutemonStorage;

public class LutemonBattlefieldActivity extends AppCompatActivity {

    private TextView textView;

    private LutemonStorage storage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lutemon_battlefield);

        storage = BattleField.getInstance();

        textView = findViewById(R.id.textViewBattle);

        Intent intent = getIntent();
        int id = intent.getIntExtra("Lutemon_ID_1",0);
        int id2 = intent.getIntExtra("Lutemon_ID_2", 0);

        Lutemon lutemon = storage.getLutemonById(id);
        Lutemon lutemon2 = storage.getLutemonById(id2);

        lutemon.battle(lutemon2,textView);
    }


}