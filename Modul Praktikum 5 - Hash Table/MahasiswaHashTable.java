import java.util.LinkedList;

class MahasiswaHashTable {
   LinkedList<int[]> keys;
   LinkedList<String[]> values;
   int size;

   static class Entry {
      int key;
      String value;

      Entry(int k, String v) {
         key = k;
         value = v;
      }
   }

   LinkedList<Entry>[] table;

   @SuppressWarnings("unchecked")
   MahasiswaHashTable(int size) {
      this.size = size;
      table = new LinkedList[size];
      for (int i = 0; i < size; i++)
         table[i] = new LinkedList<>();
   }

   int hash(int key) {
      return key % size;
   }

   void insert(int key, String value) {
      table[hash(key)].add(new Entry(key, value));
   }

   void update(int key, String newValue) {
      for (Entry e : table[hash(key)])
         if (e.key == key) {
            e.value = newValue;
            return;
         }
      System.out.println("NIM " + key + " tidak ditemukan.");
   }

   void delete(int key) {
      table[hash(key)].removeIf(e -> e.key == key);
   }

   void display() {
      for (int i = 0; i < size; i++) {
         System.out.print("Index " + i + ": ");
         for (Entry e : table[i])
            System.out.print("(NIM: " + e.key + ", Nama: " + e.value + ") -> ");
         System.out.println("null");
      }
   }

   public static void main(String[] args) {
      MahasiswaHashTable ht = new MahasiswaHashTable(10);
      ht.insert(20231001, "John Doe");
      ht.insert(20231002, "Jane Smith");

      System.out.println("Sebelum update dan delete:");
      ht.display();

      ht.update(20231002, "Jane Updated");
      System.out.println("\nSetelah update:");
      ht.display();

      ht.delete(20231001);
      System.out.println("\nSetelah delete:");
      ht.display();
   }
}