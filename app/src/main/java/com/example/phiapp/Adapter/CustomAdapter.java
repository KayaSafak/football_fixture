package com.example.phiapp.Adapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.phiapp.Models.Takim;
import com.example.phiapp.R;
import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<Takim> {

    int[] imgs;
    public Context mContext;
    public List<Takim> takimlistesi = new ArrayList<>();
    public CustomAdapter(@NonNull Context context, @SuppressLint("SupportAnnotationUsage") @LayoutRes List<Takim> list, int[] imgs) {
        super(context, 0 , list);
        mContext = context;
        takimlistesi = list;
        this.imgs= imgs;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.satir,parent,false);
        Takim currentTakim= takimlistesi.get(position);
        ImageView image = (ImageView)listItem.findViewById(R.id.ivTeam);
       // image.setImageResource(currentTakim.get);
        image.setImageResource(imgs[position]);
        TextView name = listItem.findViewById(R.id.tvTakim);
        name.setText(currentTakim.getIsim());
        return listItem;
    }
}