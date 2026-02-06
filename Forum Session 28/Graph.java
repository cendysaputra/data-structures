import java.util.LinkedList;
import java.util.Queue;

class Graph {
   private LinkedList<Integer>[] adjList;
   private int nodes;

   public Graph(int nodes) {
      this.nodes = nodes;
      adjList = new LinkedList[nodes];
      for (int i = 0; i < nodes; i++) {
         adjList[i] = new LinkedList<>();
      }
   }

   public void addEdge(int src, int dest) {
      adjList[src].add(dest);
   }

   public void DFS(int start) {
      boolean[] visited = new boolean[nodes];
      System.out.print("DFS dari node " + start + ": ");
      dfsHelper(start, visited);
      System.out.println();
   }

   private void dfsHelper(int node, boolean[] visited) {
      visited[node] = true;
      System.out.print(node + " ");
      for (int adj : adjList[node]) {
         if (!visited[adj]) {
            dfsHelper(adj, visited);
         }
      }
   }

   public void BFS(int start) {
      boolean[] visited = new boolean[nodes];
      Queue<Integer> queue = new LinkedList<>();
      visited[start] = true;
      queue.add(start);

      System.out.print("BFS dari node " + start + ": ");
      while (!queue.isEmpty()) {
         int node = queue.poll();
         System.out.print(node + " ");
         for (int adj : adjList[node]) {
            if (!visited[adj]) {
               visited[adj] = true;
               queue.add(adj);
            }
         }
      }
      System.out.println();
   }

   public static void main(String[] args) {
      Graph graph = new Graph(5);
      graph.addEdge(0, 1);
      graph.addEdge(0, 4);
      graph.addEdge(1, 2);
      graph.addEdge(1, 3);
      graph.addEdge(1, 4);
      graph.addEdge(2, 3);
      graph.addEdge(3, 4);

      graph.DFS(0);
      graph.BFS(0);
   }
}