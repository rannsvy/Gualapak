package model;

public class Produk {
    private String id;
    private String namaBarang;
    private int stok;
    private double harga;
    private String variasi;
    private String kategori;

    public Produk(String id, String namaBarang, int stok, double harga, String variasi, String kategori) {
        this.id = id;
        this.namaBarang = namaBarang;
        this.stok = stok;
        this.harga = harga;
        this.variasi = variasi;
        this.kategori = kategori;
    }

    public void tampilkanProduk() {
        System.out.println(String.format("| %-15s | %-20s | %-15s | %-10.2f | %-10d |", id, namaBarang, kategori, harga, stok));
    }

    public void kurangiStok(int jumlah) {
        if (stok >= jumlah) {
            stok -= jumlah;
        } else {
            System.out.println("Stok tidak cukup.");
        }
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public String getVariasi() {
        return variasi;
    }

    public void setVariasi(String variasi) {
        this.variasi = variasi;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }
}
