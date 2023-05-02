package com.kaapo.olioharkka.StorageFolder;

import com.kaapo.olioharkka.LutemonFolder.Lutemon;

import java.util.ArrayList;

public class LutemonStorage {
    private static LutemonStorage storage = null;

    private ArrayList<Lutemon> lutemonList;

    public LutemonStorage() {
        lutemonList = new ArrayList<>();
    }

    /** static LutemonStorage getInstance() {
        if (storage == null) {
            storage = new LutemonStorage();
        }
        return storage;
    }**/

    public void addLutemon(Lutemon lutemon) {
        lutemonList.add(lutemon);
    }

    public ArrayList<Lutemon> getLutemonList() {
        return lutemonList;
    }

    public Lutemon getLutemonById(int id) {
        for (Lutemon lutemon : lutemonList) {
            if (lutemon.getId() == id) {
                return lutemon;
            }
        }
        return null;
    }

    public void deleteLutemonById(int id) {
        for (Lutemon lutemon : lutemonList) {
            if (lutemon.getId() == id) {
                lutemonList.remove(lutemon);
                break;
            }
        }
    }
}
