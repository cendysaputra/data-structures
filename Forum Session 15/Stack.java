class Stack {
   private int arr[];
   private int top;
   private int capacity;

   Stack(int size) {
      arr = new int[size];
      capacity = size;
      top = -1;
   }

   void push(int x) {
      if (top == capacity - 1) {
         System.out.println("Stack Overflow");
         return;
      }
      arr[++top] = x;
   }

   int pop() {
      if (top == -1) {
         System.out.println("Stack Underflow");
         return -1;
      }
      return arr[top--];
   }

   int peek() {
      if (top == -1) {
         System.out.println("Stack is Empty");
         return -1;
      }
      return arr[top];
   }

   boolean isEmpty() {
      return top == -1;
   }

   void display() {
      if (isEmpty()) {
         System.out.println("Stack kosong");
         return;
      }
      System.out.print("Stack: ");
      for (int i = 0; i <= top; i++) {
         System.out.print(arr[i] + " ");
      }
      System.out.println();
   }

   public static void main(String[] args) {
      Stack stack = new Stack(5);

      stack.push(10);
      stack.push(20);
      stack.push(30);

      System.out.println("Stack setelah push:");
      stack.display();

      System.out.println("Elemen teratas: " + stack.peek());

      System.out.println("Elemen yang di-pop: " + stack.pop());

      System.out.println("Stack setelah pop:");
      stack.display();

      System.out.println("Stack kosong? " + stack.isEmpty());
   }
}