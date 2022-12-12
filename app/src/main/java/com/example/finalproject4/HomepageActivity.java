package com.example.finalproject4;

import static com.example.finalproject4.Database.Preference.DATABASE_REFERENCE;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class HomepageActivity extends AppCompatActivity {
    private static final String TAG = "HomepageActivity";

    private EditText kotaAsal, kotaTujuan, jmlPenumpang;
    private TextView tanggal;
    private Button book;

    private String inpKotaAsal, inpKotaTujuan, inpJmlPenumpang, inptTanggal;

    private DatePickerDialog.OnDateSetListener pilihTanggal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        kotaAsal = findViewById(R.id.et_departure);
        kotaTujuan = findViewById(R.id.et_arival);
        jmlPenumpang = findViewById(R.id.et_passenger);
        tanggal = findViewById(R.id.et_date);
        book = findViewById(R.id.et_book);


        tanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar kalender = Calendar.getInstance();
                int tahun = kalender.get(Calendar.YEAR);
                int bulan = kalender.get(Calendar.MONTH);
                int hari = kalender.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog popup = new DatePickerDialog(
                        HomepageActivity.this, android.R.style.Theme_Holo_Light,
                        pilihTanggal, tahun, bulan, hari);
                popup.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                popup.show();
            }
        });

        pilihTanggal = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int tahun, int bulan, int hari) {
                bulan = bulan + 1;
                Log.d(TAG, "onDateSet: dd/mm/yyy"+hari+"/"+bulan+"/"+tahun);

                String tgl = hari + "/" + bulan + "/" + tahun;
                tanggal.setText(tgl);
            }
        };

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                storeData();
            }
        });
    }

    private void storeData() {
        inpKotaAsal = kotaAsal.getText().toString();
        inpKotaTujuan = kotaTujuan.getText().toString();
        inpJmlPenumpang = jmlPenumpang.getText().toString();
        inptTanggal = tanggal.getText().toString();

        if (inpKotaAsal.isEmpty() || inpKotaTujuan.isEmpty())
        {
            Toast.makeText(HomepageActivity.this, "Please fill the Input Field", Toast.LENGTH_LONG).show();
        }
        else if (inpJmlPenumpang.equals("5"))
        {
            Toast.makeText(HomepageActivity.this, "Max 4 Passengers", Toast.LENGTH_LONG).show();
        }
        else
        {
            DATABASE_REFERENCE.child("Travel").child("Book_Tickets").child("KtAsal").setValue(inpKotaAsal);
            DATABASE_REFERENCE.child("Travel").child("Book_Tickets").child("KtTujuan").setValue(inpKotaTujuan);
            DATABASE_REFERENCE.child("Travel").child("Book_Tickets").child("JmlPenumpang").setValue(inpJmlPenumpang);
            DATABASE_REFERENCE.child("Travel").child("Book_Tickets").child("Tanggal").setValue(inptTanggal);
            Toast.makeText(HomepageActivity.this, "Input Success", Toast.LENGTH_LONG).show();

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    final Intent mainIntent = new Intent(HomepageActivity.this, BookingPage.class);
                    mainIntent.putExtra("KtAsal", inpKotaAsal);
                    mainIntent.putExtra("KtTujuan", inpKotaTujuan);
                    mainIntent.putExtra("JmlPenumpang", inpJmlPenumpang);
                    mainIntent.putExtra("Tanggal", inptTanggal);

                    HomepageActivity.this.startActivity(mainIntent);
                    HomepageActivity.this.finish();
                }
            }, 1500);
        }
    }

    }
