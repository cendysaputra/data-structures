public class HitungMundur {
   public static void mundur(int n) {
      if (n == 0) {
         System.out.println("Selesai!");
         return;
      }
      System.out.println(n);
      mundur(n - 1);
   }

   public static void main(String[] args) {
      mundur(5);
   }
}