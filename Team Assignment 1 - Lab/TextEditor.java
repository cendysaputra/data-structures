import java.util.Stack;

class TextEditor {
    private StringBuilder currentText;
    private Stack<String> undoStack;
    private Stack<String> redoStack;

    public TextEditor() {
        this.currentText = new StringBuilder();
        this.undoStack = new Stack<>();
        this.redoStack = new Stack<>();
    }

    public void addText(String text) {
        // Simpan state sebelum perubahan ke undoStack
        undoStack.push(currentText.toString());

        // Tambahkan teks baru
        currentText.append(text);

        // Clear redoStack karena ada perubahan baru
        redoStack.clear();

        System.out.println("Menambah Teks: \"" + text + "\"");
        System.out.println("Teks saat ini: \"" + currentText.toString() + "\"");
    }

    /**
     * Undo - mengembalikan ke kondisi sebelum perubahan terakhir
     */
    public void undo() {
        if (undoStack.isEmpty()) {
            System.out.println("Tidak ada history untuk di-undo");
            return;
        }

        // Simpan state saat ini ke redoStack
        redoStack.push(currentText.toString());

        // Restore ke state sebelumnya
        currentText = new StringBuilder(undoStack.pop());

        System.out.println("Melakukan Undo");
        System.out.println("Teks saat ini: \"" + currentText.toString() + "\"");
    }

    /**
     * Redo - mengembalikan perubahan yang telah di-undo
     */
    public void redo() {
        if (redoStack.isEmpty()) {
            System.out.println("Tidak ada history untuk di-redo");
            return;
        }

        // Simpan state saat ini ke undoStack
        undoStack.push(currentText.toString());

        // Restore ke state yang di-redo
        currentText = new StringBuilder(redoStack.pop());

        System.out.println("Melakukan Redo");
        System.out.println("Teks saat ini: \"" + currentText.toString() + "\"");
    }

    /**
     * Mendapatkan teks saat ini
     */
    public String getText() {
        return currentText.toString();
    }

    /**
     * Menampilkan status stack
     */
    public void showStatus() {
        System.out.println("Teks saat ini: \"" + currentText.toString() + "\"");
        System.out.println("Undo Stack size: " + undoStack.size());
        System.out.println("Redo Stack size: " + redoStack.size());
    }

    public static void main(String[] args) {

        TextEditor editor = new TextEditor();

        // Test Case 1: Menambahkan teks
        System.out.println("TEST CASE 1: MENAMBAHKAN TEKS");
        long startTime = System.nanoTime();
        editor.addText("Hello");
        long endTime = System.nanoTime();
        System.out.printf("ExecTime: %.6f detik\n\n", (endTime - startTime) / 1_000_000_000.0);

        // Test Case 2: Menambahkan teks lagi
        System.out.println("TEST CASE 2: MENAMBAHKAN TEKS LAGI");
        startTime = System.nanoTime();
        editor.addText(" World");
        endTime = System.nanoTime();
        System.out.printf("ExecTime: %.6f detik\n\n", (endTime - startTime) / 1_000_000_000.0);

        // Test Case 3: Menambahkan teks lagi
        System.out.println("TEST CASE 3: MENAMBAHKAN TEKS LAGI");
        startTime = System.nanoTime();
        editor.addText("!");
        endTime = System.nanoTime();
        System.out.printf("ExecTime: %.6f detik\n\n", (endTime - startTime) / 1_000_000_000.0);

        editor.showStatus();

        // Test Case 4: Undo
        System.out.println("\nTEST CASE 4: UNDO");
        startTime = System.nanoTime();
        editor.undo();
        endTime = System.nanoTime();
        System.out.printf("ExecTime: %.6f detik\n\n", (endTime - startTime) / 1_000_000_000.0);

        editor.showStatus();

        // Test Case 5: Undo lagi
        System.out.println("\nTEST CASE 5: UNDO LAGI");
        startTime = System.nanoTime();
        editor.undo();
        endTime = System.nanoTime();
        System.out.printf("ExecTime: %.6f detik\n\n", (endTime - startTime) / 1_000_000_000.0);

        editor.showStatus();

        // Test Case 6: Redo
        System.out.println("\nTEST CASE 6: REDO");
        startTime = System.nanoTime();
        editor.redo();
        endTime = System.nanoTime();
        System.out.printf("ExecTime: %.6f detik\n\n", (endTime - startTime) / 1_000_000_000.0);

        editor.showStatus();

        // Test Case 7: Menambah teks setelah undo (redoStack akan di-clear)
        System.out.println("\nTEST CASE 7: MENAMBAH TEKS SETELAH UNDO");
        startTime = System.nanoTime();
        editor.addText(" Java");
        endTime = System.nanoTime();
        System.out.printf("ExecTime: %.6f detik\n\n", (endTime - startTime) / 1_000_000_000.0);

        editor.showStatus();

        // Test Case 8: Redo ketika redoStack kosong
        System.out.println("\nTEST CASE 8: REDO KETIKA REDOSTACK KOSONG");
        startTime = System.nanoTime();
        editor.redo();
        endTime = System.nanoTime();
        System.out.printf("ExecTime: %.6f detik\n\n", (endTime - startTime) / 1_000_000_000.0);

        // Test Case 9: Multiple Undo
        System.out.println("TEST CASE 9: MULTIPLE UNDO");
        startTime = System.nanoTime();
        editor.undo();
        editor.undo();
        endTime = System.nanoTime();
        System.out.printf("ExecTime: %.6f detik\n\n", (endTime - startTime) / 1_000_000_000.0);

        editor.showStatus();

        // Test Case 10: Multiple Redo
        System.out.println("\nTEST CASE 10: MULTIPLE REDO");
        startTime = System.nanoTime();
        editor.redo();
        editor.redo();
        endTime = System.nanoTime();
        System.out.printf("ExecTime: %.6f detik\n\n", (endTime - startTime) / 1_000_000_000.0);

        editor.showStatus();
    }

}