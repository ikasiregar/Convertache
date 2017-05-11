package com.ihs.convertache;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by IHS on 5/11/2017.
 */

public class Dashboard extends AppCompatActivity implements AdapterView.OnItemClickListener {

    String[] itemJenis= {
            "Suhu",
            "Bilangan",
            "Waktu",
            "Massa"
    };

    Integer[] itemImage={
            R.drawable.temp,
            R.drawable.bil,
            R.drawable.time,
            R.drawable.mass
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        getSupportActionBar().setTitle("Jenis Konversi");

        Adapter adapter = new Adapter(this, itemJenis, itemImage);

        ListView listView= (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String select = itemJenis[+position];

        if (select == "Suhu"){
            Intent intent = new Intent(this, Suhu.class);
            startActivity(intent);
        }else if(select == "Bilangan"){
            Intent intent = new Intent(this, Bilangan.class);
            startActivity(intent);
        }
//        Toast.makeText(getApplicationContext(), select,
//                Toast.LENGTH_SHORT).show();
    };
}
