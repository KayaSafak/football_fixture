package com.example.phiapp.Models;

import com.example.phiapp.Models.Enums.Pozisyon;

import java.io.Serializable;

public abstract class RootOzellik implements Serializable {

    protected abstract void generate(Pozisyon futbolcuPozisyonu);

    protected abstract double getAvgGuc();
}
