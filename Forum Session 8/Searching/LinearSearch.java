public class LinearSearch {
   public static void main(String[] args) {
      int[] nilai = { 15, 22, 8, 30, 11 };
      int cari = 30;
      boolean ketemu = false;

      for (int i = 0; i < nilai.length; i++) {
         if (nilai[i] == cari) {
            ketemu = true;
            System.out.println("Angka " + cari + " ada di indeks " + i);
            break;
         }
      }

      if (!ketemu) {
         System.out.println("Angka " + cari + " gak ada di array.");
      }
   }
}