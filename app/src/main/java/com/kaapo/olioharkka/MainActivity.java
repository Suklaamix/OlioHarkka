package com.kaapo.olioharkka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.kaapo.olioharkka.LutemonFolder.Lutemon;
import com.kaapo.olioharkka.StorageFolder.BattleField;
import com.kaapo.olioharkka.StorageFolder.Home;
import com.kaapo.olioharkka.StorageFolder.TrainArea;

public class MainActivity extends AppCompatActivity {

    private TextView LutemonCount, LutemonHomeCount, LutemonTrainCount, LutemonBattleCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LutemonCount = findViewById(R.id.textViewLutemonCount);
        LutemonHomeCount = findViewById(R.id.textViewLutemonHomeCount);
        LutemonBattleCount = findViewById(R.id.textViewLutemonBattleCount);
        LutemonTrainCount = findViewById(R.id.textViewLutemonTrainCount);

    }
    @Override
    protected void onResume() {
        super.onResume();

        LutemonCount.setText("Lutemoneja luotu : "+ Lutemon.getNumberOfCreatedLutemons());
        LutemonHomeCount.setText("Lutemonien määrä kotona: "+ Home.getInstance().getLutemonList().size());
        LutemonBattleCount.setText("Lutemonien määrä taistelemassa: "+ BattleField.getInstance().getLutemonList().size());
        LutemonTrainCount.setText("Lutemonien määrä treenaamassa: "+ TrainArea.getInstance().getLutemonList().size());
    }

    public void switchToAddLutemon(View view) {
        Intent intent = new Intent(this, AddLutemonActivity.class);
        startActivity(intent);
    }

    public void switchToListLutemon(View view) {
        Intent intent = new Intent(this, LutemonListActivity.class);
        startActivity(intent);
    }

    public void switchToTrainLutemon(View view) {
        Intent intent = new Intent(this, LutemonTrainActivity.class);
        startActivity(intent);
    }

    public void switchToBattleLutemon(View view) {
        Intent intent = new Intent(this, LutemonBattleActivity.class);
        startActivity(intent);
    }

}