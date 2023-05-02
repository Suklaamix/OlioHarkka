package com.kaapo.olioharkka.LutemonFolder;

import android.widget.TextView;

import com.kaapo.olioharkka.StorageFolder.BattleField;

public class Lutemon {
    protected String name;
    protected String color;
    protected int attack;

    protected int defense;
    protected int health;

    protected int maxHealth;
    protected int id;
    protected int trainingCount;
    protected int battleCount;

    protected int lvl;
    private static int idCounter;
    protected int image;

    public Lutemon(String name, String color, int attack, int defense, int health, int maxHealth, int trainC, int battleC, int lvl) {
        this.name = name;
        this.color = color;
        this.attack = attack;
        this.defense = defense;
        this.health = health;
        this.maxHealth = maxHealth;
        this.trainingCount = trainC;
        this.battleCount = battleC;
        this.lvl = lvl;
        this.id = ++idCounter;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getId() {
        return id;
    }

    public int getImage() {
        return image;
    }

    public int getTrainingCount() {
        return trainingCount;
    }

    public int getBattleCount() {
        return battleCount;
    }

    public int getLvl() {
        return lvl;
    }

    public static int getNumberOfCreatedLutemons() {
        return idCounter;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void setTrainingCount(int trainingCount) {
        this.trainingCount = trainingCount;
    }

    public void setBattleCount(int battleCount) {
        this.battleCount = battleCount;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public void lvlUp() {
        setLvl(this.getLvl() + 1);
        setAttack(this.getAttack() + 1);
        setDefense(this.getDefense() + 1);
        setMaxHealth(this.getMaxHealth() + 2);
        setHealth(this.getMaxHealth());
    }

    public String stats() {
        return this.getId() + ": " + this.getName() + " att: " + this.getAttack() + "; def: " + this.getDefense() + "; health " + this.getHealth() + "/" + this.getMaxHealth() + "\n";

    }
    public void battle(Lutemon opponent, TextView textView) {
        while (this.getHealth() > 0 && opponent.getHealth() > 0) {
            textView.append(this.stats());
            textView.append(opponent.stats());
            textView.append(this.getId() + ": " + this.getName() + " attacks " + opponent.getId() + ": " + opponent.getName() + "\n");
            opponent.setHealth(opponent.getHealth() - (this.getAttack() - opponent.getDefense()));
            if (opponent.getHealth() > 0) {
                textView.append(opponent.getId() + ": " + opponent.getName() + " manages to escape death\n");
            } else {
                textView.append(opponent.getId() + ": " + opponent.getName() + " gets killed.\n");
                textView.append("Battle is over\n");
                BattleField.getInstance().deleteLutemonById(opponent.getId());
                this.lvlUp();
                this.setBattleCount(this.getBattleCount() + 1);
                break;
            }

            textView.append(opponent.stats());
            textView.append(this.stats());
            textView.append(opponent.getId() + ": " + opponent.getName() + " attacks " + this.getId() + ": " + this.getName() + "\n");
            this.setHealth(this.getHealth() - (opponent.getAttack() - this.getDefense()));
            if (this.getHealth() > 0) {
                textView.append(this.getId() + ": " + this.getName() + " manages to escape death\n");
            } else {
                textView.append(this.getId() + ": " + this.getName() + " gets killed.\n");
                textView.append("Battle is over\n");
                BattleField.getInstance().deleteLutemonById(this.getId());
                opponent.setBattleCount(opponent.getBattleCount() + 1);
                opponent.lvlUp();
                break;
            }

        }
    }
}

