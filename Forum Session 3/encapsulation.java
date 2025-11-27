class Product {
   private String name;
   private int stock;

   public Product(String name, int stock) {
      this.name = name;
      this.stock = stock;
   }

   public String getName() {
      return name;
   }

   public int getStock() {
      return stock;
   }

   public void setStock(int stock) {
      this.stock = stock;
   }

   public void displayInfo() {
      System.out.println("Produk: " + name);
      System.out.println("Stok: " + stock);
   }
}

public class encapsulation {
   public static void main(String[] args) {
      Product produk1 = new Product("Laptop", 10);

      produk1.displayInfo();

      produk1.setStock(15);

      System.out.println("\nSetelah ubah:");
      produk1.displayInfo();
   }
}