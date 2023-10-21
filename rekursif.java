package Rekursif;

import java.util.Scanner;

public class rekursif {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int nilai = 0,jumlah = 0, jmlFaktorial = 0;
        System.out.print("Masukkan nilai : ");
        nilai = input.nextInt();
        System.out.println("Nilai yang dimasukkan : " + nilai);
        rekursif(nilai);
        jumlah = jmlNilai(nilai);
        System.out.println("Total nilai : " + jumlah);
        jmlFaktorial = faktorial(nilai);
        System.out.println("Total faktorial : " + jmlFaktorial);
    }

    static void rekursif(int param) {
        System.out.println("Nilai : " + param);
        if (param == 0)
        {
            return;
        }
        param--;
        rekursif(param);

    }

    static int jmlNilai(int angka) {
        if (angka == 0)
        {
            return angka;
        }
        return angka + jmlNilai(angka-1);
    }
    
    static int faktorial(int angka) {
        if (angka == 1)
        {
            return 1;
        }
        if (angka == 0)
        {
            return 1;
        }
        return angka * faktorial(angka-1);
    }
}
