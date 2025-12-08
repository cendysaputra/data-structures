import java.util.Arrays;

public class Deletion {
   public static void main(String[] args) {
      int[] angka = { 8, 16, 24, 32, 48, 56, 64 };
      int pos = 3;

      int[] hasil = new int[angka.length - 1];
      for (int i = 0; i < pos; i++) {
         hasil[i] = angka[i];
      }

      for (int i = pos; i < angka.length - 1; i++) {
         hasil[i] = angka[i + 1];
      }

      System.out.println("Setelah dihapus: " + Arrays.toString(hasil));
   }
}