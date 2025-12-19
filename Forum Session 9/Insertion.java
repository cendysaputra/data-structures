class Node {
   int nilai;
   Node next;

   Node(int nilai) {
      this.nilai = nilai;
   }
}

class Insertion {
   Node head;

   void sisipDepan(int nilai) {
      Node baru = new Node(nilai);
      baru.next = head;
      head = baru;
   }

   void sisipBelakang(int nilai) {
      Node baru = new Node(nilai);
      if (head == null) {
         head = baru;
         return;
      }
      Node temp = head;
      while (temp.next != null)
         temp = temp.next;
      temp.next = baru;
   }

   void sisipTengah(int nilai, int posisi) {
      Node baru = new Node(nilai);
      if (posisi == 0) {
         sisipDepan(nilai);
         return;
      }
      Node temp = head;
      for (int i = 0; i < posisi - 1 && temp != null; i++) {
         temp = temp.next;
      }
      if (temp != null) {
         baru.next = temp.next;
         temp.next = baru;
      }
   }

   void tampil() {
      Node temp = head;
      while (temp != null) {
         System.out.print(temp.nilai + " -> ");
         temp = temp.next;
      }
      System.out.println("null");
   }

   public static void main(String[] args) {
      Insertion list = new Insertion();

      list.sisipDepan(15);
      list.sisipDepan(5);
      System.out.println("Sisip depan:");
      list.tampil();

      list.sisipBelakang(25);
      list.sisipBelakang(35);
      System.out.println("Sisip belakang:");
      list.tampil();

      list.sisipTengah(20, 2);
      System.out.println("Sisip posisi 2:");
      list.tampil();
   }
}