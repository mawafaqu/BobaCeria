package com.akbmawa.bobaceria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class separator extends AppCompatActivity {
Button lanjut;
    Animation btt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_separator);


        //ngeload animasi
        btt = AnimationUtils.loadAnimation(this, R.anim.btt);


        //panggil button
        lanjut = findViewById(R.id.lanjut);


        //run/jalankan animasi
        lanjut.startAnimation(btt);


        //pindah ke berhasil pesan
        lanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent lanjut = new Intent (separator.this, BerhasilPesan.class);
                startActivity(lanjut);
            }
        });
    }
}