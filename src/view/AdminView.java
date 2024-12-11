package view;

import model.Produk;

import java.util.List;

public class AdminView {
    public void tampilkanProduk(List<Produk> produkList) {
        System.out.println("|---------------------------------------------|");
        System.out.println("|               Daftar Produk                 |");
        System.out.println("|---------------------------------------------|");
        for (Produk produk : produkList) {
            produk.tampilkanProduk();
        }
        System.out.println("|---------------------------------------------|");
    }

    public void produkBerhasilDitambahkan(String namaBarang) {
        System.out.println("Produk \"" + namaBarang + "\" berhasil ditambahkan.");
    }

    public void produkBerhasilDihapus(String namaBarang) {
        System.out.println("Produk \"" + namaBarang + "\" berhasil dihapus.");
    }

    public void produkBerhasilDiubah(String namaBarang) {
        System.out.println("Produk \"" + namaBarang + "\" berhasil diubah.");
    }
}
