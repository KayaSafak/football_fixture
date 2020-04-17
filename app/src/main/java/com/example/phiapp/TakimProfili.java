package com.example.phiapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import com.example.phiapp.Fragments.FragmentCustomAdapter;
import com.example.phiapp.Fragments.FragmentFikstur;
import com.example.phiapp.Fragments.FragmentFutbolcu;
import com.example.phiapp.Fragments.FragmentGuc;
import com.example.phiapp.Models.Mac;
import com.example.phiapp.Models.Takim;
import com.example.phiapp.Utils.UtilMethods;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.List;

public class TakimProfili extends AppCompatActivity {
int[] imgs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_takim_profili);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                FLAG_FULLSCREEN);
        ViewPager viewPager=(ViewPager) findViewById(R.id.viewpager);
        TabLayout tabLayout=(TabLayout) findViewById(R.id.tl_profile);

        FragmentCustomAdapter adapters=new FragmentCustomAdapter(getSupportFragmentManager());

        adapters.addFragment(FragmentFikstur.newInstance(),"Fixture");
        adapters.addFragment(FragmentFutbolcu.newInstance(),"Player");
        adapters.addFragment(FragmentGuc.newInstance(),"Power");
        viewPager.setAdapter(adapters);

        tabLayout.setupWithViewPager(viewPager);


        Takim team= (Takim) getIntent().getSerializableExtra("team");
        getSupportActionBar().setTitle(team.getIsim());



       /*TextView text1 = (TextView) findViewById(R.id.textView4);
        text1.setText(String.valueOf((int)Math.ceil( team.getAvgGuc())));
        TextView text2 = (TextView) findViewById(R.id.textView5);
        text2.setText(String.valueOf((int)Math.ceil( team.getAvgHucum())));
        TextView text3 = (TextView) findViewById(R.id.textView6);
        text3.setText(String.valueOf((int)Math.ceil( team.getAvgSavunma())));*/

       // show(team);

    }
    public void show(Takim team)
    {
        List<Mac> takimMaclari=new ArrayList<>();

        for (int i=1;i<=34;i++) {
            List<Mac> macList = UtilMethods.fikstur.get(i);

            for (Mac m :
                    macList) {
                if (team.getIsim().equals(m.getHomeTeam().getIsim()) ||
                        team.getIsim().equals(m.getAwayTeam().getIsim())) {
                    takimMaclari.add(m);
                    Log.i("---", m.getHomeTeam().getIsim() + " vs " + m.getAwayTeam().getIsim());
                    break;
                }
            }
        }
       ListView listView = (ListView) findViewById(R.id.liste_fiks);
        //CustomAdapter customAdapter =new CustomAdapter(this.imgs);
        ArrayAdapter<Mac> arrayAdapter = new ArrayAdapter<Mac>(this,android.R.layout.simple_expandable_list_item_1,takimMaclari);
        listView.setAdapter(arrayAdapter);
    }


}
