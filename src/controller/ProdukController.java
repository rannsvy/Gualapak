package controller;

import model.Produk;
import view.AdminView;

import java.util.List;
import java.util.Scanner;

public class ProdukController {
    private AdminView adminView;

    public ProdukController(AdminView adminView) {
        this.adminView = adminView;
    }

    public void tambahProduk(List<Produk> produkList, Scanner scanner) {
        System.out.print("Nama Barang: ");
        String namaBarang = scanner.nextLine();
        System.out.print("Stok: ");
        int stok = scanner.nextInt();
        System.out.print("Harga: ");
        double harga = scanner.nextDouble();
        scanner.nextLine(); // Bersihkan buffer
        System.out.print("Variasi: ");
        String variasi = scanner.nextLine();
        System.out.print("Kategori: ");
        String kategori = scanner.nextLine();

        Produk produk = new Produk(generateId(kategori), namaBarang, stok, harga, variasi, kategori);
        produkList.add(produk);
        adminView.produkBerhasilDitambahkan(namaBarang);
    }

    public void ubahProduk(List<Produk> produkList, Scanner scanner) {
        System.out.print("Masukkan kode produk untuk diubah: ");
        String kode = scanner.nextLine();
        Produk produkToUbah = produkList.stream()
                .filter(p -> p.getId().equals(kode))
                .findFirst()
                .orElse(null);

        if (produkToUbah != null) {
            System.out.print("Nama Barang: ");
            String newNamaBarang = scanner.nextLine();
            System.out.print("Stok: ");
            int newStok = scanner.nextInt();
            System.out.print("Harga: ");
            double newHarga = scanner.nextDouble();
            scanner.nextLine(); // Bersihkan buffer
            System.out.print("Variasi: ");
            String newVariasi = scanner.nextLine();
            System.out.print("Kategori: ");
            String newKategori = scanner.nextLine();

            produkToUbah.setNamaBarang(newNamaBarang);
            produkToUbah.setStok(newStok);
            produkToUbah.setHarga(newHarga);
            produkToUbah.setVariasi(newVariasi);
            produkToUbah.setKategori(newKategori);

            adminView.produkBerhasilDiubah(newNamaBarang);
        } else {
            System.out.println("Produk tidak ditemukan.");
        }
    }

    public void hapusProduk(List<Produk> produkList, Scanner scanner) {
        System.out.print("Masukkan kode produk untuk dihapus: ");
        String kode = scanner.nextLine();
        Produk produkToHapus = produkList.stream()
                .filter(p -> p.getId().equals(kode))
                .findFirst()
                .orElse(null);

        if (produkToHapus != null) {
            produkList.remove(produkToHapus);
            adminView.produkBerhasilDihapus(produkToHapus.getNamaBarang());
        } else {
            System.out.println("Produk tidak ditemukan.");
        }
    }

    private String generateId(String kategori) {
        return switch (kategori) {
            case "Elektronik" -> "01";
            case "Pakaian" -> "02";
            case "Peralatan Rumah Tangga" -> "03";
            case "Lainnya" -> "04";
            default -> "00";
        } + (int) (Math.random() * 10000);
    }
}
