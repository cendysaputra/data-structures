class Node {
   int data;
   Node left, right;

   public Node(int item) {
      data = item;
      left = right = null;
   }
}

class BinarySearchTree {
   Node root;

   BinarySearchTree() {
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

   boolean search(int data) {
      return searchRec(root, data);
   }

   boolean searchRec(Node root, int data) {
      if (root == null)
         return false;

      if (root.data == data)
         return true;

      if (data < root.data)
         return searchRec(root.left, data);
      else
         return searchRec(root.right, data);
   }

   void delete(int data) {
      root = deleteRec(root, data);
   }

   Node deleteRec(Node root, int data) {
      if (root == null)
         return root;

      if (data < root.data)
         root.left = deleteRec(root.left, data);
      else if (data > root.data)
         root.right = deleteRec(root.right, data);
      else {
         if (root.left == null)
            return root.right;
         else if (root.right == null)
            return root.left;

         root.data = minValue(root.right);
         root.right = deleteRec(root.right, root.data);
      }

      return root;
   }

   int minValue(Node root) {
      int minv = root.data;
      while (root.left != null) {
         minv = root.left.data;
         root = root.left;
      }
      return minv;
   }

   void inorder() {
      inorderRec(root);
      System.out.println();
   }

   void inorderRec(Node root) {
      if (root != null) {
         inorderRec(root.left);
         System.out.print(root.data + " ");
         inorderRec(root.right);
      }
   }

   void preorder() {
      preorderRec(root);
      System.out.println();
   }

   void preorderRec(Node root) {
      if (root != null) {
         System.out.print(root.data + " ");
         preorderRec(root.left);
         preorderRec(root.right);
      }
   }

   void postorder() {
      postorderRec(root);
      System.out.println();
   }

   void postorderRec(Node root) {
      if (root != null) {
         postorderRec(root.left);
         postorderRec(root.right);
         System.out.print(root.data + " ");
      }
   }
}

public class Main {
   public static void main(String[] args) {
      BinarySearchTree bst = new BinarySearchTree();
      bst.insert(50);
      bst.insert(30);
      bst.insert(70);
      bst.insert(20);
      bst.insert(40);
      bst.insert(60);
      bst.insert(80);

      System.out.println("Inorder traversal:");
      bst.inorder();

      System.out.println("\nPreorder traversal:");
      bst.preorder();

      System.out.println("\nPostorder traversal:");
      bst.postorder();

      System.out.println("\nCari 40: " + bst.search(40));
      System.out.println("Cari 90: " + bst.search(90));

      System.out.println("\nHapus 20");
      bst.delete(20);
      System.out.println("Inorder setelah hapus:");
      bst.inorder();

      System.out.println("\nHapus 30");
      bst.delete(30);
      System.out.println("Inorder setelah hapus:");
      bst.inorder();

      System.out.println("\nHapus 50");
      bst.delete(50);
      System.out.println("Inorder setelah hapus:");
      bst.inorder();
   }
}