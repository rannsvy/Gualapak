package view;

import model.Pesanan;
import model.Produk;
import model.User;

import java.util.List;

public class UserView {

    // Menampilkan menu utama untuk pengguna
    public void tampilkanMenuUser() {
        System.out.println("|------------------------------------------|");
        System.out.println("|               Menu User                  |");
        System.out.println("|------------------------------------------|");
        System.out.println("1. Lihat Produk & Tambah ke Keranjang");
        System.out.println("2. Lihat Keranjang");
        System.out.println("3. Buat Pesanan");
        System.out.println("4. Lihat Pesanan");
        System.out.println("5. Bayar Pesanan");
        System.out.println("6. Tambahkan Alamat");
        System.out.println("7. Logout");
        System.out.print("Pilih: ");
    }

    // Menampilkan daftar keranjang pengguna
    public void tampilkanKeranjang(User user) {
        List<Produk> keranjang = user.getKeranjang();
        if (keranjang.isEmpty()) {
            System.out.println("Keranjang Anda kosong.");
        } else {
            System.out.println("|--------------------------|");
            System.out.println("|     Daftar Keranjang     |");
            System.out.println("|--------------------------|");
            for (Produk produk : keranjang) {
                produk.tampilkanProduk();
            }
            System.out.println("|--------------------------|");
        }
    }

    // Menampilkan daftar pesanan pengguna
    public void tampilkanPesanan(List<Pesanan> pesananList) {
        if (pesananList.isEmpty()) {
            System.out.println("Tidak ada pesanan untuk ditampilkan.");
        } else {
            System.out.println("|--------------------------|");
            System.out.println("|     Daftar Pesanan       |");
            System.out.println("|--------------------------|");
            for (Pesanan pesanan : pesananList) {
                pesanan.tampilkanPesanan();
            }
            System.out.println("|--------------------------|");
        }
    }

    // Menampilkan daftar produk yang tersedia
    public void tampilkanProduk(List<Produk> produkList) {
        if (produkList.isEmpty()) {
            System.out.println("Tidak ada produk yang tersedia.");
        } else {
            System.out.println("|---------------------------------------------|");
            System.out.println("|               Daftar Produk                 |");
            System.out.println("|---------------------------------------------|");
            for (Produk produk : produkList) {
                produk.tampilkanProduk();
            }
            System.out.println("|---------------------------------------------|");
        }
    }

    // Menampilkan konfirmasi setelah pembayaran berhasil
    public void tampilkanKonfirmasiBayar(Pesanan pesanan) {
        System.out.println("Pesanan berhasil dibayar: " + pesanan.getNamaToko());
    }

    // Menampilkan alamat pengguna saat ini
    public void tampilkanAlamat(User user) {
        System.out.println("Alamat saat ini: " + user.getAlamat());
    }

    // Menampilkan konfirmasi setelah alamat diperbarui
    public void tampilkanKonfirmasiAlamat(String alamatBaru) {
        System.out.println("Alamat berhasil diperbarui menjadi: " + alamatBaru);
    }
}
