class Node {
   int data;
   Node prev, next;

   Node(int data) {
      this.data = data;
   }
}

class DoublyLinkedList {
   Node head;

   void sisipAwal(int data) {
      Node n = new Node(data);
      n.next = head;
      if (head != null)
         head.prev = n;
      head = n;
   }

   void sisipAkhir(int data) {
      Node n = new Node(data);
      if (head == null) {
         head = n;
         return;
      }
      Node cur = head;
      while (cur.next != null)
         cur = cur.next;
      cur.next = n;
      n.prev = cur;
   }

   void sisipSetelah(int key, int data) {
      Node cur = head;
      while (cur != null && cur.data != key)
         cur = cur.next;
      if (cur == null)
         return;
      Node n = new Node(data);
      n.next = cur.next;
      n.prev = cur;
      if (cur.next != null)
         cur.next.prev = n;
      cur.next = n;
   }

   void tampilkan() {
      Node cur = head;
      while (cur != null) {
         System.out.print(cur.data + " <-> ");
         cur = cur.next;
      }
      System.out.println("null");
   }
}

public class InsertionDoubly {
   public static void main(String[] args) {
      DoublyLinkedList dll = new DoublyLinkedList();

      dll.sisipAkhir(10);
      dll.sisipAkhir(20);
      dll.sisipAkhir(30);
      System.out.print("Sisip Akhir: ");
      dll.tampilkan();

      dll.sisipAwal(5);
      System.out.print("Sisip Awal: ");
      dll.tampilkan();

      dll.sisipSetelah(20, 25);
      System.out.print("Sisip Setelah 20: ");
      dll.tampilkan();
   }
}