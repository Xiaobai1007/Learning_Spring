package com.learning.components;


public class Donkey {
    private String name;
    private float weight;
    private DonkeyWife df;

    public Donkey() {
    }

    public Donkey(String name, float weight, DonkeyWife df) {
        this.name = name;
        this.weight = weight;
        this.df = df;
    }
}

// Donkey d = new Donkey("的水", 333);
