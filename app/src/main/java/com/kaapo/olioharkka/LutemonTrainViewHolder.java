package com.kaapo.olioharkka;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LutemonTrainViewHolder extends RecyclerView.ViewHolder {
    TextView lutemonName,lutemonLvl;

    ImageView switchHome;

    public LutemonTrainViewHolder(@NonNull View itemView) {
        super(itemView);
        lutemonName = itemView.findViewById(R.id.txtLutemonName2);
        lutemonLvl = itemView.findViewById(R.id.txtLutemonLvl2);
        switchHome = itemView.findViewById(R.id.imgHome);

    }
}
