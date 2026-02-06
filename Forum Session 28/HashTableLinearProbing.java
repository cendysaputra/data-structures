public class HashTableLinearProbing {
   static int[] table = new int[8];
   static boolean[] occupied = new boolean[8];

   static int hash(int key) {
      return key % 8;
   }

   static void insert(int key) {
      int index = hash(key);
      while (occupied[index]) {
         System.out.println("Collision di indeks " + index + " untuk key " + key);
         index = (index + 1) % 8;
      }
      table[index] = key;
      occupied[index] = true;
      System.out.println("Key " + key + " masuk ke indeks " + index);
   }

   static void display() {
      System.out.println("\nHash Table:");
      for (int i = 0; i < 8; i++) {
         if (occupied[i])
            System.out.println("Indeks " + i + " : " + table[i]);
         else
            System.out.println("Indeks " + i + " : kosong");
      }
   }

   public static void main(String[] args) {
      int[] data = { 72, 27, 36, 45, 63, 82, 94, 105 };
      for (int key : data) {
         insert(key);
      }
      display();
   }
}