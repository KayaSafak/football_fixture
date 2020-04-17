package com.example.phiapp.Fragments;

import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.phiapp.Models.Takim;
import com.example.phiapp.R;

public class FragmentGuc extends Fragment {

    public FragmentGuc() {
        // Required empty public constructor
    }

    public static FragmentGuc newInstance() {
        FragmentGuc fragment = new FragmentGuc();
       /* Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);*/
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_guc,container,false);

        Takim team= (Takim) getActivity().getIntent().getSerializableExtra("team");

        TextView text1 = view.findViewById(R.id.textView4);
        text1.setText(String.valueOf((int)Math.ceil( team.getAvgGuc())));
        TextView text2 = view.findViewById(R.id.textView5);
        text2.setText(String.valueOf((int)Math.ceil( team.getAvgHucum())));
        TextView text3 = view.findViewById(R.id.textView6);
        text3.setText(String.valueOf((int)Math.ceil( team.getAvgSavunma())));

                return view;
    }
}
