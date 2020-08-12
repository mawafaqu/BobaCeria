package com.akbmawa.bobaceria;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Pesan extends AppCompatActivity {
    Button btn_pesan2;
    EditText nama, pesanan1, pesanan2, pesanan3, qty1, qty2, qty3;

    //memanggil firebase
    DatabaseReference reference;

    //simpan string nama
    String KEY_NAMA = "keynama";
    String key_nama = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesan);


        nama = findViewById(R.id.nama);
        pesanan1 = findViewById(R.id.pesanan1);
        pesanan2 = findViewById(R.id.pesanan2);
        pesanan3 = findViewById(R.id.pesanan3);
        qty1 = findViewById(R.id.qty1);
        qty2 = findViewById(R.id.qty2);
        qty3 = findViewById(R.id.qty3);


        btn_pesan2 = findViewById(R.id.btn_pesan2);
        btn_pesan2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //validasi jika nama kosong
                if (nama.getText().toString().length() == 0) {
                    nama.setError("Nama diperlukan!");

                //validasi jika pesanan kosong
                    } else {
                    if (pesanan1.getText().toString().length() == 0) {
                        pesanan1.setError("Masukan pesanan!");

                        //validasi jika qty pesanan kosong
                    } else {
                        if (qty1.getText().toString().length() == 0) {
                            pesanan1.setError("Isi Jumlah Pesanan!");

                        } else {

                            //jika sudah diisi maka text tombol berubah menjadi Please Wait
                        btn_pesan2.setEnabled(false);
                        btn_pesan2.setText("PLEASE WAIT . . .");

                        // menyimpan data kepada local storage (handphone)
                        SharedPreferences sharedPreferences = getSharedPreferences(KEY_NAMA, MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString(key_nama, nama.getText().toString());
                        editor.apply();

                        // simpan kepada database
                        reference = FirebaseDatabase.getInstance().getReference()
                                .child("Customer").child(nama.getText().toString());
                        reference.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                dataSnapshot.getRef().child("nama").setValue(nama.getText().toString());
                                dataSnapshot.getRef().child("pesanan1").setValue(pesanan1.getText().toString());
                                dataSnapshot.getRef().child("pesanan2").setValue(pesanan2.getText().toString());
                                dataSnapshot.getRef().child("pesanan3").setValue(pesanan3.getText().toString());
                                dataSnapshot.getRef().child("qty1").setValue(qty1.getText().toString());
                                dataSnapshot.getRef().child("qty2").setValue(qty2.getText().toString());
                                dataSnapshot.getRef().child("qty3").setValue(qty3.getText().toString());

                            }


                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });


                        //pindah kelas
                        Intent berhasil = new Intent(Pesan.this, separator.class);
                        startActivity(berhasil);
                    }

                }
            }

            ;

        }
    });

}

};
