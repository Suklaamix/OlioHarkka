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


public class LutemonTrainAdapter extends RecyclerView.Adapter<LutemonTrainViewHolder> {

    private String listName;
    private Context context;
    private ArrayList<Lutemon> lutemons = new ArrayList<>();

    public LutemonTrainAdapter(Context context, ArrayList<Lutemon> lutemons, String listName) {
        this.context = context;
        this.lutemons = lutemons;
        this.listName = listName;
    }

    @NonNull
    @Override
    public LutemonTrainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LutemonTrainViewHolder(LayoutInflater.from(context).inflate(R.layout.lutemon_train_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LutemonTrainViewHolder holder, int position) {
        Lutemon lutemon = lutemons.get(position);
        if (lutemon != null) {
            holder.lutemonName.setText("ID " + lutemon.getId() +" : " +lutemon.getName() + " (" + lutemon.getColor() +")");
            holder.lutemonLvl.setText("Kokemus " + lutemon.getLvl() + " Treenit " + lutemon.getTrainingCount()+ " Taistelut "+ lutemon.getBattleCount());
            holder.switchHome.setImageResource(R.drawable.home);
        }
        holder.switchHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listName.equals("BattleField")) {
                    int pos = holder.getAdapterPosition();
                    Home.getInstance().addLutemon(lutemons.get(pos));
                    BattleField.getInstance().deleteLutemonById(lutemons.get(pos).getId());
                    notifyItemRemoved(pos);
                } else if (listName.equals("TrainArea")) {
                    int pos = holder.getAdapterPosition();
                    Home.getInstance().addLutemon(lutemons.get(pos));
                    TrainArea.getInstance().deleteLutemonById(lutemons.get(pos).getId());
                    notifyItemRemoved(pos);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return lutemons.size();
    }
}

