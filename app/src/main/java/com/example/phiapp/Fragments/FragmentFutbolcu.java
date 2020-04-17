package com.example.phiapp.Fragments;

import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.phiapp.Models.Futbolcu;
import com.example.phiapp.Models.Mac;
import com.example.phiapp.Models.Takim;
import com.example.phiapp.R;

public class FragmentFutbolcu extends Fragment {
private ListView listView;
    public FragmentFutbolcu() {
    }
    public static FragmentFutbolcu newInstance() {
        FragmentFutbolcu fragment = new FragmentFutbolcu();
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_futbolcu, container, false);

        final Takim takim= (Takim) getActivity().getIntent().getSerializableExtra("team");
        listView= view.findViewById(R.id.lv_player);

        ArrayAdapter<Futbolcu> arrayAdapter = new ArrayAdapter<Futbolcu>(getActivity(),android.R.layout.simple_expandable_list_item_1,takim.getFutbolcular());
        listView.setAdapter(arrayAdapter);


        return view;
    }

}
