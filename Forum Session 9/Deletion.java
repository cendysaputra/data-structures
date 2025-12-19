class Node {
   int data;
   Node next;

   Node(int data) {
      this.data = data;
   }
}

class Deletion {
   Node head;

   void tambah(int data) {
      Node baru = new Node(data);
      if (head == null) {
         head = baru;
      } else {
         Node temp = head;
         while (temp.next != null)
            temp = temp.next;
         temp.next = baru;
      }
   }

   void hapusPertama() {
      if (head != null)
         head = head.next;
   }

   void hapusTerakhir() {
      if (head == null || head.next == null) {
         head = null;
         return;
      }
      Node temp = head;
      while (temp.next.next != null)
         temp = temp.next;
      temp.next = null;
   }

   void hapusNilai(int nilai) {
      if (head == null)
         return;
      if (head.data == nilai) {
         head = head.next;
         return;
      }
      Node temp = head;
      while (temp.next != null && temp.next.data != nilai) {
         temp = temp.next;
      }
      if (temp.next != null)
         temp.next = temp.next.next;
   }

   void tampil() {
      Node temp = head;
      while (temp != null) {
         System.out.print(temp.data + " -> ");
         temp = temp.next;
      }
      System.out.println("null");
   }

   public static void main(String[] args) {
      Deletion list = new Deletion();
      list.tambah(10);
      list.tambah(20);
      list.tambah(30);
      list.tambah(40);

      System.out.println("Awal:");
      list.tampil();

      list.hapusPertama();
      System.out.println("Hapus pertama:");
      list.tampil();

      list.hapusNilai(30);
      System.out.println("Hapus 30:");
      list.tampil();

      list.hapusTerakhir();
      System.out.println("Hapus terakhir:");
      list.tampil();
   }
}