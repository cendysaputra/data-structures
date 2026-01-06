class Node {
   int data;
   Node prev;
   Node next;

   Node(int data) {
      this.data = data;
   }
}

class CircularDoublyLinkedList {
   Node head;

   // Insert di akhir
   public void insertAtTail(int data) {
      Node newNode = new Node(data);
      if (head == null) {
         head = newNode;
         newNode.next = head;
         newNode.prev = head;
      } else {
         Node tail = head.prev;
         newNode.next = head;
         newNode.prev = tail;
         tail.next = newNode;
         head.prev = newNode;
      }
   }

   // Insert di awal
   public void insertAtHead(int data) {
      insertAtTail(data);
      head = head.prev;
   }

   // Delete di awal
   public void deleteAtHead() {
      if (head == null)
         return;
      if (head.next == head) {
         head = null;
      } else {
         Node tail = head.prev;
         head = head.next;
         head.prev = tail;
         tail.next = head;
      }
   }

   // Delete di akhir
   public void deleteAtTail() {
      if (head == null)
         return;
      if (head.next == head) {
         head = null;
      } else {
         Node tail = head.prev;
         Node newTail = tail.prev;
         newTail.next = head;
         head.prev = newTail;
      }
   }

   // Tampilkan maju
   public void displayForward() {
      if (head == null) {
         System.out.println("List kosong");
         return;
      }
      Node current = head;
      do {
         System.out.print(current.data + " <-> ");
         current = current.next;
      } while (current != head);
      System.out.println("(kembali ke head)");
   }

   // Tampilkan mundur
   public void displayBackward() {
      if (head == null) {
         System.out.println("List kosong");
         return;
      }
      Node current = head.prev;
      do {
         System.out.print(current.data + " <-> ");
         current = current.prev;
      } while (current != head.prev);
      System.out.println("(kembali ke tail)");
   }
}

public class circulardoubly {
   public static void main(String[] args) {
      CircularDoublyLinkedList cdll = new CircularDoublyLinkedList();

      cdll.insertAtTail(10);
      cdll.insertAtTail(20);
      cdll.insertAtTail(30);

      System.out.println("Display Forward:");
      cdll.displayForward();

      System.out.println("Display Backward:");
      cdll.displayBackward();
   }
}
