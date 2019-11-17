package com.example.digitalconstruction.Data;

import android.os.Parcel;
import android.os.Parcelable;

public class Items implements Parcelable {
    private int img;
    private String nama, jam, kota, harga,unit;

    public Items(){

    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public Items(int img, String nama, String jam, String kota, String harga,String unit) {
        this.img = img;
        this.nama = nama;
        this.jam = jam;
        this.kota = kota;
        this.harga = harga;
        this.unit = unit;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.img);
        dest.writeString(this.nama);
        dest.writeString(this.jam);
        dest.writeString(this.kota);
        dest.writeString(this.harga);
        dest.writeString(this.unit);
    }

    protected Items(Parcel in) {
        this.img = in.readInt();
        this.nama = in.readString();
        this.jam = in.readString();
        this.kota = in.readString();
        this.harga = in.readString();
        this.unit = in.readString();
    }

    public static final Creator<Items> CREATOR = new Creator<Items>() {
        @Override
        public Items createFromParcel(Parcel source) {
            return new Items(source);
        }

        @Override
        public Items[] newArray(int size) {
            return new Items[size];
        }
    };
}
