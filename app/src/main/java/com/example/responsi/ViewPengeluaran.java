package com.example.responsi;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.responsi.DBHandler;
import com.example.responsi.PengeluaranModal;
import com.example.responsi.PengeluaranRVAdapter;

import java.util.ArrayList;

public class ViewPengeluaran extends AppCompatActivity {

    // creating variables for our array list,
    // dbhandler, adapter and recycler view.
    private ArrayList<PengeluaranModal> pengeluaranModalArrayList;
    private DBHandler dbHandler;
    private PengeluaranRVAdapter pengeluaranRVAdapter;
    private RecyclerView pengeluaranRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pengeluaran);

        // initializing our all variables.
        pengeluaranModalArrayList = new ArrayList<>();
        dbHandler = new DBHandler(ViewPengeluaran.this);

        // getting our course array
        // list from db handler class.
        pengeluaranModalArrayList = dbHandler.readPengeluaran();

        // on below line passing our array list to our adapter class.
        //pengeluaranRV = new PengeluaranRVAdapter(pengeluaranModalArrayList, ViewPengeluaran.this);
        //PengeluaranRV = findViewById(R.);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewPengeluaran.this, RecyclerView.VERTICAL, false);
        //coursesRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        //coursesRV.setAdapter(pengeluaranRVAdapter);
    }
}
