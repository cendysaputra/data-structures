class PriorityQueue {
   public static void main(String[] args) {

      java.util.PriorityQueue<Integer> pq = new java.util.PriorityQueue<>();

      pq.add(30);
      pq.add(10);
      pq.add(20);

      System.out.println("Menghapus elemen dengan prioritas tertinggi: " + pq.poll());
      System.out.println("Elemen berikutnya: " + pq.peek());
   }
}