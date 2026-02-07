import java.util.LinkedList;

class EmployeeHashTable {
   static class Entry {
      int id;
      String name;

      Entry(int id, String name) {
         this.id = id;
         this.name = name;
      }
   }

   LinkedList<Entry>[] table;
   int size;

   @SuppressWarnings("unchecked")
   EmployeeHashTable(int size) {
      this.size = size;
      table = new LinkedList[size];
      for (int i = 0; i < size; i++)
         table[i] = new LinkedList<>();
   }

   int hash(int id) {
      return id % size;
   }

   void insert(int id, String name) {
      table[hash(id)].add(new Entry(id, name));
   }

   int getTotalEmployees() {
      int count = 0;
      for (int i = 0; i < size; i++)
         count += table[i].size();
      return count;
   }

   void display() {
      for (int i = 0; i < size; i++) {
         System.out.print("Index " + i + ": ");
         for (Entry e : table[i])
            System.out.print("(ID: " + e.id + ", Nama: " + e.name + ") -> ");
         System.out.println("null");
      }
   }

   public static void main(String[] args) {
      EmployeeHashTable et = new EmployeeHashTable(10);
      et.insert(101, "Budi Santoso");
      et.insert(102, "Dewi Lestari");
      et.insert(111, "Andi Pratama");

      System.out.println("Data Karyawan:");
      et.display();
      System.out.println("\nTotal Karyawan: " + et.getTotalEmployees());
   }
}