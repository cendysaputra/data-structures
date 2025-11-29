public class array {
   public static void main(String[] args) {
      int[] numbers = { 10, 20, 30, 40, 50 };

      System.out.println("Isi Array:");
      for (int num : numbers) {
         System.out.println(num);
      }

      int target = 30;
      for (int i = 0; i < numbers.length; i++) {
         if (numbers[i] == target) {
            System.out.println("Elemen " + target + " ditemukan di indeks " + i);
         }
      }

      int[] newNumbers = new int[numbers.length + 1];
      System.arraycopy(numbers, 0, newNumbers, 0, numbers.length);
      newNumbers[newNumbers.length - 1] = 60;

      System.out.println("\nSetelah penyisipan:");
      for (int num : newNumbers) {
         System.out.println(num);
      }
   }
}