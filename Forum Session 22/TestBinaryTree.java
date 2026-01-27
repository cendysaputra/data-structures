class Node {
   int data;
   Node left, right;

   public Node(int item) {
      data = item;
      left = right = null;
   }
}

class BinaryTree {
   Node root;

   BinaryTree() {
      root = null;
   }

   BinaryTree(int data) {
      root = new Node(data);
   }

   void insert(int data) {
      if (root == null) {
         root = new Node(data);
         return;
      }

      java.util.Queue<Node> queue = new java.util.LinkedList<>();
      queue.add(root);

      while (!queue.isEmpty()) {
         Node temp = queue.poll();

         if (temp.left == null) {
            temp.left = new Node(data);
            break;
         } else {
            queue.add(temp.left);
         }

         if (temp.right == null) {
            temp.right = new Node(data);
            break;
         } else {
            queue.add(temp.right);
         }
      }
   }

   void inorder() {
      System.out.print("Inorder: ");
      inorderRec(root);
      System.out.println();
   }

   void inorderRec(Node node) {
      if (node != null) {
         inorderRec(node.left);
         System.out.print(node.data + " ");
         inorderRec(node.right);
      }
   }

   void preorder() {
      System.out.print("Preorder: ");
      preorderRec(root);
      System.out.println();
   }

   void preorderRec(Node node) {
      if (node != null) {
         System.out.print(node.data + " ");
         preorderRec(node.left);
         preorderRec(node.right);
      }
   }

   void postorder() {
      System.out.print("Postorder: ");
      postorderRec(root);
      System.out.println();
   }

   void postorderRec(Node node) {
      if (node != null) {
         postorderRec(node.left);
         postorderRec(node.right);
         System.out.print(node.data + " ");
      }
   }

   void levelOrder() {
      if (root == null)
         return;

      System.out.print("Level Order: ");
      java.util.Queue<Node> queue = new java.util.LinkedList<>();
      queue.add(root);

      while (!queue.isEmpty()) {
         Node temp = queue.poll();
         System.out.print(temp.data + " ");

         if (temp.left != null)
            queue.add(temp.left);
         if (temp.right != null)
            queue.add(temp.right);
      }
      System.out.println();
   }

   int countNodes() {
      return countNodesRec(root);
   }

   int countNodesRec(Node node) {
      if (node == null)
         return 0;
      return 1 + countNodesRec(node.left) + countNodesRec(node.right);
   }

   int height() {
      return heightRec(root);
   }

   int heightRec(Node node) {
      if (node == null)
         return 0;

      int leftHeight = heightRec(node.left);
      int rightHeight = heightRec(node.right);

      return Math.max(leftHeight, rightHeight) + 1;
   }

   boolean search(int data) {
      return searchRec(root, data);
   }

   boolean searchRec(Node node, int data) {
      if (node == null)
         return false;

      if (node.data == data)
         return true;

      return searchRec(node.left, data) || searchRec(node.right, data);
   }
}

public class TestBinaryTree {
   public static void main(String[] args) {
      BinaryTree tree = new BinaryTree();

      tree.insert(1);
      tree.insert(2);
      tree.insert(3);
      tree.insert(4);
      tree.insert(5);
      tree.insert(6);
      tree.insert(7);

      System.out.println("Binary Tree Traversals:");
      System.out.println("========================");

      tree.inorder();
      tree.preorder();
      tree.postorder();
      tree.levelOrder();

      System.out.println("\nInformasi Tree:");
      System.out.println("========================");
      System.out.println("Jumlah node: " + tree.countNodes());
      System.out.println("Tinggi tree: " + tree.height());

      System.out.println("\nPencarian:");
      System.out.println("========================");
      System.out.println("Cari 5: " + tree.search(5));
      System.out.println("Cari 10: " + tree.search(10));

      System.out.println("\n\nTree Manual:");
      System.out.println("========================");
      BinaryTree tree2 = new BinaryTree(10);
      tree2.root.left = new Node(20);
      tree2.root.right = new Node(30);
      tree2.root.left.left = new Node(40);
      tree2.root.left.right = new Node(50);

      tree2.inorder();
      tree2.preorder();
      tree2.postorder();
   }
}