package view;

import model.Produk;

import java.util.List;

public class ProdukView {
    public void tampilkanProduk(List<Produk> produkList) {
        System.out.println("|---------------------------------------------|");
        System.out.println("|               Daftar Produk                 |");
        System.out.println("|---------------------------------------------|");
        for (Produk produk : produkList) {
            produk.tampilkanProduk();
        }
        System.out.println("|---------------------------------------------|");
    }
}
