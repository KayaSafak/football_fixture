package com.example.phiapp.Models;

import com.example.phiapp.Utils.UtilMethods;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Lig {

    public static List<Takim> takimlar = new ArrayList<Takim>();
    private HashMap<Integer, List<Mac>> fikstur = new HashMap<Integer, List<Mac>>();
    public void fiksturOlustur() {

        UtilMethods.name();
        List<Takim> temp = new ArrayList<Takim>(takimlar);
        List<Takim> ilkHafta = new ArrayList<Takim>();

        for (int i = 0; i < takimlar.size(); i++) {
            int index = new Random().nextInt(temp.size());
            ilkHafta.add(temp.get(index));
            temp.remove(index);
        }
        createWeek(1, ilkHafta);
        for (int i = 0; i < 16; i++) {
            Takim sonTakim = ilkHafta.get(takimlar.size() - 1);
            ilkHafta.remove(takimlar.size() - 1);
            ilkHafta.add(1, sonTakim);
            createWeek(i + 2, ilkHafta);
        }
    }
    private void createWeek(int hafta, List<Takim> takimlar) {
        List<Mac> haftaninMaclari = new ArrayList<Mac>();
        List<Mac> rovansMaclari = new ArrayList<Mac>();
        for (int i = 0; i < 9; i++) {
            haftaninMaclari.add(new Mac(takimlar.get(i), takimlar.get(17 - i)));
            rovansMaclari.add(new Mac(takimlar.get(17 - i), takimlar.get(i)));
        }
        fikstur.put(hafta, haftaninMaclari);
        fikstur.put(hafta + 17, rovansMaclari);
        UtilMethods.fikstur.put(hafta, haftaninMaclari);
        UtilMethods.fikstur.put(hafta + 17, rovansMaclari);
    }
    public static void main1(String[] args) {
        int[] dizi = { 8, 2, 9, 7 };

        for (int i = 0; i < 3; i++) {
            int sayi = dizi[i]; // sıradaki değeri sayi değişkenine atıyoruz
            int temp = i;
            for (int j = i + 1; j < 4; j++) {

                if (dizi[j] > sayi) { // sayi değişkeninden küçük sayı var mı
                    sayi = dizi[j]; // varsa sayi değişkenimizide değiştiriyoruz
                    temp = j; // indeks değerinide değiştiriyoruz
                }
            }
            if (temp != i) { // temp değeri başlangıç değeri ile aynı değil ise , yani list[i]'nin değerinden
                // küçük sayı varsa onları yer değiştiriyoruz
                dizi[temp] = dizi[i];
                dizi[i] = sayi;
            }
        }
        for (int j = 0; j < 4; j++) {
            System.out.println(dizi[j]);
        }
    }
    public List<Takim> getTakimlar() {
        return takimlar;
    }
    public void setTakimlar(List<Takim> takimlar) {
        this.takimlar = takimlar;
    }
    public HashMap<Integer, List<Mac>> getFikstur() {
        return fikstur;
    }
    public void setFikstur(HashMap<Integer, List<Mac>> fikstur) {
        this.fikstur = fikstur;
    }
}

