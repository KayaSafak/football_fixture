package com.example.phiapp.Models;

import com.example.phiapp.Models.Enums.Pozisyon;

import java.io.Serializable;
import java.util.List;
import java.util.Random;

public class Ozellik implements Serializable {
    private int value;
    private List<Pozisyon> pozisyonlar;

    public Ozellik(List<Pozisyon> pozisyonlar) {
        this.pozisyonlar = pozisyonlar;

    }

    public void calculateValue(boolean isHomeGame) {
        int altLimit = isHomeGame ? 60 : 10;
        int ustLimit = isHomeGame ? 100 : 50;

        Random rnd = new Random();
        this.value = rnd.nextInt(ustLimit - altLimit) + altLimit;
    }

    public void calculateValue(Pozisyon futbolcuPozisyonu) {
        int altLimit = 10;
        int ustLimit = 100;
        if (this.pozisyonlar != null) {
            boolean contains = this.pozisyonlar.contains(futbolcuPozisyonu);
            altLimit = contains ? 60 : 10;
            ustLimit = contains ? 100 : 50;
        }
        Random rnd = new Random();
        this.value = rnd.nextInt(ustLimit - altLimit) + altLimit;
    }

    public int getValue() {
        return value;
    }

}



