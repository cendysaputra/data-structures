package Praktikum1;

public class ArrayExample {
   public static void main(String[] args) {
      int[] numbers = { 10, 20, 30, 40, 50 };

      // Traversal
      System.out.println("Traversal Array");
      for (int num : numbers) {
         System.out.println(num);
      }

      // Pencarian
      int target = 30;
      for (int i = 0; i < numbers.length; i++) {
         if (numbers[i] == target) {
            System.out.println("Elemen " + target + " ditemukan di indeks " + i);
         }
      }

      // Menambahkan elemen baru ke array
      int[] newNumber = new int[numbers.length + 1];
      System.arraycopy(numbers, 0, newNumber, 0, numbers.length);
      newNumber[newNumber.length - 1] = 60;

      System.out.println("Array setelah penambahan");
      for (int num : newNumber) {
         System.out.println(num);
      }
   }
}
