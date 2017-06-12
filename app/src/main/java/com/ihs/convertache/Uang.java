package com.ihs.convertache;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONObject;

public class Uang extends AppCompatActivity implements View.OnClickListener {

    EditText input;
    Button hitung, clear;
    TextView hasil;
    Spinner spin;
    double result;
    ProgressDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uang);

        getSupportActionBar().setTitle("Konversi Mata Uang");


        input = (EditText) findViewById(R.id.edInput);
        hitung = (Button) findViewById(R.id.btnCount);
        clear= (Button) findViewById(R.id.btnClear);
        spin = (Spinner) findViewById(R.id.spinMataUang);
        hasil = (TextView) findViewById(R.id.tvHasil);

        mDialog=new ProgressDialog(this);
        mDialog.setMessage("Sedang mencari");
        mDialog.setCancelable(false);

        hitung.setOnClickListener(this);
        clear.setOnClickListener(this);


    }
    private void queryData(final double amount, String currency, String source){
        Log.d("apps","test1");
//        String source = "USD", currency ="IDR";
        String url ="http://apilayer.net/api/live?access_key=c01f91644f025aa883452b1e0660bad7&currencies="+currency+"&source="+source+"&format=1";
        AsyncHttpClient client =new AsyncHttpClient();
        Log.d("apps","test2");
        mDialog.show();
        client.get(url, new JsonHttpResponseHandler(){
            public void onSuccess(JSONObject jsonObject){
                Log.d("apps","test3");
                mDialog.dismiss();
                Toast.makeText(getApplicationContext(),"Sukses", Toast.LENGTH_SHORT).show();
                double rst=0;
                try {
                    String[] konversi = jsonObject.getString("quotes").toString().split(":");
                    double num = Double.parseDouble(konversi[1].toString().replace("}","")) * amount;
                    //hasil dari perhitungan, tinggal variabel num dimasukin ke variabel yang mau gigunakan
                    hasil.setText(String.valueOf(num));

                }catch (Exception ex){
                    Log.d("aplikasi", ex.getMessage());

                }
            }
            public void onFailure(int statusCode, Throwable throwable, JSONObject error){
                Log.d("apps","test4");
                mDialog.dismiss();
                Toast.makeText(getApplicationContext(), "Error: " + statusCode + " " + throwable.getMessage(), Toast.LENGTH_LONG).show();
                Log.e("aplikasi-mobile.com", statusCode + " " + throwable.getMessage());
            }
        });
    }
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btnCount:
                double h = Double.parseDouble(input.getText().toString());

                int posisi = spin.getSelectedItemPosition();
                String currency = null;
                switch (posisi) {
                    case 0:
                        currency = "IDR";
//                        result = ;
                        break;
                    case 1:
                        currency="JPY";
                        break;
                    case 2:
                        currency="EUR";
                        break;
                    case 3:
                        currency="GBP";
                        break;
                    case 4:
                        currency="AUD";
                        break;
                    case 5:
                        currency="CHF";
                        break;
                    case 6:
                        currency="CAD";
                        break;
                    case 7:
                        currency="BTC";
                        break;
                    case 8:
                        currency="MYR";
                        break;
                    case 9:
                        currency="THB";
                        break;

                }

                this.queryData(h, currency, "USD");
                break;
            case R.id.btnClear:
                input.setText("");
                hasil.setText("");
                break;
        }
    }

}
