// class untuk representasi satu pelanggan (sebagai sebuah objek)
class Node {
    String namaPelanggan;
    Node next; // Referensi (pointer) ke pelanggan berikutnya dalam antrian

    public Node(String nama) {
        this.namaPelanggan = nama;
        this.next = null;
    }
}

// class untuk mengelola logika antrian
class AntrianLinkedList {
    private Node head; // bagian depan linked list
    private Node tail; // bagian belakang linked list

    public AntrianLinkedList() {
        this.head = null;
        this.tail = null;
    }

    // push menambah pelanggan ke bagian belakang antrian
    public void push(String nama) {
        Node pelangganBaru = new Node(nama);

        // jika antrian kosong head dan tail sama
        if (head == null) {
            head = pelangganBaru;
            tail = pelangganBaru;
        } else {
            // 1. Sambungkan pelanggan terakhir saat ini (tail) ke pelanggan baru
            tail.next = pelangganBaru;
            // 2. Pindahkan pointer tail ke pelanggan baru (update posisi belakang)
            tail = pelangganBaru;
        }
        System.out.println(nama + " masuk antrian.");
    }

    // pop untuk mengurangi antrian (menghapus pelanggan)
    public void pop() {
        if (head == null) {
            System.out.println("Antrian kosong");
            return;
        }

        String pelanggan = head.namaPelanggan;

        // lanjut ke pelanggan selanjutnya
        head = head.next;

        if (head == null) {
            tail = null;
        }

        System.out.println("Melayani pelanggan: " + pelanggan);
    }

    public void displayAntrian() {
        System.out.println("---------------------------");
        if (head == null) {
            System.out.println("Antrian saat ini kosong.");
            System.out.println("---------------------------");
            return;
        }

        System.out.print("Antrian: [Depan] ");
        Node current = head;
        while (current != null) {
            System.out.print(current.namaPelanggan + " -> ");
            current = current.next;
        }
        System.out.println("null [Belakang]");
        System.out.println("---------------------------\n");
    }
}

public class Main {

    // Method helper untuk test Push
    public static void testPush(AntrianLinkedList antrian, String nama) {
        long start = System.nanoTime();

        antrian.push(nama);

        long end = System.nanoTime();
        double durationSeconds = (end - start) / 1_000_000_000.0;

        System.out.printf("[PUSH %s] Time: %.9f detik (%d ns)%n\n", nama, durationSeconds, (end - start));
    }

    //  Method helper untuk test Pop
    public static void testPop(AntrianLinkedList antrian) {
        long start = System.nanoTime();

        antrian.pop();

        long end = System.nanoTime();
        double durationSeconds = (end - start) / 1_000_000_000.0;

        System.out.printf("[POP] Time: %.9f detik (%d ns)%n\n", durationSeconds, (end - start));
    }

    public static void main(String[] args) {
        AntrianLinkedList antrian = new AntrianLinkedList();

        System.out.println("=== PELANGGAN DALAM ANTRIAN ===");

        testPush(antrian, "Andi");
        testPush(antrian, "Budi");
        testPush(antrian, "Citra");

        antrian.displayAntrian();

        System.out.println("=== MELAYANI ===");
        testPop(antrian); // Melayani Andi
        testPop(antrian); // Melayani Budi

        antrian.displayAntrian();

        System.out.println("=== PELANGGAN BARU ===");
        testPush(antrian, "Dedi");

        antrian.displayAntrian();
    }
}