class CircularQueue {
   private int arr[];
   private int front, rear, size, capacity;

   // Constructor untuk inisialisasi Circular Queue
   CircularQueue(int capacity) {
      this.capacity = capacity;
      arr = new int[capacity];
      front = size = 0;
      rear = capacity - 1;
   }

   // Mengecek apakah queue penuh
   boolean isFull() {
      return size == capacity;
   }

   // Mengecek apakah queue kosong
   boolean isEmpty() {
      return size == 0;
   }

   // Menambahkan elemen ke queue
   void enqueue(int data) {
      if (isFull()) {
         System.out.println("Queue Penuh");
         return;
      }
      rear = (rear + 1) % capacity;
      arr[rear] = data;
      size++;
   }

   // Menghapus elemen dari queue
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

   // Menampilkan isi queue
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