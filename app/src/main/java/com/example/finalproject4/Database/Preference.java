package com.example.finalproject4.Database;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Preference extends AppCompatActivity {
    public static final DatabaseReference DATABASE_REFERENCE = FirebaseDatabase.getInstance().getReferenceFromUrl("https://finpro4-65553-default-rtdb.firebaseio.com/");
}
