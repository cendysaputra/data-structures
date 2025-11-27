class Hewan {
   public void bersuara() {
      System.out.println("Hewan bersuara");
   }
}

class Kucing extends Hewan {
   @Override
   public void bersuara() {
      System.out.println("Kucing mengeong");
   }
}

class Anjing extends Hewan {
   @Override
   public void bersuara() {
      System.out.println("Anjing menggonggong");
   }
}

public class polymorphism {
   public static void main(String[] args) {
      Hewan hewan1 = new Kucing();
      Hewan hewan2 = new Anjing();

      hewan1.bersuara();
      hewan2.bersuara();
   }
}