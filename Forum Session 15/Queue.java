class Node {
   int data;
   Node next;

   Node(int data) {
      this.data = data;
      this.next = null;
   }
}

class Queue {
   Node front, rear;

   void enqueue(int data) {
      Node newNode = new Node(data);
      if (rear == null) {
         front = rear = newNode;
         return;
      }
      rear.next = newNode;
      rear = newNode;
   }

   int dequeue() {
      if (front == null) {
         System.out.println("Queue Underflow");
         return -1;
      }
      int data = front.data;
      front = front.next;
      if (front == null) {
         rear = null;
      }
      return data;
   }

   int peek() {
      if (front == null) {
         System.out.println("Queue kosong");
         return -1;
      }
      return front.data;
   }

   boolean isEmpty() {
      return front == null;
   }

   void display() {
      Node temp = front;
      while (temp != null) {
         System.out.print(temp.data + " -> ");
         temp = temp.next;
      }
      System.out.println("null");
   }

   public static void main(String[] args) {
      Queue queue = new Queue();

      queue.enqueue(10);
      queue.enqueue(20);
      queue.enqueue(30);

      System.out.println("setelah enqueue:");
      queue.display();

      System.out.println("Elemen terdepan: " + queue.peek());

      System.out.println("Elemen yang di-dequeue: " + queue.dequeue());

      System.out.println("Queue setelah dequeue:");
      queue.display();

      System.out.println("queue kosong? " + queue.isEmpty());
   }
}