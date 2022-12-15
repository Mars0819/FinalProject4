package com.example.finalproject4;

import static com.example.finalproject4.Database.Preference.DATABASE_REFERENCE;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BookingPage extends AppCompatActivity {
    private TextView kotaAsal, kotaTujuan, jmlPenumpang, tanggal, hargaTiket;
    private Button cancel, booking;
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

        cancel = findViewById(R.id.cancelbooking);
        booking = findViewById(R.id.bookingnow);

        showData();
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BookingPage.this,booking.class));
                finish();
            }
        });
        booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BookingPage.this, "Input Success", Toast.LENGTH_LONG).show();
                startActivity(new Intent(BookingPage.this,pilihkursi.class));

            }
        });


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
