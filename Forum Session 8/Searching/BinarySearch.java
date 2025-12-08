import java.util.Arrays;

public class BinarySearch {
   public static void main(String[] args) {
      int[] data = { 4, 9, 15, 21, 28 };
      int cari = 15;

      int posisi = Arrays.binarySearch(data, cari);

      if (posisi >= 0) {
         System.out.println("Angka " + cari + " ada di indeks " + posisi);
      } else {
         System.out.println("Angka " + cari + " tidak ditemukan.");
      }
   }
}