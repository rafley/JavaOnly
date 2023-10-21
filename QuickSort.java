/*
 * Click nbfs://nbhost/SystemFileSystem/sementaralates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/sementaralates/Classes/Main.java to edit this sementaralate
 */
package ASD;

/**
 *
 * @author User
 */
public class QuickSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] nama = {"Yudi","Bima","Anhar","Biji","Sasha","Verdania","Cestia","Fauzan","Nilou","Cecilia"};
        int[] array = {8, 2, 5, 3, 9, 4, 7, 6, 1};

        quickSort(array, 0, array.length - 1);
        quickSortString(nama, 0, nama.length-1);
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println("");
        for (String i : nama) {
            System.out.println(i);
        }
    }

    private static void quickSort(int[] array, int awal, int akhir) {

        if (akhir <= awal) {
            return; //base case
        }
        int pivot = helper(array, awal, akhir);
        quickSort(array, awal, pivot - 1);
        quickSort(array, pivot + 1, akhir);
    }

    private static int helper(int[] array, int awal, int akhir) {

        int pivot = array[akhir];
        int i = awal - 1;

        for (int j = awal; j <= akhir; j++) {
            if (array[j] < pivot) {
                i++;
                int sementara = array[i];
                array[i] = array[j];
                array[j] = sementara;
            }
        }
        i++;
        int sementara = array[i];
        array[i] = array[akhir];
        array[akhir] = sementara;

        return i;
    }
    private static void quickSortString(String[] array, int awal, int akhir) {

        if (akhir <= awal) {
            return; //base case
        }
        int pivot = helperString(array, awal, akhir);
        quickSortString(array, awal, pivot - 1);
        quickSortString(array, pivot + 1, akhir);
    }

    private static int helperString(String[] array, int awal, int akhir) {

        String pivot = array[akhir];
        int i = awal - 1;

        for (int j = awal; j <= akhir; j++) {
            if (array[j].compareTo(pivot) < 0) {
                i++;
                String sementara = array[i];
                array[i] = array[j];
                array[j] = sementara;
            }
        }
        i++;
        String sementara = array[i];
        array[i] = array[akhir];
        array[akhir] = sementara;

        return i;
    }
}
