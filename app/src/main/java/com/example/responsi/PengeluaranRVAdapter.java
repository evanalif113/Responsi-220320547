package com.example.responsi;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PengeluaranRVAdapter extends RecyclerView.Adapter<PengeluaranRVAdapter.ViewHolder> {

    // variable for our array list and context
    private ArrayList<PengeluaranModal> pengeluaranModalArrayList;
    private Context context;

    // constructor
    public PengeluaranRVAdapter(ArrayList<PengeluaranModal> pengeluaranModalArrayList, Context context) {
        this.pengeluaranModalArrayList = pengeluaranModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pengeluaran_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // on below line we are setting data
        // to our views of recycler view item.
        PengeluaranModal modal = pengeluaranModalArrayList.get(position);
        holder.tanggalTV.setText(modal.getTanggal());
        holder.keperluanTV.setText(modal.getKeperluan());
        holder.nilaiTV.setText(modal.getNilai());
        holder.keteranganTV.setText(modal.getKeterangan());

        // below line is to add on click listener for our recycler view item.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // on below line we are calling an intent.
                Intent i = new Intent(context, UpdatePengeluaranActivity.class);

                // below we are passing all our values.
                i.putExtra("name", modal.getTanggal());
                i.putExtra("description", modal.getKeperluan());
                i.putExtra("duration", modal.getNilai());
                i.putExtra("tracks", modal.getKeterangan());

                // starting our activity.
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        // returning the size of our array list
        return pengeluaranModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating variables for our text views.
        private TextView tanggalTV, keperluanTV, nilaiTV, keteranganTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            tanggalTV = itemView.findViewById(R.id.idTanggal);
            keperluanTV= itemView.findViewById(R.id.idKeperluan);
            nilaiTV = itemView.findViewById(R.id.idNilai);
            keteranganTV = itemView.findViewById(R.id.idKeterangan);
        }
    }
}
