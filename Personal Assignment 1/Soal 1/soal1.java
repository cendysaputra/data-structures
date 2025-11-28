/* Program Menambahkan dan Menampilkan Inventaris */

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

   public void tampilInfo() {
      System.out.println("Nama Barang: " + nama);
      System.out.println("Jumlah Stock " + jumlahStok);
      System.out.println("Harga: Rp " + harga);
      System.out.println("_______________________\n");
   }
}

public class soal1 {
   public static void main(String[] args) {
      Barang[] inventaris = new Barang[10];

      inventaris[0] = new Barang("Pensil", 50, 200);
      inventaris[1] = new Barang("Buku", 30, 15000);
      inventaris[2] = new Barang("Penghapus", 20, 500);

      System.out.println("\nDAFTAR INVENTARIS TOKO\n");

      for (int i = 0; i < inventaris.length; i++) {
         if (inventaris[i] != null) {
            inventaris[i].tampilInfo();
         }
      }
   }
}