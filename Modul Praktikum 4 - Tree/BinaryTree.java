// Class Node untuk Binary Tree
class Node {
   int data;
   Node left, right;

   Node(int data) {
      this.data = data;
      left = right = null;
   }
}

class BinaryTree {
   Node root;

   BinaryTree() {
      root = null;
   }

   void inorderTraversal(Node node) {
      if (node == null)
         return;
      inorderTraversal(node.left);
      System.out.print(node.data + " ");
      inorderTraversal(node.right);
   }

   void preorderTraversal(Node node) {
      if (node == null)
         return;
      System.out.print(node.data + " ");
      preorderTraversal(node.left);
      preorderTraversal(node.right);
   }

   void postorderTraversal(Node node) {
      if (node == null)
         return;
      postorderTraversal(node.left);
      postorderTraversal(node.right);
      System.out.print(node.data + " ");
   }

   int getHeight(Node root) {
      if (root == null)
         return 0;
      return 1 + Math.max(getHeight(root.left), getHeight(root.right));
   }

   int countNodes(Node root) {
      if (root == null)
         return 0;
      return 1 + countNodes(root.left) + countNodes(root.right);
   }

   public static void main(String[] args) {
      BinaryTree tree = new BinaryTree();
      tree.root = new Node(1);
      tree.root.left = new Node(2);
      tree.root.right = new Node(3);
      tree.root.left.left = new Node(4);
      tree.root.left.right = new Node(5);

      System.out.print("Inorder Traversal: ");
      tree.inorderTraversal(tree.root);
      System.out.println();

      System.out.print("Preorder Traversal: ");
      tree.preorderTraversal(tree.root);
      System.out.println();

      System.out.print("Postorder Traversal: ");
      tree.postorderTraversal(tree.root);
      System.out.println();

      System.out.println("Tinggi Tree: " + tree.getHeight(tree.root));
      System.out.println("Jumlah Node: " + tree.countNodes(tree.root));
   }
}