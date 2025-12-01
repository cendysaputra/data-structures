public class array_1_dimensi {
    public static void main(String[] arg) {
        String days[] = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        for (int k = 0; k < days.length; k++) {
            System.out.println(days[k]);
        }

        System.out.println();

        int m = 0;
        do {
            System.out.println(days[m]);
            m++;
        } while(m < days.length);
    }
}