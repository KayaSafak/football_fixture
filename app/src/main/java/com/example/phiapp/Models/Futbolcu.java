package com.example.phiapp.Models;

import com.example.phiapp.Models.Enums.Pozisyon;
import com.example.phiapp.Utils.UtilMethods;
import java.io.Serializable;

public class Futbolcu implements Serializable {
    private int yas;
    private String isim;
    private Pozisyon pozisyon;
    private FizikselOzellik fizikselOzellik;
    private TeknikOzellik teknikOzellik;
    private MentalOzellik mentalOzellik;
    private Kaleci Kaleci;

    public Futbolcu(Pozisyon pozisyon) {
        yas = 18 + (int) Math.random() * 17;
        isim = UtilMethods.isimOlusturma();
        this.pozisyon = pozisyon;
        fizikselOzellik = fizikselOzellikOlustur();
        teknikOzellik = teknikOzellikOlustur();
        mentalOzellik = mentalOzellikOlustur();
        Kaleci = KaleciOlustur();

    }


    public double getAvgGuc() {
        return (teknikOzellik.getAvgGuc() + fizikselOzellik.getAvgGuc() + mentalOzellik.getAvgGuc()
                + Kaleci.getAvgGuc()) / 4;
    }

    private MentalOzellik mentalOzellikOlustur() {
        MentalOzellik mentalOzellik = new MentalOzellik();
        mentalOzellik.generate(this.pozisyon);
        return mentalOzellik;
    }

    private TeknikOzellik teknikOzellikOlustur() {
        TeknikOzellik teknikOzellik = new TeknikOzellik();
        teknikOzellik.generate(this.pozisyon);
        return teknikOzellik;
    }

    private FizikselOzellik fizikselOzellikOlustur() {
        FizikselOzellik fizikselOzellik = new FizikselOzellik();
        fizikselOzellik.generate(this.pozisyon);
        return fizikselOzellik;
    }
    private Kaleci KaleciOlustur() {
        Kaleci Kaleci = new Kaleci();
        Kaleci.generate(this.pozisyon);
        return Kaleci;
    }
    public FizikselOzellik getFizikselOzellik() {
        return fizikselOzellik;
    }
    public void setFizikselOzellik(FizikselOzellik fizikselOzellik) {
        this.fizikselOzellik = fizikselOzellik;
    }
    public TeknikOzellik getTeknikOzellik() {
        return teknikOzellik;
    }
    public void setTeknikOzellik(TeknikOzellik teknikOzellik) {
        this.teknikOzellik = teknikOzellik;
    }
    public MentalOzellik getMentalOzellik() {
        return mentalOzellik;
    }

    public void setMentalOzellik(MentalOzellik mentalOzellik) {
        this.mentalOzellik = mentalOzellik;
    }
    public Kaleci getKaleci() {
        return Kaleci;
    }
    public void setKaleci(Kaleci Kaleci) {
        this.Kaleci = Kaleci;
    }
    public int getYas() {
        return yas;
    }
    public void setYas(int yas) {
        this.yas = yas;
    }
    public String getIsim() {
        return isim;
    }
    public void setIsim(String isim) {
        this.isim = isim;
    }
    @Override
    public String toString() {
        return getIsim();
    }
}

