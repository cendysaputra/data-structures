// Parent Class

import java.util.Scanner;

class User {

    // Attribute
    int id;
    String name;

    // Constructor
    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Method
    public void interact() {
        System.out.println("User Interaction");
    }
}

// Child Class
class Admin extends User {
    public Admin(int id, String name) {
        super(id, name);
    }

    @Override
    public void interact() {
        System.out.println("Anda masuk sebagai: ADMIN");
        System.out.println("Izin: Tambah Mahasiswa, Hapus Mahasiswa, Update Nilai, Tampil, Cari");
    }
}

// Child Class
class Member extends User {
    public Member(int id, String name) {
        super(id, name);
    }

    @Override
    public void interact() {
        System.out.println("Anda masuk sebagai: MEMBER");
        System.out.println("Izin: Tampil, Cari");
    }
}

// STRUKTUR DATA MAHASISWA
class Student {
    private int id;
    private String name;
    private double score;

    public Student(int id, String name, double score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}

// NODE UNTUK SINGLE LINKED LIST
class Node {
    private Student data;
    private Node next;

    public Node(Student data) {
        this.data = data;
        this.next = null;
    }

    public Student getData() {
        return data;
    }

    public void setData(Student data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

// SINGLE LINKED LIST
class StudentList {
    private Node head;
    private int size;

    public StudentList() {
        this.head = null;
        this.size = 0;
    }

    // Menambahkan mahasiswa baru di akhir list
    public void addStudent(Student student) {
        Node newNode = new Node(student);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
    }

    // Menghapus mahasiswa berdasarkan nama
    public boolean removeStudent(String name) {
        if (head == null)
            return false;

        // Jika yang dihapus adalah head
        if (head.getData().getName().equalsIgnoreCase(name)) {
            head = head.getNext();
            size--;
            return true;
        }

        // Cari node sebelum node yang akan dihapus
        Node current = head;
        while (current.getNext() != null) {
            if (current.getNext().getData().getName().equalsIgnoreCase(name)) {
                current.setNext(current.getNext().getNext());
                size--;
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    // Mengupdate nilai mahasiswa berdasarkan nama
    public boolean updateScore(String name, double newScore) {
        Node current = head;
        while (current != null) {
            if (current.getData().getName().equalsIgnoreCase(name)) {
                current.getData().setScore(newScore);
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    // Menampilkan semua mahasiswa
    public void displayAll() {
        if (head == null) {
            System.out.println("Daftar mahasiswa kosong.");
            return;
        }
        Node current = head;
        System.out.println("\n========== DAFTAR MAHASISWA ==========");
        System.out.printf("%-5s | %-20s | %-8s\n", "ID", "Nama", "Nilai");
        System.out.println("======================================");
        while (current != null) {
            System.out.printf("%-5d | %-20s | %.2f\n", current.getData().getId(), current.getData().getName(),
                    current.getData().getScore());
            current = current.getNext();
        }
        System.out.println("======================================\n");
    }

    // Mencari mahasiswa berdasarkan nama
    public Student findStudent(String name) {
        Node current = head;
        while (current != null) {
            if (current.getData().getName().equalsIgnoreCase(name)) {
                return current.getData();
            }
            current = current.getNext();
        }
        return null;
    }

    // Mendapatkan ukuran list
    public int getSize() {
        return size;
    }
}

public class ManagementMahasiswa {
    static java.util.Scanner sc = new java.util.Scanner(System.in);

    private static void printExecutionTime(long startTime, String operationName) {
        long endTime = System.nanoTime();
        long execTime = endTime - startTime;
        System.out.printf("ExecTime %s: %.6f detik\n\n", operationName, execTime / 1_000_000_000.0);
    }

    public static void main(String[] args) {
        int choice;

        StudentList studentList = new StudentList();
        int nextId = 1;
        Scanner sc = new Scanner(System.in);

        // Data awal
        studentList.addStudent(new Student(nextId++, "John Wick", 85.5));
        studentList.addStudent(new Student(nextId++, "Megan Foxx", 92.0));
        studentList.addStudent(new Student(nextId++, "Alexandra Daddario", 78.5));

        System.out.println("Login Sebagai :");
        System.out.println("1. Admin");
        System.out.println("2. Member");
        System.out.print("Pilihan: ");
        int role = sc.nextInt();
        sc.nextLine();

        User currentUser;
        if (role == 1) {
            currentUser = new Admin(1, "Administrator");
        } else {
            currentUser = new Member(2, "Anggota");
        }

        // Panggil metode polymorphic
        currentUser.interact();
        System.out.println();

        do {
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Hapus Mahasiswa");
            System.out.println("3. Update Nilai Mahasiswa");
            System.out.println("4. Tampilkan Daftar Mahasiswa");
            System.out.println("5. Cari Mahasiswa");
            System.out.println("0. Keluar");
            System.out.print("Pilih Menu: ");

            choice = sc.nextInt();
            sc.nextLine();
            String message = "";

            // Tambah Mahasiswa
            if (choice == 1) {
                if (!(currentUser instanceof Admin)) {
                    message = "Akses ditolak: anda bukan Admin.";
                } else {
                    System.out.print("Masukkan Nama Mahasiswa: ");
                    String name = sc.nextLine();
                    System.out.print("Masukkan Nilai Mahasiswa: ");
                    double score = sc.nextDouble();
                    sc.nextLine();
                    long opStart = System.nanoTime();
                    studentList.addStudent(new Student(nextId++, name, score));
                    printExecutionTime(opStart, "Tambah Mahasiswa");
                    message = "Mahasiswa berhasil ditambahkan!";
                }
            }

            // Hapus Mahasiswa
            else if (choice == 2) {
                if (!(currentUser instanceof Admin)) {
                    message = "Akses ditolak: anda bukan Admin.";
                } else {
                    System.out.print("Masukkan Nama Mahasiswa yang ingin dihapus: ");
                    String name = sc.nextLine();
                    long opStart = System.nanoTime();
                    if (studentList.removeStudent(name)) {
                        message = "Mahasiswa berhasil dihapus!";
                    } else {
                        message = "Mahasiswa dengan nama " + name + " tidak ditemukan!";
                    }
                    printExecutionTime(opStart, "Hapus Mahasiswa");
                }
            }

            // Update Nilai Mahasiswa
            else if (choice == 3) {
                if (!(currentUser instanceof Admin)) {
                    message = "Akses ditolak: anda bukan Admin.";
                } else {
                    System.out.print("Masukkan Nama Mahasiswa: ");
                    String name = sc.nextLine();
                    System.out.print("Masukkan Nilai Baru: ");
                    double newScore = sc.nextDouble();
                    sc.nextLine();
                    long opStart = System.nanoTime();
                    if (studentList.updateScore(name, newScore)) {
                        message = "Nilai mahasiswa berhasil diupdate!";
                    } else {
                        message = "Mahasiswa dengan nama " + name + " tidak ditemukan!";
                    }
                    printExecutionTime(opStart, "Update Nilai Mahasiswa");
                }
            }

            // Menampilkan Daftar Mahasiswa
            else if (choice == 4) {
                long opStart = System.nanoTime();
                studentList.displayAll();
                printExecutionTime(opStart, "Tampil Daftar Mahasiswa");
            }

            // Cari Mahasiswa
            else if (choice == 5) {
                System.out.print("Masukkan Nama Mahasiswa yang dicari: ");
                String name = sc.nextLine();
                long opStart = System.nanoTime();
                Student found = studentList.findStudent(name);
                printExecutionTime(opStart, "Cari Mahasiswa");
                if (found != null) {
                    System.out.println("\n========== HASIL PENCARIAN ==========");
                    System.out.println("ID: " + found.getId());
                    System.out.println("Nama: " + found.getName());
                    System.out.println("Nilai: " + found.getScore());
                    System.out.println("=====================================\n");
                } else {
                    message = "Mahasiswa dengan nama " + name + " tidak ditemukan!";
                }
            }

            // Menu (tidak valid)
            else if (choice != 0) {
                message = "Menu tidak valid! Pilih menu yang ada.";
            }

            if (!message.isEmpty()) {
                System.out.println(message);
            }
        } while (choice != 0);
        System.out.println("\nTerima kasih telah menggunakan sistem manajemen mahasiswa!");
        sc.close();
    }
}