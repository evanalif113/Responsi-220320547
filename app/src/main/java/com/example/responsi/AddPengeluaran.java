package com.example.responsi;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddPengeluaran extends AppCompatActivity {

    // creating variables for our edittext, button and dbhandler
    private EditText
            TanggalEdt,
            KeperluanEdt,
            NilaiEdt,
            KeteranganEdt;
    private Button addPengeluaranBtn;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pengeluaran);

        // initializing all our variables.
        TanggalEdt = findViewById(R.id.idEdtTanggal);
        KeperluanEdt = findViewById(R.id.idEdtKeperluan);
        NilaiEdt = findViewById(R.id.idEdtNilai);
        KeteranganEdt = findViewById(R.id.idEdtKeterangan);
        addPengeluaranBtn = findViewById(R.id.idBtnAddPengeluaran);

        // creating a new dbhandler class
        // and passing our context to it.
        dbHandler = new DBHandler(AddPengeluaran.this);

        // below line is to add on click listener for our add course button.
        addPengeluaranBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // below line is to get data from all edit text fields.
                String tanggal = TanggalEdt.getText().toString();
                String keperluan = KeperluanEdt.getText().toString();
                String nilai = NilaiEdt.getText().toString();
                String keterangan = KeteranganEdt.getText().toString();

                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.
                dbHandler.addNewPengeluaran(tanggal, keperluan, nilai, keterangan);

                // after adding the data we are displaying a toast message.
                Toast.makeText(AddPengeluaran.this, "Pengeluaran ditambahkan.", Toast.LENGTH_SHORT).show();
                TanggalEdt.setText("");
                KeperluanEdt.setText("");
                NilaiEdt.setText("");
                KeteranganEdt.setText("");
            }
        });
    }
}
