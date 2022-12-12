package com.example.finalproject4;

import static com.example.finalproject4.Database.Preference.DATABASE_REFERENCE;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class BookingPage extends AppCompatActivity {
    private TextView kotaAsal, kotaTujuan, jmlPenumpang, tanggal, hargaTiket;

    private int harga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        DATABASE_REFERENCE.getDatabase().getReference().child("Travel").child("Book_Tickets");

        kotaAsal = findViewById(R.id.et_getKotaAsal);
        kotaTujuan = findViewById(R.id.et_getKotaTujuan);
        jmlPenumpang = findViewById(R.id.et_getJmlPenumpang);
        tanggal = findViewById(R.id.et_getTanggal);
        hargaTiket = findViewById(R.id.et_getHargaTiket);

        showData();

    }

    private void showData() {
        Intent intent = getIntent();

        String getKotaAsal = intent.getStringExtra("KtAsal");
        String getKotaTujuan = intent.getStringExtra("KtTujuan");
        String getTangal = intent.getStringExtra("Tanggal");
        String getJmlPenumpang = intent.getStringExtra("JmlPenumpang");

        kotaAsal.setText(getKotaAsal);
        kotaTujuan.setText(getKotaTujuan);
        tanggal.setText(getTangal);
        jmlPenumpang.setText(getJmlPenumpang);

        if (getJmlPenumpang.equals("4"))
        {
            harga = 150000 * 4;
            String hrg = Integer.toString(harga);
            hargaTiket.setText(hrg);
        }
        if (getJmlPenumpang.equals("3"))
        {
            harga = 150000 * 3;
            String hrg = Integer.toString(harga);
            hargaTiket.setText(hrg);
        }
        if (getJmlPenumpang.equals("2"))
        {
            harga = 150000 * 2;
            String hrg = Integer.toString(harga);
            hargaTiket.setText(hrg);
        }
        if (getJmlPenumpang.equals("1"))
        {
            harga = 150000;
            String hrg = Integer.toString(harga);
            hargaTiket.setText(hrg);
        }
    }

}
