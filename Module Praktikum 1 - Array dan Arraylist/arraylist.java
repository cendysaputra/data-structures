import java.util.ArrayList;

public class arraylist {
   public static void main(String[] args) {
      ArrayList<Integer> numbers = new ArrayList<>();

      numbers.add(10);
      numbers.add(20);
      numbers.add(30);

      System.out.println("Setelah penambahan: " + numbers);

      numbers.remove(Integer.valueOf(30));

      System.out.println("Setelah penghapusan: " + numbers);
   }
}