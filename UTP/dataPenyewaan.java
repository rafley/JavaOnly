package UTP;

public class dataPenyewaan {

    String[] barangSewa =
    {
        "Payung Pantai", "Kursi Pantai", "Papan Selancar",
        "Goggle Renang",
        "Perahu Kano", "Set Mainan ", "Pelampung", "Set BBQ",
        "Alat Snorkeling", "Speedboat", "Sewa Kapal", "Alat Mancing"
    };
    int[] hargaSewa =
    {
        50000, 30000, 100000, 20000, 150000, 10000, 25000,
        200000, 75000, 300000, 400000, 60000
    };

    void pembatas() {

        System.out.println("\n========================================");
 }
}
class pesanan {

    String[] pembeli = new String[1000];
    String[] barangPesanan = new String[1000];
    int[] hargaTotal = new int[1000];
}

class cariBarang {

    public int sequentialHarga(int[] harga, int target) {
        for (int i = 0; i < harga.length; i++)
        {
            if (i == target)
            {
                return harga[i];
            }
        }
        return -1;
    }

    public String sequentialNama(String[] barang, String target) {
        for (int i = 0; i < barang.length; i++)
        {
            if (barang[i].equalsIgnoreCase(target))
            {
                return barang[i];
            }
        }
        return target = "null";
    }
}

class sortHargaAsc {

    public void getQuickSort(int[] arrHarga, String[] arrBarang) {
        quickSort(arrHarga, arrBarang, 0, arrHarga.length
                - 1);
    }

    private void quickSort(int[] arrHarga, String[] arrBarang,
            int low, int high) {
        if (low < high)
        {
            int pivotIndex = partition(arrHarga, arrBarang,
                    low, high);
            quickSort(arrHarga, arrBarang, low, pivotIndex
                    - 1);
            quickSort(arrHarga, arrBarang, pivotIndex + 1,
                    high);
        }
    }

    private int partition(int[] arrHarga, String[] arrBarang,
            int low, int high) {
        int pivot = arrHarga[high];
        int i = low - 1;
        for (int j = low; j < high; j++)
        {
            if (arrHarga[j] < pivot)
            {
                i++;
                swap(arrHarga, arrBarang, i, j);
            }
        }
        swap(arrHarga, arrBarang, i + 1, high);
        return i + 1;
    }

    private void swap(int[] arrHarga, String[] arrBarang, int i, int j) {
        int temp = arrHarga[i];
        arrHarga[i] = arrHarga[j];
        arrHarga[j] = temp;
        String temp2 = arrBarang[i];
        arrBarang[i] = arrBarang[j];
        arrBarang[j] = temp2;
    }
}

class sortHargaDesc {

    public void getQuickSort(int[] arrHarga, String[] arrBarang) {
        quickSort(arrHarga, arrBarang, 0, arrHarga.length
                - 1);
    }

    private void quickSort(int[] arrHarga, String[] arrBarang,
            int low, int high) {
        if (low < high)
        {
            int pivotIndex = partition(arrHarga, arrBarang,
                    low, high);
            quickSort(arrHarga, arrBarang, low, pivotIndex
                    - 1);
            quickSort(arrHarga, arrBarang, pivotIndex + 1,
                    high);
        }
    }

    private int partition(int[] arrHarga, String[] arrBarang,
            int low, int high) {
        int pivot = arrHarga[high];
        int i = low - 1;
        for (int j = low; j < high; j++)
        {
            if (arrHarga[j] > pivot)
            {
                i++;
                swap(arrHarga, arrBarang, i, j);
            }
        }
        swap(arrHarga, arrBarang, i + 1, high);
        return i + 1;
    }

    private void swap(int[] arrHarga, String[] arrBarang, int i, int j) {
        int temp = arrHarga[i];
        arrHarga[i] = arrHarga[j];
        arrHarga[j] = temp;
        String temp2 = arrBarang[i];
        arrBarang[i] = arrBarang[j];
        arrBarang[j] = temp2;
    }
}

class sortNamaAsc {

    public static void getBubSort(String[] barang, int[] harga) {
        int n = barang.length;
        for (int i = 0; i < n - 1; i++)
        {
            for (int j = 0; j < n - 1 - i; j++)
            {
                if (barang[j].compareTo(barang[j + 1]) > 0)
                {
                    String tempNama = barang[j];
                    barang[j] = barang[j + 1];
                    barang[j + 1] = tempNama;
                    int tempharga = harga[j];
                    harga[j] = harga[j + 1];
                    harga[j + 1] = tempharga;
                }
            }
        }
    }
}

class sortNamaDesc {

    public static void getBubSort(String[] barang, int[] harga) {
        int n = barang.length;
        for (int i = 0; i < n - 1; i++)
        {
            for (int j = 0; j < n - 1 - i; j++)
            {
                if (barang[j].compareTo(barang[j + 1]) < 0)
                {
                    String tempNama = barang[j];
                    barang[j] = barang[j + 1];
                    barang[j + 1] = tempNama;
                    int tempharga = harga[j];
                    harga[j] = harga[j + 1];
                    harga[j + 1] = tempharga;
                }
            }
        }
    }
}
