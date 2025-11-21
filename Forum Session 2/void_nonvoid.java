public class void_nonvoid {
  // Method VOID
  static void tampilkanHasil(int angka) {
    System.out.println("Hasilnya adalah: " + angka);
  }

  // Method NON VOID
  static int kuadrat(int angka) {
    return angka * angka;
  }

  static int jumlah(int a, int b) {
    return a + b;
  }

  static double bagi(double a, double b) {
    return a / b;
  }

  // Method non void panggil non void lain
  static int luasPersegi(int sisi) {
    return sisi * sisi;
  }

  static int luasKubus(int sisi) {
    return 6 * luasPersegi(sisi);
  }

  public static void main(String[] args) {
    int hasilKuadrat = kuadrat(5);
    tampilkanHasil(hasilKuadrat);

    int hasilJumlah = jumlah(10, 15);
    System.out.println("10 + 15 = " + hasilJumlah);

    System.out.println("20 / 4 = " + bagi(20, 4));

    int sisi = 8;
    System.out.println("Luas kubus sisi " + sisi + " = " + luasKubus(sisi));
  }
}