package com.example.finalproject4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class DaftaBuss extends AppCompatActivity {

    RecyclerView bussRecylerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dafta_buss);
        bussRecylerView = (RecyclerView) findViewById(R.id.buss_recview);
        List<DaftarBussModel>  bussList = new ArrayList<DaftarBussModel>();

        bussList.add(new DaftarBussModel("Agra", "https://ik.imagekit.io/tvlk/image/imageResource/2019/10/07/1570442621863-3ade6e9c68b9c6a43d8f42a1879ed314.jpeg?tr=q-75"));
        bussList.add(new DaftarBussModel(" Blue Star", "https://www.busbeetrans.co.id/assets/images/armada/bus_pariwisata_blue_star_4457c.jpg"));
        bussList.add(new DaftarBussModel("Citra Dewi", "https://destination-travel.net/wp-content/uploads/2018/01/po-citra-dewi-e1516712297127.jpg"));
        bussList.add(new DaftarBussModel("Harapan Jaya", "https://th.bing.com/th/id/OIP.bBY3sLz2HlP1iFwSoecrKAHaEK?pid=ImgDet&rs=1"));
        bussList.add(new DaftarBussModel("Dewi Sri", "https://th.bing.com/th/id/OIP.e7S-ek4hbvaj30aTiW5SVQHaEB?w=289&h=180&c=7&r=0&o=5&dpr=1.5&pid=1.7"));
        bussList.add(new DaftarBussModel("Perdana Jaya", "https://th.bing.com/th/id/OIP.SCOS8IJVagc2NiAJLIYNiAAAAA?w=205&h=180&c=7&r=0&o=5&dpr=1.5&pid=1.7"));

        DaftarBussAdapter daftarBussAdapter = new DaftarBussAdapter(getApplicationContext(),bussList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        bussRecylerView.setLayoutManager(layoutManager);
        bussRecylerView.setAdapter(daftarBussAdapter);
    }
}