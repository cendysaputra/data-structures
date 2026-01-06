class Node {
   int data;
   Node prev, next;

   Node(int data) {
      this.data = data;
   }
}

class DoublyLinkedList {
   Node head;

   public void insert(int data) {
      Node newNode = new Node(data);
      if (head == null) {
         head = newNode;
      } else {
         Node cur = head;
         while (cur.next != null)
            cur = cur.next;
         cur.next = newNode;
         newNode.prev = cur;
      }
   }

   // 1. Hapus di awal
   public void deleteBeginning() {
      if (head != null) {
         head = head.next;
         if (head != null)
            head.prev = null;
      }
   }

   // 2. Hapus di akhir
   public void deleteEnd() {
      if (head == null)
         return;
      if (head.next == null) {
         head = null;
         return;
      }
      Node cur = head;
      while (cur.next != null)
         cur = cur.next;
      cur.prev.next = null;
   }

   // 3. Hapus berdasarkan nilai
   public void deleteByValue(int key) {
      Node cur = head;
      while (cur != null && cur.data != key)
         cur = cur.next;
      if (cur == null)
         return;
      if (cur.prev != null)
         cur.prev.next = cur.next;
      else
         head = cur.next;
      if (cur.next != null)
         cur.next.prev = cur.prev;
   }

   public void display() {
      Node cur = head;
      while (cur != null) {
         System.out.print(cur.data + " <-> ");
         cur = cur.next;
      }
      System.out.println("null");
   }
}

public class DeletionDoubly {
   public static void main(String[] args) {
      DoublyLinkedList dll = new DoublyLinkedList();

      dll.insert(10);
      dll.insert(20);
      dll.insert(30);
      dll.insert(40);

      System.out.println("List awal:");
      dll.display();

      dll.deleteBeginning();
      System.out.println("Setelah hapus awal:");
      dll.display();

      dll.deleteEnd();
      System.out.println("Setelah hapus akhir:");
      dll.display();

      dll.deleteByValue(20);
      System.out.println("Setelah hapus nilai 20:");
      dll.display();
   }
}
