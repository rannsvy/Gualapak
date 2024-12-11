package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
    private String namaToko;
    private String password;
    private String alamat;
    private List<Pesanan> pesananList;
    private List<Produk> keranjang;

    public User(String namaToko, String password) {
        this.namaToko = namaToko;
        this.password = password;
        this.pesananList = new ArrayList<>();
        this.keranjang = new ArrayList<>();
    }

    // Getters dan Setters
    public String getNamaToko() {
        return namaToko;
    }

    public void setNamaToko(String namaToko) {
        this.namaToko = namaToko;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public List<Pesanan> getPesananList() {
        return pesananList;
    }

    public List<Produk> getKeranjang() {
        return keranjang;
    }

    // Tambahkan produk ke keranjang
    public void tambahKeranjang(Produk produk, int jumlah) {
        if (produk.getStok() >= jumlah) {
            produk.kurangiStok(jumlah); // Kurangi stok di produk
            keranjang.add(produk);     // Tambahkan ke keranjang
            System.out.println("Produk berhasil ditambahkan ke keranjang.");
        } else {
            System.out.println("Stok tidak cukup.");
        }
    }

    // Kosongkan keranjang
    public void clearKeranjang() {
        keranjang.clear();
    }

    // Lihat isi keranjang
    public void lihatKeranjang() {
        System.out.println("Keranjang Anda:");
        if (keranjang.isEmpty()) {
            System.out.println("Keranjang kosong.");
        } else {
            for (Produk produk : keranjang) {
                System.out.println("- " + produk.getNamaBarang() + " (Stok: " + produk.getStok() + ")");
            }
        }
    }

    // Buat pesanan dari keranjang
    public void buatPesanan(Scanner scanner) {
        if (keranjang.isEmpty()) {
            System.out.println("Keranjang kosong. Tidak ada pesanan yang dapat dibuat.");
            return;
        }

        Pesanan pesanan = new Pesanan(namaToko);
        for (Produk produk : keranjang) {
            System.out.print("Masukkan jumlah untuk " + produk.getNamaBarang() + ": ");
            int jumlah = scanner.nextInt();
            if (jumlah <= produk.getStok()) {
                pesanan.tambahProduk(produk, jumlah);
                produk.kurangiStok(jumlah);
            } else {
                System.out.println("Jumlah melebihi stok yang tersedia.");
            }
        }

        System.out.println("Pilih ekspedisi pengiriman:");
        System.out.println("1. J&T");
        System.out.println("2. SiCepat");
        System.out.println("3. Guasend");
        System.out.print("Masukkan pilihan (1/2/3): ");
        int pilihanEkspedisi = scanner.nextInt();
        scanner.nextLine(); // Bersihkan buffer

        String ekspedisi = switch (pilihanEkspedisi) {
            case 1 -> "J&T";
            case 2 -> "SiCepat";
            case 3 -> "Guasend";
            default -> "J&T";
        };
        pesanan.setEkspedisi(ekspedisi);

        pesananList.add(pesanan);
        clearKeranjang();
        System.out.println("Pesanan berhasil dibuat dengan ekspedisi: " + ekspedisi);
    }

    // Bayar pesanan
    public void bayarPesanan(Scanner scanner) {
        if (pesananList.isEmpty()) {
            System.out.println("Tidak ada pesanan untuk dibayar.");
            return;
        }

        System.out.println("Daftar Pesanan:");
        for (int i = 0; i < pesananList.size(); i++) {
            System.out.println((i + 1) + ". Pesanan dari toko: " + pesananList.get(i).getNamaToko());
        }

        System.out.print("Pilih nomor pesanan untuk dibayar: ");
        int pilihan = scanner.nextInt();
        if (pilihan > 0 && pilihan <= pesananList.size()) {
            Pesanan pesanan = pesananList.get(pilihan - 1);
            System.out.println("Pilih metode pembayaran:");
            System.out.println("1. Online");
            System.out.println("2. Offline");
            System.out.print("Masukkan pilihan: ");
            int metodePembayaran = scanner.nextInt();

            if (metodePembayaran == 1) {
                pesanan.setPembayaran("Online");
                pesanan.setStatus("Telah Dibayar");
                System.out.println("Pesanan berhasil dibayar secara online.");
            } else if (metodePembayaran == 2) {
                pesanan.setPembayaran("Offline");
                pesanan.setStatus("Menunggu Pembayaran di Tempat");
                System.out.println("Pesanan berhasil dibayar secara offline.");
            } else {
                System.out.println("Metode pembayaran tidak valid.");
            }
        } else {
            System.out.println("Pilihan tidak valid.");
        }
    }
}
