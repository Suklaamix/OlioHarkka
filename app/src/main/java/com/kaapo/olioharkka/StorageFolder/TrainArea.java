package com.kaapo.olioharkka.StorageFolder;

import com.kaapo.olioharkka.LutemonFolder.Lutemon;


import java.util.ArrayList;

public class TrainArea extends LutemonStorage {
    private static TrainArea storage = null;

    public TrainArea() {
        super();
    }

    public static TrainArea getInstance() {
        if (storage == null) {
            storage = new TrainArea();
        }
        return storage;
    }

    @Override
    public ArrayList<Lutemon> getLutemonList() {
        return super.getLutemonList();
    }
}

