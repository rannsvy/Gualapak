package controller;

import model.Pesanan;
import model.Produk;
import model.User;
import view.UserView;

import java.util.List;
import java.util.Scanner;

public class UserController {
    private UserView userView;

    public UserController(UserView userView) {
        this.userView = userView;
    }

    public void menuUser(User user, List<Produk> produkList, Scanner scanner) {
        while (true) {
            userView.tampilkanMenuUser(); // Delegasikan tampilan menu ke UserView
            int menu = scanner.nextInt();
            scanner.nextLine(); // Bersihkan buffer

            switch (menu) {
                case 1 -> tampilkanProduk(user, produkList, scanner);
                case 2 -> user.lihatKeranjang(); 
                case 3 -> user.buatPesanan(scanner); 
                case 4 -> userView.tampilkanPesanan(user.getPesananList()); 
                case 5 -> user.bayarPesanan(scanner); 
                case 6 -> ubahAlamat(user, scanner);
                case 7 -> {
                    return; // Logout
                }
                default -> System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private void tampilkanProduk(User user, List<Produk> produkList, Scanner scanner) {
        userView.tampilkanProduk(produkList); // View menampilkan produk
        System.out.print("Masukkan ID produk untuk ditambahkan ke keranjang (atau ketik 'exit' untuk keluar): ");
        String kodeProduk = scanner.nextLine();

        if (kodeProduk.equalsIgnoreCase("exit")) {
            return;
        }

        Produk produk = produkList.stream()
                .filter(p -> p.getId().equals(kodeProduk))
                .findFirst()
                .orElse(null);

        if (produk != null) {
            System.out.print("Masukkan jumlah: ");
            int jumlah = scanner.nextInt();
            user.tambahKeranjang(produk, jumlah); 
        } else {
            System.out.println("Produk tidak ditemukan.");
        }
    }

    private void ubahAlamat(User user, Scanner scanner) {
        System.out.print("Masukkan alamat baru: ");
        String alamatBaru = scanner.nextLine();
        user.setAlamat(alamatBaru); // Model User menangani alamat
        System.out.println("Alamat berhasil diperbarui menjadi: " + alamatBaru);
    }
}
