package com.ihs.convertache;

import android.icu.text.DecimalFormat;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by IHS on 5/11/2017.
 */

public class Bilangan extends AppCompatActivity implements View.OnClickListener {
    EditText input;
    Button hitung, clear;
    TextView hasil;
    Spinner spin;
    int p;
    String result;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bilangan);

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
        switch (v.getId()) {
            case R.id.btnClear:
                input.setText("");
                hasil.setText("");
                break;
            case R.id.btnCount:
                String text = input.getText().toString();
                if (text.isEmpty()) {
                    Toast.makeText(Bilangan.this, "Bilangan awal masih kosong",
                            Toast.LENGTH_SHORT).show();
                } else {
                    int posisi = spin.getSelectedItemPosition();
                    switch (posisi) {
                        case 0:
                            p = Integer.parseInt(input.getText().toString(), 2);
                            result = String.format("%d", p);
                            break;
                        case 1:
                            p=Integer.parseInt(input.getText().toString(), 2);
                            result = Integer.toOctalString(p);
                            break;
                        case 2:
                            p = Integer.parseInt(input.getText().toString(), 2);
                            result = Integer.toHexString(p);
                            break;
                        case 3:
                            p = Integer.parseInt(input.getText().toString(), 8);
                            String result = Integer.toBinaryString(p);
                            break;
                        case 4:
                            p = Integer.parseInt(input.getText().toString(), 8);
                            result = String.format("%d", p);
                            break;
                        case 5:
                            p = Integer.parseInt(input.getText().toString(), 8);
                            result = Integer.toHexString(p);
                            break;
                        case 6:
                            p = Integer.parseInt(input.getText().toString());
                            result = Integer.toBinaryString(p);
                            break;
                        case 7:
                            p = Integer.parseInt(input.getText().toString());
                            result = Integer.toOctalString(p);
                            break;
                        case 8:
                            p = Integer.parseInt(input.getText().toString());
                            result = Integer.toHexString(p);
                            break;
                        case 9:
                            p = Integer.parseInt(input.getText().toString(), 16);
                            result = Integer.toBinaryString(p);
                            break;
                        case 10:
                            p = Integer.parseInt(input.getText().toString(), 16);
                            result = Integer.toString(p);
                            break;
                        case 11:
                            p = Integer.parseInt(input.getText().toString(), 16);
                            result = Integer.toOctalString(p);
                            break;
                    }
                    hasil.setText("" + result);
                }
                break;
           }
    }
}
