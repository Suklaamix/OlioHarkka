package com.kaapo.olioharkka;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LutemonViewHolder extends RecyclerView.ViewHolder {

    ImageView lutemonImage, switchTrain, switchBattle;
    TextView lutemonName, lutemonAtt, lutemonDef, lutemonHp, lutemonLvl;

    public LutemonViewHolder(@NonNull View itemView) {
        super(itemView);
        lutemonImage = itemView.findViewById(R.id.ivLutemonImage);
        switchTrain = itemView.findViewById(R.id.imgTrain);
        switchBattle = itemView.findViewById(R.id.imgBattle);
        lutemonName = itemView.findViewById(R.id.txtLutemonName);
        lutemonAtt = itemView.findViewById(R.id.txtLutemonAtt);
        lutemonDef = itemView.findViewById(R.id.txtLutemonDef);
        lutemonHp = itemView.findViewById(R.id.txtLutemonHp);
        lutemonLvl = itemView.findViewById(R.id.txtLutemonLvl);

    }
}
