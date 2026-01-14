class CircularQueue {
   private int arr[];
   private int front, rear, size, capacity;

   CircularQueue(int capacity) {
      this.capacity = capacity;
      arr = new int[capacity];
      front = size = 0;
      rear = capacity - 1;
   }

   boolean isFull() {
      return size == capacity;
   }

   boolean isEmpty() {
      return size == 0;
   }

   void enqueue(int data) {
      if (isFull()) {
         System.out.println("Queue Penuh");
         return;
      }
      rear = (rear + 1) % capacity;
      arr[rear] = data;
      size++;
   }

   int dequeue() {
      if (isEmpty()) {
         System.out.println("Queue Kosong");
         return -1;
      }
      int data = arr[front];
      front = (front + 1) % capacity;
      size--;
      return data;
   }

   void display() {
      if (isEmpty()) {
         System.out.println("Queue Kosong");
         return;
      }
      for (int i = 0; i < size; i++) {
         System.out.print(arr[(front + i) % capacity] + " ");
      }
      System.out.println();
   }

   public static void main(String[] args) {
      CircularQueue cq = new CircularQueue(5);

      cq.enqueue(10);
      cq.enqueue(20);
      cq.enqueue(30);

      System.out.println("Circular Queue:");
      cq.display();

      cq.dequeue();
      System.out.println("Setelah dequeue:");
      cq.display();
   }
}