package com.ihs.convertache;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by IHS on 5/11/2017.
 */

public class Adapter extends ArrayAdapter<String>{
    private final Activity context;
    private final String[] itemJenis;
    private final Integer[] itemImage;


    public Adapter(Activity context, String[] itemJenis, Integer[] itemImage) {
        super(context, R.layout.my_menu, itemJenis);
        this.context = context;
        this.itemJenis = itemJenis;
        this.itemImage = itemImage;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.my_menu, null, true);

        ImageView imageView = (ImageView)rowView.findViewById(R.id.gambar);
        TextView tvNama = (TextView)rowView.findViewById(R.id.jenis);

        imageView.setImageResource(itemImage[position]);

        return rowView;
    }
}
