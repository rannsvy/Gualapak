package view;

import controller.ProdukController;
import controller.UserController;
import model.Admin;
import model.Produk;
import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Produk> produkList = new ArrayList<>();
        Admin admin = new Admin("adminToko", "admin123");

        UserController userController = new UserController(new UserView());
        ProdukController produkController = new ProdukController(new AdminView());

        while (true) {
            tampilkanMenuUtama();
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Bersihkan buffer

            if (pilihan == 3) {
                System.out.println("Terima kasih telah menggunakan Gualapak!");
                break;
            }

            switch (pilihan) {
                case 1 -> loginUser(userController, produkList, scanner);
                case 2 -> loginAdmin(produkController, produkList, admin, scanner);
                default -> System.out.println("Pilihan tidak valid.");
            }
        }
    }

    public static void tampilkanMenuUtama() {
        System.out.println("|------------------------------------------|");
        System.out.println("|       SELAMAT DATANG DI GUALAPAK        |");
        System.out.println("|------------------------------------------|");
        System.out.println("1. Login sebagai User");
        System.out.println("2. Login sebagai Admin");
        System.out.println("3. Keluar");
        System.out.print("Pilih: ");
    }

    private static void loginUser(UserController userController, List<Produk> produkList, Scanner scanner) {
        System.out.print("Nama Pengguna: ");
        String namaToko = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        User currentUser = new User(namaToko, password);
        System.out.println("Hai, " + namaToko + "! Gualapak siap membantu Anda!");
        userController.menuUser(currentUser, produkList, scanner);
    }

    private static void loginAdmin(ProdukController produkController, List<Produk> produkList, Admin admin, Scanner scanner) {
        System.out.print("Nama Toko: ");
        String adminNamaToko = scanner.nextLine();
        System.out.print("Password Admin: ");
        String adminPassword = scanner.nextLine();

        if (adminNamaToko.equals(admin.getNamaToko()) && adminPassword.equals(admin.getPassword())) {
            System.out.println("Hai, " + adminNamaToko + "! Gualapak siap membantu Anda!");
            menuAdmin(produkController, produkList, scanner);
        } else {
            System.out.println("Nama Toko atau Password salah.");
        }
    }

    private static void menuAdmin(ProdukController produkController, List<Produk> produkList, Scanner scanner) {
        while (true) {
            tampilkanMenuAdmin();
            int menu = scanner.nextInt();
            scanner.nextLine(); // Bersihkan buffer

            switch (menu) {
                case 1 -> produkController.tambahProduk(produkList, scanner);
                case 2 -> produkController.ubahProduk(produkList, scanner);
                case 3 -> produkController.hapusProduk(produkList, scanner);
                case 4 -> new AdminView().tampilkanProduk(produkList);
                case 5 -> System.out.println("Fitur lihat pesanan belum tersedia untuk admin."); // Pesanan untuk admin dapat diimplementasikan di controller terkait.
                case 6 -> {
                    System.out.println("Logout berhasil.");
                    return; // Kembali ke menu utama
                }
                default -> System.out.println("Pilihan tidak valid.");
            }
        }
    }

    public static void tampilkanMenuAdmin() {
        System.out.println("|------------------------------------------|");
        System.out.println("|              Menu Admin                  |");
        System.out.println("|------------------------------------------|");
        System.out.println("1. Tambah Produk");
        System.out.println("2. Ubah Produk");
        System.out.println("3. Hapus Produk");
        System.out.println("4. Lihat Produk");
        System.out.println("5. Lihat Pesanan");
        System.out.println("6. Logout");
        System.out.print("Pilih: ");
    }
}
