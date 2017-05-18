package com.ihs.convertache;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by IHS on 5/11/2017.
 */

public class Massa extends AppCompatActivity implements View.OnClickListener{
    EditText input;
    Button hitung, clear;
    TextView hasil;
    Spinner spin;
    int p;
    String result;
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_massa);

        getSupportActionBar().setTitle("Konversi Massa");

        input = (EditText) findViewById(R.id.edInput);
        hitung = (Button) findViewById(R.id.btnCount);
        clear = (Button) findViewById(R.id.btnClear);
        spin = (Spinner) findViewById(R.id.spinBilangan);
        hasil = (TextView) findViewById(R.id.tvHasil);

        hitung.setOnClickListener(this);
        clear.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnCount:
                int h = Integer.parseInt(input.getText().toString());

                int posisi = spin.getSelectedItemPosition();
                switch (posisi) {
                    case 0:
                        p = 1000 * h;
                        result = String.format("%d", p);
                        break;
                    case 1:
                        p = 1440 * h;
                        result = String.format("%d", p);
                        break;
                    case 2:
                        p = 86400 * h;
                        result = String.format("%d", p);
                        break;
                    case 3:
                        p = 24 * h / 100;
                        result = String.format("%d", p);
                        break;
                    case 4:
                        p = 60 * h;
                        result = String.format("%d", p);
                        break;
                    case 5:
                        p = 3600 * h;
                        result = String.format("%d", p);
                        break;
                    case 6:
                        p = 1440 * h / 10000;
                        result = String.format("%d", p);
                        break;
                    case 7:
                        p = 60 * h / 100;
                        result = String.format("%d", p);
                        break;
                    case 8:
                        p = 60 * h;
                        result = String.format("%d", p);
                        break;
                    case 9:
                        p = 86400 * h/100000;
                        result = String.format("%d", p);
                        break;
                    case 10:
                        p = 3600 * h/100000;
                        result = String.format("%d", p);
                        break;
                    case 11:
                        p = 60 * h/100;
                        result = String.format("%d", p);
                        break;


                }hasil.setText("" + result);
                break;
            case R.id.btnClear:
                input.setText("");
                hasil.setText("");
                break;
        }
    }
}
