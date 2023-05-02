package com.kaapo.olioharkka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.kaapo.olioharkka.LutemonFolder.Black;
import com.kaapo.olioharkka.LutemonFolder.Green;
import com.kaapo.olioharkka.LutemonFolder.Lutemon;
import com.kaapo.olioharkka.LutemonFolder.Orange;
import com.kaapo.olioharkka.LutemonFolder.Pink;
import com.kaapo.olioharkka.LutemonFolder.White;
import com.kaapo.olioharkka.StorageFolder.Home;

public class AddLutemonActivity extends AppCompatActivity {

    private EditText editTextLutemonNimi;

    private RadioGroup radioVari;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lutemon);

        editTextLutemonNimi = findViewById(R.id.editTextLutemonNimi);
        radioVari = findViewById(R.id.radioGroup);
    }

    public void addLutemon(View view) {
        String name = editTextLutemonNimi.getText().toString();

        int selectedRadioButtonId = radioVari.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
        String selectedColor = "";
        if (selectedRadioButton != null) {
            selectedColor = selectedRadioButton.getText().toString();
        }

        Lutemon lutemon;
        if (selectedColor.equals("Valkoinen")) {
            lutemon = new White(name);
        } else if (selectedColor.equals("Vihreä")) {
            lutemon = new Green(name);
        } else if (selectedColor.equals("Pinkki")) {
            lutemon = new Pink(name);
        } else if (selectedColor.equals("Oranssi")) {
            lutemon = new Orange(name);
        } else if (selectedColor.equals("Musta")) {
            lutemon = new Black(name);
        } else {
            lutemon = new White(name);
        }


        Home home = Home.getInstance();
        home.createLutemon(lutemon);
        editTextLutemonNimi.setText("");
    }
}