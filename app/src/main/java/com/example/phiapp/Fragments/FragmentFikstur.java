package com.example.phiapp.Fragments;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.phiapp.Models.Mac;
import com.example.phiapp.Models.Takim;
import com.example.phiapp.R;
import com.example.phiapp.Utils.UtilMethods;
import java.util.ArrayList;
import java.util.List;

public class FragmentFikstur extends Fragment {
    public FragmentFikstur() {
    }
    public static FragmentFikstur newInstance() {
        FragmentFikstur fragment = new FragmentFikstur();
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Takim team = (Takim) getActivity().getIntent().getSerializableExtra("team");
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fikstur, container, false);
        ListView lvFikstur = view.findViewById(R.id.liste_fiks);
        List<Mac> takimMaclari = new ArrayList<>();

        for (int i = 1; i <= 34; i++) {
            List<Mac> macList = UtilMethods.fikstur.get(i);

            for (Mac m :
                    macList) {
                if (team.getIsim().equals(m.getHomeTeam().getIsim()) ||
                        team.getIsim().equals(m.getAwayTeam().getIsim())) {
                    takimMaclari.add(m);
                    break;
                }
            }
        }
        ArrayAdapter<Mac> arrayAdapter = new ArrayAdapter<Mac>(getActivity(), android.R.layout.simple_expandable_list_item_1, takimMaclari);
        lvFikstur.setAdapter(arrayAdapter);
        return view;
    }

}
