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

      System.out.println("Forward:");
      cdll.displayForward();

      System.out.println("\nBackward:");
      cdll.displayBackward();
   }
}