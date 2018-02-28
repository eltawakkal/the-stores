package com.example.thebestone.thestores.model;

/**
 * Created by thebestone on 10/18/17.
 */

public class CustomerModel {

    private String nama;
    private String notelp;

    public CustomerModel(String nama, String notelp) {
        this.nama = nama;
        this.notelp = notelp;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNotelp() {
        return notelp;
    }

    public void setNotelp(String notelp) {
        this.notelp = notelp;
    }
}
