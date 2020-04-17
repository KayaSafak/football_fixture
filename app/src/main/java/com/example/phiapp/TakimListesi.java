package com.example.phiapp;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.phiapp.Adapter.CustomAdapter;
import com.example.phiapp.Models.Lig;
import com.example.phiapp.Models.Mac;
import com.example.phiapp.Models.Takim;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import java.util.ArrayList;
import java.util.List;
import az.openweatherapi.OWService;
import az.openweatherapi.listener.OWRequestListener;
import az.openweatherapi.model.OWResponse;
import az.openweatherapi.model.gson.common.Coord;
import az.openweatherapi.model.gson.current_day.CurrentWeather;
import az.openweatherapi.utils.OWSupportedUnits;

public class TakimListesi extends AppCompatActivity {
    private static final int MY_PERMISSIONS_REQUEST_LOCATION = 178;

    private Lig lig;
    private FusedLocationProviderClient fusedServices;

    int[] imgs={R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.f,R.drawable.g,R.drawable.h,
               R.drawable.i,R.drawable.j,R.drawable.k,R.drawable.l,R.drawable.m,R.drawable.n,R.drawable.o,R.drawable.p,
               R.drawable.r,R.drawable.s};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_takim_listesi);

        Resources res = getResources();

        fusedServices = LocationServices.getFusedLocationProviderClient(TakimListesi.this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION
                        , Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSIONS_REQUEST_LOCATION);
            } else {
                sendLocationToServer();
            }
        } else {
            sendLocationToServer();
        }

        Lig lig = new Lig();
        lig.fiksturOlustur();
        show(lig.getTakimlar());

        for (int i = 1; i <= 34; i++) {
            List<Mac> macs = lig.getFikstur().get(i);

            System.out.println("  ");
            System.out.println("  ");
            System.out.println(i + ". hafta maclari");
            for (Mac mac : macs) {
                mac.yazdir();
            }

            for (Mac mac : macs) {
                mac.hazirla();
                mac.macOyna();
            }

            System.out.println("  ");
            System.out.println("  ");
            System.out.println(i + ". hafta mac sonuclari");
            for (Mac mac : macs) {
                mac.yazdir();
            }

            System.out.println("  ");
            System.out.println("  ");
            System.out.println(i + ". hafta  puan siralamasi");
            List<Takim> temp = new ArrayList<Takim>(lig.getTakimlar());
            for (int a = 0; a < temp.size() - 1; a++) {
                Takim takim = temp.get(a);
                int index = a;
                for (int b = a + 1; b < temp.size(); b++) {
                    if (isSmall(temp.get(b), takim)) {
                        takim = temp.get(b);
                        index = b;
                    }

                }

                if (index != a) {
                    temp.remove(index);
                    temp.add(index, temp.get(a));
                    temp.remove(a);
                    temp.add(a, takim);
                }
            }

            for (Takim takim : temp) {
                System.out.println(takim);
            }

        }
    }
    @SuppressLint("MissingPermission")
    private void sendLocationToServer() {
        fusedServices.getLastLocation().addOnSuccessListener(TakimListesi.this, new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null) {
                    OWService mOWService = new OWService("fe9447ea77fff3fa6d1d4a713b6ea456");
                    mOWService.setLanguage(getResources().getConfiguration().locale);
                    mOWService.setMetricUnits(OWSupportedUnits.METRIC);

                    Coord coordinate = new Coord();
                    coordinate.setLat(location.getLatitude());
                    coordinate.setLon(location.getLongitude());

                    mOWService.getCurrentDayForecast(coordinate, new OWRequestListener<CurrentWeather>() {
                        @Override
                        public void onResponse(OWResponse<CurrentWeather> response) {
                            CurrentWeather currentWeather = response.body();
                            //Do something with the object here!
                            //TODO Sonucu alert olarak gosterecegız.
                        }

                        @Override
                        public void onFailure(Throwable t) {
                            Log.e("-----", "Current Day Forecast request failed: " + t.getMessage());
                        }
                    });
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                    sendLocationToServer();
                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request.
        }
    }
    private static boolean isSmall(Takim takim, Takim takim2) {

        if (takim.getPuan() != takim2.getPuan())
            return takim.getPuan() > takim2.getPuan();

        if (takim.getAVG() != takim2.getAVG())
            return takim.getAVG() > takim2.getAVG();
        if (takim.getGolAt() != takim2.getGolAt())
            return takim.getGolAt() > takim2.getGolAt();

        return takim.getGal() > takim2.getGal();

    }

    public void show(final List<Takim> takimlar) {
        ListView listView = (ListView) findViewById(R.id.list1);
        CustomAdapter customAdapter = new CustomAdapter(TakimListesi.this, Lig.takimlar, imgs);
        listView.setAdapter(customAdapter);

        //  ArrayAdapter<Takim> arrayAdapter = new ArrayAdapter<Takim>(this, android.R.layout.simple_expandable_list_item_1, Lig.takimlar);
        // listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Takim t = takimlar.get(i);
                Intent intent = new Intent(TakimListesi.this, TakimProfili.class);
                intent.putExtra("team", t);
                startActivity(intent);
            }
        });
    }
}
