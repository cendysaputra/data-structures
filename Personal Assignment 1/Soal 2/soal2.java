// Program Mengupdate Stok dan Mencari Barang dari Soal 1
// 1. Nama: Pensil, Jumlah Stok: 50, Harga: 200
// 2. Nama: Buku, Jumlah Stok: 30, Harga: 15000
// 3. Nama: Penghapus, Jumlah Stok: 20, Harga: 500

import java.util.Scanner;

class Barang {
   private String nama;
   private int jumlahStok;
   private double harga;

   public Barang(String nama, int jumlahStok, double harga) {
      this.nama = nama;
      this.jumlahStok = jumlahStok;
      this.harga = harga;
   }

   public String getNama() {
      return nama;
   }

   public int getJumlahStock() {
      return jumlahStok;
   }

   public double getHarga() {
      return harga;
   }

   public void setJumlahStok(int jumlahStok) {
      this.jumlahStok = jumlahStok;
   }

   public void tampilInfo() {
      System.out.println("Nama: " + nama + ", Jumlah Stok: " + jumlahStok + ", Harga: " + (int) harga);
   }
}

public class soal2 {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      Barang[] inventaris = new Barang[10];

      inventaris[0] = new Barang("Pensil", 50, 200);
      inventaris[1] = new Barang("Buku", 30, 15000);
      inventaris[2] = new Barang("Penghapus", 20, 500);

      System.out.print("Masukkan nama barang yang ingin diupdate: ");
      String namaUpdate = input.nextLine();

      System.out.print("Masukkan jumlah stok baru: ");
      int stokBaru = input.nextInt();
      input.nextLine();

      updateStok(inventaris, namaUpdate, stokBaru);

      System.out.println("\nInventaris setelah diupdate:");
      tampilkanInventaris(inventaris);

      System.out.print("\nMasukkan nama barang yang dicari: ");
      String namaCari = input.nextLine();

      System.out.println("\nHasil pencarian:");
      cariBarang(inventaris, namaCari);

      input.close();
   }

   public static void updateStok(Barang[] inventaris, String namaBarang, int stokBaru) {
      boolean ditemukan = false;
      for (int i = 0; i < inventaris.length; i++) {
         if (inventaris[i] != null && inventaris[i].getNama().equalsIgnoreCase(namaBarang)) {
            inventaris[i].setJumlahStok(stokBaru);
            ditemukan = true;
            break;
         }
      }
      if (!ditemukan) {
         System.out.println("Barang tidak ditemukan");
      }
   }

   public static void cariBarang(Barang[] inventaris, String namaBarang) {
      boolean ditemukan = false;
      for (int i = 0; i < inventaris.length; i++) {
         if (inventaris[i] != null && inventaris[i].getNama().equalsIgnoreCase(namaBarang)) {
            inventaris[i].tampilInfo();
            ditemukan = true;
            break;
         }
      }
      if (!ditemukan) {
         System.out.println("Barang tidak ditemukan");
      }
   }

   public static void tampilkanInventaris(Barang[] inventaris) {
      int nomor = 1;
      for (int i = 0; i < inventaris.length; i++) {
         if (inventaris[i] != null) {
            System.out.print(nomor + ". ");
            inventaris[i].tampilInfo();
            nomor++;
         }
      }
   }
}