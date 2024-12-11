package controller;

import model.Admin;
import model.Produk;

import java.util.List;

public class AdminController {
    private Admin admin;

    public AdminController(Admin admin) {
        this.admin = admin;
    }

    public void tambahProduk(List<Produk> produkList, String namaBarang, int stok, double harga, String variasi, String kategori) {
        String id = admin.generateId(kategori);
        Produk produk = new Produk(id, namaBarang, stok, harga, variasi, kategori);
        produkList.add(produk);
    }

    public void ubahProduk(Produk produk, String namaBarang, int stok, double harga, String variasi, String kategori) {
        produk.setNamaBarang(namaBarang);
        produk.setStok(stok);
        produk.setHarga(harga);
        produk.setVariasi(variasi);
        produk.setKategori(kategori);
    }

    public void hapusProduk(List<Produk> produkList, Produk produk) {
        produkList.remove(produk);
    }
}
