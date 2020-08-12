package com.akbmawa.bobaceria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {

    //deklarasi variabel button
  Button button_pesan, button_harga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        //inisialisasi button pesan & harga
        button_pesan = findViewById(R.id.button_pesan);
        button_harga = findViewById(R.id.button_harga);


        //pindah ke Pesan
        button_pesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pesan = new Intent(Home.this, Pesan.class);
                startActivity(pesan);
            }
        });

        //pindah ke daftar harga
        button_harga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent harga = new Intent(Home.this, daftar_harga.class);
                startActivity(harga);
            }
        });
    }
}