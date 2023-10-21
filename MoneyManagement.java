package sc;

import java.util.InputMismatchException;
import java.util.Scanner;

class Searching {
    public void SequentialSearch(String[] arr, int[] arrInt, String param) {
        int no = 1;
        boolean found = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                if (arr[i].contains(param)) {
                    System.out.println(no + ".  \t" + arr[i] + "\t  \t\t\tRp " + arrInt[i]);
                    no++;
                    found = true; 
                }
            }
        }
        if (!found) {
            System.out.println("Hasil Pencarian tidak ditemukan...");
        }
    }
}

class Sorting {
    public void bubbleSortAscending(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public void quickSortDescending(int[] arr) {
        quickSortDescending(arr, 0, arr.length - 1);
    }

    private void quickSortDescending(int[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high);

            quickSortDescending(arr, low, partitionIndex - 1);
            quickSortDescending(arr, partitionIndex + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] > pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}

class Pengeluaran {
    private final int LIMIT = 20;
    private String[] namaPengeluaran = new String[LIMIT];
    private int[] jumlahPengeluaran = new int[LIMIT];
    private int n = 0;
    Sorting sorting = new Sorting();
    Searching search = new Searching();
    boolean expensesLimit = false;
    int batasPengeluaran;

    public void setBatasPengeluaran() {
        Scanner in = new Scanner(System.in);
        int input = 0;
        System.out.println("<<<\t\tMenu Atur Batas Pengeluaran\t\t>>>");
        System.out.print("Masukkan Nominal Batas Pengeluaran (Input \"0\" jika ingin membatalkan) : Rp ");
        try {
            input = in.nextInt();
        } catch (InputMismatchException e) {
            System.err.println(e);
            System.out.println("Error, silahkan ulangi dari awal\n");
            return;
        }
        if (input != 0 && input > 0) {
            batasPengeluaran = input;
            expensesLimit = true;
        } else {
            batasPengeluaran = 0;
            expensesLimit = false;
            System.out.println("Batas pengeluaran telah diatur ke Rp 0");
            System.out.println();
            return;
        }
        System.out.printf("Batas pengeluaran telah sukses diatur ke Rp %,3d", batasPengeluaran);
        System.out.println("\n");
    }

    public boolean getexpensesLimit() {
        return expensesLimit;
    }

    public int getBatasPengeluaran() {
        return batasPengeluaran;
    }

    public void displayExpenses() {
        while (true) {
            Scanner masuk = new Scanner(System.in);
            Scanner scan = new Scanner(System.in);
            int input = 0;
            System.out.println("<<<\t\tMenu List Pengeluaran\t\t>>>");
            System.out.println("List Pengeluaran saat ini : \n");
            printExpenses();
            System.out.printf("Total Pengeluaran : Rp %,3d", totalPengeluaran());
            System.out.println("\n\nPilihan Menu : \n1. Urutkan harga secara Ascending\n2. Urutkan harga secara Decending \n3. Cari pengeluaran berdasarkan nama\n4. Keluar dari menu");
            System.out.print("Pilih Menu : ");
            try {
                input = masuk.nextInt();
            } catch (InputMismatchException e) {
                System.err.println(e);
                System.out.println("Error silahkan ulangi dari awal\n");
                return;
            }
            switch (input) {
                case 1 -> {
                    int[] jumlahPengeluaranCopy = new int[LIMIT];
                    String[] namaPengeluaranCopy = new String[LIMIT];
                    System.arraycopy(jumlahPengeluaran, 0, jumlahPengeluaranCopy, 0, jumlahPengeluaran.length);
                    System.arraycopy(namaPengeluaran, 0, namaPengeluaranCopy, 0, namaPengeluaran.length);
                    sorting.bubbleSortAscending(jumlahPengeluaran);
                    matchingPosition(jumlahPengeluaranCopy, namaPengeluaranCopy);
                    System.out.println("Daftar berhasil disortir secara Ascending..\n");
                    break;
                }
                case 2 -> {
                    int[] jumlahPengeluaranCopy = new int[LIMIT];
                    String[] namaPengeluaranCopy = new String[LIMIT];
                    System.arraycopy(jumlahPengeluaran, 0, jumlahPengeluaranCopy, 0, jumlahPengeluaran.length);
                    System.arraycopy(namaPengeluaran, 0, namaPengeluaranCopy, 0, namaPengeluaran.length);
                    sorting.quickSortDescending(jumlahPengeluaran);
                    matchingPosition(jumlahPengeluaranCopy, namaPengeluaranCopy);
                    System.out.println("Daftar berhasil disortir secara Descending..\n");
                    break;
                }
                case 3 -> {
                    System.out.print("Masukkan Kata Kunci yang ingin dicari : ");
                    String param = scan.nextLine();
                    System.out.println("Hasil Pencarian : ");
                    System.out.println("No | \tNama Pemasukan\t | \tJumlah Pengeluaran");
                    search.SequentialSearch(namaPengeluaran, jumlahPengeluaran, param);
                    System.out.println();
                }
                case 4 -> {
                    System.out.println();
                    return;
                }
                default -> {
                    System.err.println("Input pilihan yang valid!\n");
                }
            }
        }
    }

    public void matchingPosition(int[] jumlahPengeluaranCopy, String[] namaPengeluaranCopy) {
        for (int i = 0; i < jumlahPengeluaran.length; i++) {
            for (int j = 0; j < namaPengeluaran.length; j++) {
                if (jumlahPengeluaran[i] == jumlahPengeluaranCopy[j]) {
                    namaPengeluaran[i] = namaPengeluaranCopy[j];
                }
            }
        }
    }

    public void deleteExpenses() {
        Scanner in = new Scanner(System.in);
        int nomorHapus = 0;
        System.out.println("<<<\t\tMenu Hapus Pengeluaran\t\t>>>");
        System.out.println("List pengeluaran saat ini\n");
        printExpenses();
        System.out.print("\nPilih nomor pengeluaran yang ingin dihapus : ");
        try {
            nomorHapus = in.nextInt();
        } catch (Exception e) {
            System.err.println(e);
            System.out.println("Error, silahkan ulang dari awal\n");
            return;
        }
        if (nomorHapus > n || nomorHapus <= 0) {
            System.err.println("Error, harap masukkan nomor data yang benar!\n");
            return;
        }
        rearrangeExpenses(nomorHapus - 1);
        System.out.println("Data berhasil dihapus!\n");
    }

    public void rearrangeExpenses(int index) {
        for (int i = index; i < n; i++) {
            if (i == n - 1) {
                namaPengeluaran[n - 1] = null;
                jumlahPengeluaran[n - 1] = 0;
                n--;
                return;
            }
            namaPengeluaran[i] = namaPengeluaran[i + 1];
            jumlahPengeluaran[i] = jumlahPengeluaran[i + 1];
        }
    }

    public void printExpenses() {
        int no = 1;
        System.out.println("No | \tNama Pengeluaran\t | \tJumlah Pengeluaran");
        for (int i = 0; i < jumlahPengeluaran.length; i++) {
            if (namaPengeluaran[i] != null && jumlahPengeluaran[i] != 0) {
                System.out.println(no + ".  \t" + namaPengeluaran[i] + "\t  \t\t\tRp " + jumlahPengeluaran[i]);
                no++;
            }
        }
    }

    public void addExpenses() {
        Scanner in = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        int jmlPengeluaran;
        String name;
        System.out.println("<<<\t\tMenu Tambah Pengeluaran\t\t>>>");
        System.out.print("Nama Pengeluaran : ");
        name = in.nextLine();
        System.out.print("Jumlah Pengeluaran : ");
        try {
            jmlPengeluaran = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(e);
            System.err.println("Error, silahkan masukkan ulang data");
            enter();
            return;
        }
        namaPengeluaran[n] = name;
        jumlahPengeluaran[n] = jmlPengeluaran;
        n++;
        System.out.println("Data berhasil ditambahkan!");
        enter();
    }

    public int totalPengeluaran() {
        int total = 0;
        for (int i : jumlahPengeluaran) {
            total += i;
        }
        return total;
    }

    public void enter() {
        try {
            System.in.read();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}

class Pemasukan {
    private final int LIMIT = 20;
    private String[] namaPemasukan = new String[LIMIT];
    private int[] jumlahPemasukan = new int[LIMIT];
    private int n = 0;
    Sorting sorting = new Sorting();
    Searching search = new Searching();

    public void displayIncome() {
        while (true) {
            Scanner masuk = new Scanner(System.in);
            Scanner scan = new Scanner(System.in);
            int input = 0;
            System.out.println("<<<\t\tMenu List Pemasukan\t\t>>>");
            System.out.println("List Pemasukan saat ini : \n");
            printIncome();
            System.out.printf("Total Pemasukan : Rp %,3d", totalPemasukan());
            System.out.println("\n\nPilihan Menu : \n1. Urutkan harga secara Ascending\n2. Urutkan harga secara Decending \n3. Cari pemasukan berdasarkan nama\n4. Keluar dari menu");
            System.out.print("Pilih Menu : ");
            try {
                input = masuk.nextInt();
            } catch (InputMismatchException e) {
                System.err.println(e);
                System.out.println("Error silahkan ulangi dari awal\n");
                return;
            }
            switch (input) {
                case 1 -> {
                    int[] jumlahPemasukanCopy = new int[LIMIT];
                    String[] namaPemasukanCopy = new String[LIMIT];
                    System.arraycopy(jumlahPemasukan, 0, jumlahPemasukanCopy, 0, jumlahPemasukan.length);
                    System.arraycopy(namaPemasukan, 0, namaPemasukanCopy, 0, namaPemasukan.length);
                    sorting.bubbleSortAscending(jumlahPemasukan);
                    matchingPosition(jumlahPemasukanCopy, namaPemasukanCopy);
                    System.out.println("Daftar berhasil disortir secara Ascending..\n");
                    break;
                }
                case 2 -> {
                    int[] jumlahPemasukanCopy = new int[LIMIT];
                    String[] namaPemasukanCopy = new String[LIMIT];
                    System.arraycopy(jumlahPemasukan, 0, jumlahPemasukanCopy, 0, jumlahPemasukan.length);
                    System.arraycopy(namaPemasukan, 0, namaPemasukanCopy, 0, namaPemasukan.length);
                    sorting.quickSortDescending(jumlahPemasukan);
                    matchingPosition(jumlahPemasukanCopy, namaPemasukanCopy);
                    System.out.println("Daftar berhasil disortir secara Descending..\n");
                    break;
                }
                case 3 -> {
                    System.out.print("Masukkan Kata Kunci yang ingin dicari : ");
                    String param = scan.nextLine();
                    System.out.println("Hasil Pencarian : ");
                    System.out.println("No | \tNama Pemasukan\t | \tJumlah Pengeluaran");
                    search.SequentialSearch(namaPemasukan, jumlahPemasukan, param);
                    System.out.println();
                }
                case 4 -> {
                    System.out.println();
                    return;
                }
                default -> {
                    System.err.println("Input pilihan yang valid!\n");
                }
            }
        }
    }

    public void matchingPosition(int[] jumlahPemasukanCopy, String[] namaPemasukanCopy) {
        for (int i = 0; i < jumlahPemasukan.length; i++) {
            for (int j = 0; j < namaPemasukan.length; j++) {
                if (jumlahPemasukan[i] == jumlahPemasukanCopy[j]) {
                    namaPemasukan[i] = namaPemasukanCopy[j];
                }
            }
        }
    }

    public void deleteIncome() {
        Scanner in = new Scanner(System.in);
        int nomorHapus = 0;
        System.out.println("<<<\t\tMenu Hapus Pemasukan\t\t>>>");
        System.out.println("List pemasukan saat ini\n");
        printIncome();
        System.out.print("\nPilih nomor pemasukan yang ingin dihapus : ");
        try {
            nomorHapus = in.nextInt();
        } catch (Exception e) {
            System.err.println(e);
            System.out.println("Error, silahkan ulang dari awal\n");
            return;
        }
        if (nomorHapus > n || nomorHapus <= 0) {
            System.err.println("Error, harap masukkan nomor data yang benar!\n");
            return;
        }
        rearrangeIncome(nomorHapus - 1);
        System.out.println("Data berhasil dihapus!\n");
    }

    public void rearrangeIncome(int index) {
        for (int i = index; i < n; i++) {
            if (i == n - 1) {
                namaPemasukan[n - 1] = null;
                jumlahPemasukan[n - 1] = 0;
                n--;
                return;
            }
            namaPemasukan[i] = namaPemasukan[i + 1];
            jumlahPemasukan[i] = jumlahPemasukan[i + 1];
        }
    }

    public void printIncome() {
        int no = 1;
        System.out.println("No | \tNama Pemasukan\t | \tJumlah Pemasukan");
        for (int i = 0; i < jumlahPemasukan.length; i++) {
            if (namaPemasukan[i] != null && jumlahPemasukan[i] != 0) {
                System.out.println(no + ".  \t" + namaPemasukan[i] + "\t  \t\t\tRp " + jumlahPemasukan[i]);
                no++;
            }
        }
    }

    public void addIncome() {
        Scanner in = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        int jmlPemasukan;
        String name;
        System.out.println("<<<\t\tMenu Tambah Pemasukan\t\t>>>");
        System.out.print("Nama Pemasukan : ");
        name = in.nextLine();
        System.out.print("Jumlah Pemasukan : ");
        try {
            jmlPemasukan = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(e);
            System.err.println("Error, silahkan masukkan ulang data");
            enter();
            return;
        }
        namaPemasukan[n] = name;
        jumlahPemasukan[n] = jmlPemasukan;
        n++;
        System.out.println("Data berhasil ditambahkan!");
        enter();
    }

    public int totalPemasukan() {
        int total = 0;
        for (int i : jumlahPemasukan) {
            total += i;
        }
        return total;
    }

    public void enter() {
        try {
            System.in.read();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}

public class MoneyManagement {
    static final int LIMIT = 20;
    static String[] namaPengeluaran = new String[LIMIT];
    static int[] jumlahPengeluaran = new int[LIMIT];
    static int n = 0;
    public static void main(String[] args) {
        Pengeluaran pengeluaran = new Pengeluaran();
        Pemasukan pemasukan = new Pemasukan();
        while (true) {
            int choice = 0;
            Scanner sc = new Scanner(System.in);
            System.out.println("<<<\t\tProgram Manajemen Keuangan Pribadi\t\t>>>");
            System.out.printf("Total Pengeluaran Saat ini : Rp %,3d", pengeluaran.totalPengeluaran());
            System.out.println();
            System.out.printf("Total Pemasukan Saat ini : Rp %,3d", pemasukan.totalPemasukan());
            System.out.println();
            if (pengeluaran.getexpensesLimit() == true) {
                System.out.printf("Batas Pengeluaran saat ini : Rp %,3d", pengeluaran.getBatasPengeluaran());
                System.out.println();
            }
            if (pengeluaran.totalPengeluaran() > pengeluaran.batasPengeluaran) {
                System.out.println("Peringatan.. Pengeluaran Anda saat ini telah melebihi batas");
            }
            System.out.println(
                    "Pilihan Menu : \n1. Tambah list pengeluaran\n2. Hapus List Pengeluaran\n3. Tampilkan List Pengeluaran\n4. Tambah list pemasukan\n5. Hapus list pemasukan\n6. Tampilkan list pemasukan\n7. Atur Batas Pengeluaran\n8. Keluar dari program");
            System.out.print("Select Menu : ");
            try {
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println(e);
            }
            switch (choice) {
                case 1 -> {
                    System.out.println();
                    pengeluaran.addExpenses();
                    break;
                }
                case 2 -> {
                    System.out.println();
                    pengeluaran.deleteExpenses();
                    break;
                }
                case 3 -> {
                    System.out.println();
                    pengeluaran.displayExpenses();
                    break;
                }
                case 4 -> {
                    System.out.println();
                    pemasukan.addIncome();
                    break;
                }
                case 5 -> {
                    System.out.println();
                    pemasukan.deleteIncome();
                    break;
                }
                case 6 -> {
                    System.out.println();
                    pemasukan.displayIncome();
                    break;
                }
                case 7 -> {
                    System.out.println();
                    pengeluaran.setBatasPengeluaran();
                    break;
                }
                case 8 -> {
                    System.out.println("Keluar dari program...");
                    System.exit(0);
                }
                default -> {
                    System.err.println("Harap masukkan input yang benar!");
                    enter();
                }
            }
        }
    }

    public static void enter() {
        try {
            System.in.read();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
