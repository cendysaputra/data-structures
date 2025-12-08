import java.util.Arrays;

public class Insertion {
   public static void main(String[] args) {
      int[] angka = { 15, 25, 35, 45, 55 };
      int nilaiBaru = 30;
      int posisi = 2;

      int[] arrayBaru = new int[angka.length + 1];

      for (int i = 0; i < posisi; i++) {
         arrayBaru[i] = angka[i];
      }

      arrayBaru[posisi] = nilaiBaru;

      for (int i = posisi; i < angka.length; i++) {
         arrayBaru[i + 1] = angka[i];
      }

      System.out.println("Setelah disisipkan: " + Arrays.toString(arrayBaru));
   }
}