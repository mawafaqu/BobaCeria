package com.akbmawa.bobaceria;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class BerhasilPesan extends AppCompatActivity {


    TextView btn_pesanlagi, txtnama, txtpesanan1, txtpesanan2, txtpesanan3, txtqty1, txtqty2, txtqty3;


    //untuk pakai databse
    DatabaseReference reference;

    //simpan string nama
    String KEY_NAMA = "keynama";
    String key_nama = "";
    String key_nama_baru ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berhasil_pesan);

        //ambil nama (data) dari local storage
        getUsernamelocal();


        //memanggil variabel
        btn_pesanlagi = findViewById(R.id.btn_pesanlagi);

        txtpesanan1 = findViewById(R.id.txtpesanan1);
        txtpesanan2 = findViewById(R.id.txtpesanan2);
        txtpesanan3 = findViewById(R.id.txtpesanan3);
        txtqty1 = findViewById(R.id.txtqty1);
        txtqty2 = findViewById(R.id.txtqty2);
        txtqty3 = findViewById(R.id.txtqty3);
        txtnama = findViewById(R.id.txtnama);


        //panggil database (dalam folder Customer)
        reference = FirebaseDatabase.getInstance().getReference()
                .child("Customer").child(key_nama_baru);



        //ambil data dari firebase dan masukan ke TextView masing-masing
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                txtnama.setText(dataSnapshot.child("nama").getValue().toString());
                txtpesanan1.setText(dataSnapshot.child("pesanan1").getValue().toString());
                txtpesanan2.setText(dataSnapshot.child("pesanan2").getValue().toString());
                txtpesanan3.setText(dataSnapshot.child("pesanan3").getValue().toString());
                txtqty1.setText(dataSnapshot.child("qty1").getValue().toString());
                txtqty2.setText(dataSnapshot.child("qty2").getValue().toString());
                txtqty3.setText(dataSnapshot.child("qty3").getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        //pindah kelas
        btn_pesanlagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pesanlagi = new Intent(BerhasilPesan.this, Home.class);
                startActivity(pesanlagi);
            }
        });
    }


    //ambil nama dari local storage
    public void getUsernamelocal() {
        SharedPreferences sharedPreferences = getSharedPreferences(KEY_NAMA, MODE_PRIVATE);
       key_nama_baru = sharedPreferences.getString(key_nama, "");

    }
}