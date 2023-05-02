package com.kaapo.olioharkka.StorageFolder;

import com.kaapo.olioharkka.LutemonFolder.Lutemon;


import java.util.ArrayList;

public class Home extends LutemonStorage {
    private static Home storage = null;

    public Home() {
        super();
    }

    public static Home getInstance() {
        if (storage == null) {
            storage = new Home();
        }
        return storage;
    }

    public void createLutemon(Lutemon lutemon) {
        super.addLutemon(lutemon);
    }

    @Override
    public ArrayList<Lutemon> getLutemonList() {
        return super.getLutemonList();
    }
}

