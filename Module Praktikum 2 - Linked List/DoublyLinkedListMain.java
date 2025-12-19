class DoublyNode {
   int data;
   DoublyNode next;
   DoublyNode prev;

   DoublyNode(int data) {
      this.data = data;
      this.next = null;
      this.prev = null;
   }
}

class DoublyLinkedList {
   DoublyNode head;

   void insert(int data) {
      DoublyNode newNode = new DoublyNode(data);
      if (head == null) {
         head = newNode;
      } else {
         DoublyNode temp = head;
         while (temp.next != null) {
            temp = temp.next;
         }
         temp.next = newNode;
         newNode.prev = temp;
      }
   }

   void display() {
      DoublyNode temp = head;
      while (temp != null) {
         System.out.print(temp.data + " <-> ");
         temp = temp.next;
      }
      System.out.println("null");
   }

   void delete(int value) {
      if (head == null) {
         System.out.println("List kosong");
         return;
      }

      DoublyNode temp = head;

      while (temp != null && temp.data != value) {
         temp = temp.next;
      }

      if (temp == null) {
         System.out.println("Nilai tidak ditemukan");
         return;
      }

      if (temp.prev != null) {
         temp.prev.next = temp.next;
      } else {
         head = temp.next;
      }

      if (temp.next != null) {
         temp.next.prev = temp.prev;
      }
   }
}

public class DoublyLinkedListMain {
   public static void main(String[] args) {
      DoublyLinkedList dll = new DoublyLinkedList();
      dll.insert(10);
      dll.insert(20);
      dll.insert(30);
      dll.display();
      dll.delete(20);
      dll.display();
   }
}