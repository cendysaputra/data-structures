// Class Node untuk Binary Search Tree
class Node {
   int data;
   Node left, right;

   Node(int data) {
      this.data = data;
      left = right = null;
   }
}

class BST {
   Node root;

   BST() {
      root = null;
   }

   void insert(int data) {
      root = insertRec(root, data);
   }

   Node insertRec(Node root, int data) {
      if (root == null) {
         root = new Node(data);
         return root;
      }

      if (data < root.data)
         root.left = insertRec(root.left, data);
      else if (data > root.data)
         root.right = insertRec(root.right, data);

      return root;
   }

   Node search(Node root, int key) {
      if (root == null || root.data == key)
         return root;

      if (key < root.data)
         return search(root.left, key);

      return search(root.right, key);
   }

   void inorderTraversal(Node node) {
      if (node == null)
         return;
      inorderTraversal(node.left);
      System.out.print(node.data + " ");
      inorderTraversal(node.right);
   }

   int findMin(Node root) {
      if (root == null)
         return -1;
      while (root.left != null) {
         root = root.left;
      }
      return root.data;
   }

   int findMax(Node root) {
      if (root == null)
         return -1;
      while (root.right != null) {
         root = root.right;
      }
      return root.data;
   }

   public static void main(String[] args) {
      BST bst = new BST();
      bst.insert(50);
      bst.insert(30);
      bst.insert(70);
      bst.insert(20);
      bst.insert(40);
      bst.insert(60);
      bst.insert(80);

      System.out.print("Inorder Traversal BST: ");
      bst.inorderTraversal(bst.root);
      System.out.println();

      int searchKey = 40;
      Node result = bst.search(bst.root, searchKey);
      if (result != null)
         System.out.println("Elemen " + searchKey + " ditemukan dalam BST");
      else
         System.out.println("Elemen " + searchKey + " tidak ditemukan dalam BST");

      System.out.println("Nilai Minimum: " + bst.findMin(bst.root));
      System.out.println("Nilai Maksimum: " + bst.findMax(bst.root));
   }
}