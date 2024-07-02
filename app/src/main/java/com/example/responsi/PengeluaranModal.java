package com.example.responsi;

public class PengeluaranModal {
    // variables for our coursename,
    // description, tracks and duration, id.
    private String tanggal;
    private String keperluan;
    private String nilai;
    private String keterangan;
    private int id;

    // creating getter and setter methods
    public String getTanggal() {return tanggal; }

    public void setTanggal(String tanggal)
    {
        this.tanggal = tanggal;
    }


    public String getKeperluan()
    {
        return keperluan;
    }

    public void setKeperluan(String keperluan)
    {
        this.keperluan = keperluan;
    }


    public String getNilai() { return nilai; }

    public void setNilai(String nilai)
    {
        this.nilai= nilai;
    }


    public String getKeterangan()
    {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {this.keterangan = keterangan;}


    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    // constructor
    public PengeluaranModal(String tanggal,
                       String keperluan,
                       String nilai,
                       String keterangan)
    {
        this.tanggal = tanggal;
        this.keperluan = keperluan;
        this.nilai = nilai;
        this.keterangan = keterangan;
    }
}