package com.kaapo.olioharkka.StorageFolder;

import com.kaapo.olioharkka.LutemonFolder.Lutemon;


import java.util.ArrayList;

public class BattleField extends LutemonStorage {
    private static BattleField storage = null;

    public BattleField() {
        super();
    }

    public static BattleField getInstance() {
        if (storage == null) {
            storage = new BattleField();
        }
        return storage;
    }

    @Override
    public ArrayList<Lutemon> getLutemonList() {
        return super.getLutemonList();
    }
}

