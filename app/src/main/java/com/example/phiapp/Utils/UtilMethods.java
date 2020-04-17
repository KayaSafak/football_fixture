package com.example.phiapp.Utils;

import com.example.phiapp.Models.Futbolcu;
import com.example.phiapp.Models.Mac;
import com.example.phiapp.Models.Takim;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import static com.example.phiapp.Models.Lig.takimlar;

public class UtilMethods {

    public static HashMap<Integer, List<Mac>> fikstur= new HashMap<>();


    public static void  name()
    {
        String[] names = {"Alanyaspor", "Antalyaspor", "İstanbul Başakşehir", "Beşiktaş", "Çaykur Rizespor", "Denizlispor",
                "Fenerbahçe", "Galatasaray", "Gazişehir Gaziantep", "Gençlerbirliği", "Göztepe", "Kasımpaşa", "Kayserispor",
                "Konyaspor", "MKE Ankaragücü", "Sivasspor", "Trabzonspor", "Yeni Malatyaspor"};
        for(int i=0;i<names.length;i++)
        {
            takimlar.add(new Takim(names[i]));
        }

    }

    public static String isimOlusturma() {
      /*Random rastgele = new Random();
        int rast = rastgele.nextInt(25) + 65;
        String isim = new Character((char) rast).toString();

        for (int i = 1; i < 10; i++) {
            rast = rastgele.nextInt(26) + 96;
            if (rast == 96)
                rast += 3;
            isim += new Character((char) rast).toString();*/

      Random rastgele=new Random();
      String [] isimlerOlusturma={"Bernardo Silva","Sami Khedira","Sadio Mane","Dani Alves","Marco Asensio","Falcao",
              "Icardi","Dele Alli","Leno","Claudio Marchisio","Stephane Ruffier","Ilkay Gündoğan","Danijel Subasic",
              "Raphael Varane","Danijel Subasic","Vincent Kompany","Kamil Glik","Mkhitaryan","Carrasco","Jan Vertonghen",
              "Angel di Maria","Filipe Luis","Lorenzo Insigne","Cesar Azpilicueta","Miralem Pjanic","Jordi Alba","Keylor Navas",
              };
      int rast =rastgele.nextInt(isimlerOlusturma.length);

      return isimlerOlusturma[rast];
        }


    }
