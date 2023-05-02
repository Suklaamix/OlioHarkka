package com.kaapo.olioharkka;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kaapo.olioharkka.LutemonFolder.Lutemon;
import com.kaapo.olioharkka.StorageFolder.BattleField;
import com.kaapo.olioharkka.StorageFolder.Home;
import com.kaapo.olioharkka.StorageFolder.TrainArea;

import java.util.ArrayList;

public class LutemonListAdapter extends RecyclerView.Adapter<LutemonViewHolder> {

    private Context context;
    private ArrayList<Lutemon> lutemons = new ArrayList<>();

    public LutemonListAdapter(Context context, ArrayList<Lutemon> lutemons) {
        this.context = context;
        this.lutemons = lutemons;
    }

    @NonNull
    @Override
    public LutemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LutemonViewHolder(LayoutInflater.from(context).inflate(R.layout.lutemon_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LutemonViewHolder holder, int position) {
        Lutemon lutemon = lutemons.get(position);
        if (lutemon != null) {
            holder.lutemonName.setText(lutemon.getName() + " (" + lutemon.getColor() +")");
            holder.lutemonAtt.setText("Hyökkäys " + lutemon.getAttack());
            holder.lutemonDef.setText("Puolustus " + lutemon.getDefense());
            holder.lutemonHp.setText("Elämä " + lutemon.getHealth() + "/" + lutemon.getMaxHealth());
            holder.lutemonLvl.setText("Kokemus " + lutemon.getLvl());
            holder.lutemonImage.setImageResource(lutemon.getImage());
            holder.switchBattle.setImageResource(R.drawable.battle);
            holder.switchTrain.setImageResource(R.drawable.train);
        }
        holder.switchBattle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = holder.getAdapterPosition();
                BattleField.getInstance().addLutemon(lutemons.get(pos));
                Home.getInstance().deleteLutemonById(lutemons.get(pos).getId());
                notifyItemRemoved(pos);
            }
        });
        holder.switchTrain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = holder.getAdapterPosition();
                TrainArea.getInstance().addLutemon(lutemons.get(pos));
                Home.getInstance().deleteLutemonById(lutemons.get(pos).getId());
                notifyItemRemoved(pos);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lutemons.size();
    }
}
