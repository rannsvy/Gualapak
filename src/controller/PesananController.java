package controller;

import model.Pesanan;
import model.Produk;

public class PesananController {
    private Pesanan pesanan;

    public PesananController(Pesanan pesanan) {
        this.pesanan = pesanan;
    }

    public void ubahStatus(String status) {
        pesanan.setStatus(status);
    }

    public void setResi(String resi) {
        pesanan.setResi(resi);
    }

    public void setAlamat(String alamat) {
        pesanan.setAlamat(alamat);
    }

    public void setPembayaran(String pembayaran) {
        pesanan.setPembayaran(pembayaran);
    }

    public void tambahProduk(Produk produk, int jumlah) {
        pesanan.tambahProduk(produk, jumlah);
    }
}
