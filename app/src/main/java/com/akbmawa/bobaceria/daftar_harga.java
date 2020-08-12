package com.akbmawa.bobaceria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class daftar_harga extends AppCompatActivity {
    TextView btn_pesanskrg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_harga);

        btn_pesanskrg = findViewById(R.id.btn_pesanskrg);

        btn_pesanskrg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pesanskrg = new Intent(daftar_harga.this, Pesan.class);
                startActivity(pesanskrg);
            }
        });
    }
}