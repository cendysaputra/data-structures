package Praktikum1;

import java.util.ArrayList;

public class ArrayListExample {
   public static void main(String[] args) {
      ArrayList<Integer> numbers = new ArrayList<>();
      numbers.add(10);
      numbers.add(20);
      numbers.add(30);
      numbers.add(40);
      numbers.add(50);

      System.out.println("ArrayList awal: " + numbers);

      numbers.remove(Integer.valueOf(30)); // Hapus elemen 30
      System.out.println("ArrayList setelah penghapusan: " + numbers);
   }
}
