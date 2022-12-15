package com.example.finalproject4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;

import com.example.finalproject4.databinding.ActivityPilihkursiBinding;

public class pilihkursi extends AppCompatActivity implements View.OnClickListener {
    private ActivityPilihkursiBinding binding;
    private boolean isBooked;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilihkursi);
        binding = ActivityPilihkursiBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        isBooked = false;

        binding.seat1.setOnClickListener(v -> {
            if (!isBooked) {
                binding.seat2.setBackground(AppCompatResources.getDrawable(this, R.drawable.selected));
                isBooked = true;
            } else {
                binding.seat2.setBackground(AppCompatResources.getDrawable(this, R.drawable.available));
                isBooked = false;
            }
        });
        binding.seat2.setOnClickListener(v -> {
            if (!isBooked) {
                binding.seat2.setBackground(AppCompatResources.getDrawable(this, R.drawable.selected));
                isBooked = true;
            } else {
                binding.seat2.setBackground(AppCompatResources.getDrawable(this, R.drawable.available));
                isBooked = false;
            }
        });
        binding.seat3.setOnClickListener(v -> {
            if (!isBooked) {
                binding.seat3.setBackground(AppCompatResources.getDrawable(this, R.drawable.selected));
                isBooked = true;
            } else {
                binding.seat3.setBackground(AppCompatResources.getDrawable(this, R.drawable.available));
                isBooked = false;
            }
        });
        binding.seat4.setOnClickListener(v -> {
            if (!isBooked) {
                binding.seat4.setBackground(AppCompatResources.getDrawable(this, R.drawable.selected));
                isBooked = true;
            } else {
                binding.seat4.setBackground(AppCompatResources.getDrawable(this, R.drawable.available));
                isBooked = false;
            }
        });
        binding.seat5.setOnClickListener(this);
        binding.seat6.setOnClickListener(this);
        binding.seat7.setOnClickListener(this);
        binding.seat8.setOnClickListener(this);
        binding.seat9.setOnClickListener(this);
        binding.seat10.setOnClickListener(this);
//        binding.seat11.setOnClickListener(this);
//        binding.seat12.setOnClickListener(this);
        binding.seat13.setOnClickListener(this);
        binding.seat14.setOnClickListener(this);
        binding.seat15.setOnClickListener(this);
        binding.seat16.setOnClickListener(this);
        binding.seat17.setOnClickListener(this);
        binding.seat18.setOnClickListener(this);
        binding.seat19.setOnClickListener(this);
        binding.seat20.setOnClickListener(this);
        binding.seat21.setOnClickListener(this);
        binding.seat22.setOnClickListener(this);
        binding.seat23.setOnClickListener(this);
        binding.seat24.setOnClickListener(this);


        binding.buttonSubmit.setOnClickListener(v-> {
            Intent intent = new Intent(pilihkursi.this, HomepageActivity.class);
            startActivity(intent);
            Toast.makeText(this,"Booking Succeed",Toast.LENGTH_SHORT).show();
        });

    }

    @Override
    public void onClick(View v) {
        Button b = (Button) v;
        if (!isBooked) {
            b.setBackground(AppCompatResources.getDrawable(this, R.drawable.selected));
            isBooked = true;
        } else {
            b.setBackground(AppCompatResources.getDrawable(this, R.drawable.available));
            isBooked = false;
        }
    }
}