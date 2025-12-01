public class array_multidimensi {
    public static void main(String[] arg) {
        String[][] address = {
            {"Cendy", "735-1234", "Bogor"},
            {"Joyce", "983-3333", "Bogor"},
            {"Becca", "456-3322", "Bogor"}
        };

        System.out.println("Buku Alamat saya");
        System.out.println();

        for (int n = 0; n < address.length; n++) {
            System.out.println("Name: " + address[n][0]);
            System.out.println("Tel. #: " + address[n][1]);
            System.out.println("Address: " + address[n][2]);
            System.out.println();
        }
    }
}