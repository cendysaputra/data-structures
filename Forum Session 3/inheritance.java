class Hewan {
   String nama;

   public Hewan(String nama) {
      this.nama = nama;
   }

   public void makan() {
      System.out.println(nama + " sedang makan");
   }

   public void tidur() {
      System.out.println(nama + " sedang tidur");
   }
}

class Kucing extends Hewan {
   String warnaBulu;

   public Kucing(String nama, String warnaBulu) {
      super(nama);
      this.warnaBulu = warnaBulu;
   }

   public void mengeong() {
      System.out.println(nama + " mengeong: Meow!");
   }

   public void tampilkanInfo() {
      System.out.println("Nama: " + nama);
      System.out.println("Warna Bulu: " + warnaBulu);
   }
}

public class inheritance {
   public static void main(String[] args) {
      Kucing kucing1 = new Kucing("Neko", "Hitam");
      kucing1.tampilkanInfo();
      kucing1.makan();
      kucing1.mengeong();
   }
}