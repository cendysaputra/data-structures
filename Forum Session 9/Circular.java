class Node {
   int data;
   Node next;

   Node(int data) {
      this.data = data;
   }
}

class Circular {
   Node head;

   void tambah(int data) {
      Node baru = new Node(data);

      if (head == null) {
         head = baru;
         baru.next = head;
      } else {
         Node temp = head;
         while (temp.next != head)
            temp = temp.next;
         temp.next = baru;
         baru.next = head;
      }
   }

   void tampil() {
      if (head == null)
         return;

      Node temp = head;
      do {
         System.out.print(temp.data + " -> ");
         temp = temp.next;
      } while (temp != head);
      System.out.println("(balik ke " + head.data + ")");
   }

   public static void main(String[] args) {
      Circular list = new Circular();

      list.tambah(5);
      list.tambah(10);
      list.tambah(15);

      list.tampil();
   }
}