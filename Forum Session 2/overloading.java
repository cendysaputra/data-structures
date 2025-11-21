class Hitung {
  int kali(int a, int b) {
    return a * b;
  }

  int kali(int a, int b, int c) {
    return a * b * c;
  }

  double kali(double a, double b) {
    return a * b;
  }
}

public class overloading {
  public static void main(String[] args) {
    Hitung hit = new Hitung();
    System.out.println("2 x 3 = " + hit.kali(2, 3));
    System.out.println("2 x 3 x 4 = " + hit.kali(2, 3, 4));
    System.out.println("2.5 x 4.0 = " + hit.kali(2.5, 4.0));
  }
}
