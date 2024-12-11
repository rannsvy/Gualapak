package view;

import model.Pesanan;
import model.Produk;

public class PesananView {
    public void tampilkanPesanan(Pesanan pesanan) {
        double total = 0;
        System.out.println("|---------------------------------------------|");
        System.out.println("|               Detail Pemesanan              |");
        System.out.println("|---------------------------------------------|");
        System.out.println("| Nama Toko   | " + pesanan.getNamaToko() + "                             |");
        System.out.println("|---------------------------------------------|");
        System.out.println("| Produk         | Jumlah  | Harga       | Subtotal    |");
        System.out.println("|---------------------------------------------|");

        for (int i = 0; i < pesanan.getProdukList().size(); i++) {
            Produk produk = pesanan.getProdukList().get(i);
            int jumlah = pesanan.getJumlahList().get(i);
            double subtotal = produk.getHarga() * jumlah;
            total += subtotal;
            System.out.println(String.format("| %-15s | %-7d | %-10.2f | %-10.2f |", produk.getNamaBarang(), jumlah, produk.getHarga(), subtotal));
        }

        // Diskon
        System.out.println("|---------------------------------------------|");
        if (pesanan.getDiskon() > 0) {
            System.out.println(String.format("| Diskon        | %-7.2f |", pesanan.getDiskon()));
            total -= pesanan.getDiskon();
        }

        System.out.println("|---------------------------------------------|");
        System.out.println(String.format("| Total Pembayaran | %-10.2f |", total));
        System.out.println("|---------------------------------------------|");

        System.out.println("Status: " + pesanan.getStatus());
        if (pesanan.getResi() != null) {
            System.out.println("Resi Pengiriman: " + pesanan.getResi());
        }
    }
}
