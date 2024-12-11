package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Pesanan {
    private String namaToko;
    private List<Produk> produkList = new ArrayList<>();
    private List<Integer> jumlahList = new ArrayList<>();
    private String status;
    private String alamat;
    private String pembayaran;
    private String ekspedisi;
    private String resi;
    private double diskon;

    public Pesanan(String namaToko) {
        this.namaToko = namaToko;
        this.status = "Menunggu Konfirmasi";
        this.diskon = 0.0;
    }

    // Getter dan Setter
    public String getNamaToko() {
        return namaToko;
    }

    public void setNamaToko(String namaToko) {
        this.namaToko = namaToko;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getPembayaran() {
        return pembayaran;
    }

    public void setPembayaran(String pembayaran) {
        this.pembayaran = pembayaran;
    }

    public String getEkspedisi() {
        return ekspedisi;
    }

    public void setEkspedisi(String ekspedisi) {
        this.ekspedisi = ekspedisi;
    }

    public String getResi() {
        return resi;
    }

    public void setResi(String resi) {
        this.resi = resi;
    }

    public double getDiskon() {
        return diskon;
    }

    public void setDiskon(double diskon) {
        this.diskon = diskon;
    }

    public List<Produk> getProdukList() {
        return produkList;
    }

    public List<Integer> getJumlahList() {
        return jumlahList;
    }

    public void tambahProduk(Produk produk, int jumlah) {
        produkList.add(produk);
        jumlahList.add(jumlah);
    }

    public void tampilkanPesanan() {
        double total = 0;
        System.out.println("|---------------------------------------------|");
        System.out.println("|               Detail Pemesanan              |");
        System.out.println("|---------------------------------------------|");
        System.out.println("| Nama Toko   | " + namaToko + "                             |");
        System.out.println("|---------------------------------------------|");
        System.out.println("| Produk         | Jumlah  | Harga       | Subtotal    |");
        System.out.println("|---------------------------------------------|");

        for (int i = 0; i < produkList.size(); i++) {
            Produk produk = produkList.get(i);
            int jumlah = jumlahList.get(i);
            double subtotal = produk.getHarga() * jumlah;
            total += subtotal;
            System.out.println(String.format("| %-15s | %-7d | %-10.2f | %-10.2f |", produk.getNamaBarang(), jumlah, produk.getHarga(), subtotal));
        }

        // Diskon
        System.out.println("|---------------------------------------------|");
        if (diskon > 0) {
            System.out.println(String.format("| Diskon        | %-7.2f |", diskon));
            total -= diskon;
        }

        System.out.println("|---------------------------------------------|");
        System.out.println(String.format("| Total Pembayaran | %-10.2f |", total));
        System.out.println("|---------------------------------------------|");

        System.out.println("Status: " + status);
        if (resi != null) {
            System.out.println("Resi Pengiriman: " + resi);
        }
    }

    public double hitungTotal() {
        double total = 0;
        for (int i = 0; i < produkList.size(); i++) {
            total += produkList.get(i).getHarga() * jumlahList.get(i);
        }
        return total - diskon;
    }

    public void simpanStrukKeFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("faktur.txt"))) {
            writer.write("Faktur Pemesanan\n");
            writer.write("Nama Toko: " + namaToko + "\n");
            for (int i = 0; i < produkList.size(); i++) {
                Produk produk = produkList.get(i);
                int jumlah = jumlahList.get(i);
                double subtotal = produk.getHarga() * jumlah;
                writer.write(String.format("%-15s %-7d %-10.2f %-10.2f\n", produk.getNamaBarang(), jumlah, produk.getHarga(), subtotal));
            }

            if (diskon > 0) {
                writer.write(String.format("Diskon: %-10.2f\n", diskon));
            }

            writer.write(String.format("Total: %-10.2f\n", hitungTotal()));
            writer.write("Status: " + status + "\n");
            writer.write("Resi: " + resi + "\n");

            System.out.println("Faktur disimpan ke file.");
        } catch (IOException e) {
            System.out.println("Error menyimpan struk.");
        }
    }
}
