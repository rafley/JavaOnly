package UTP;

import java.util.Scanner;

public class pemesanan {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scanner inputLine = new Scanner(System.in);
        dataPenyewaan sewa = new dataPenyewaan();
        pesanan pesan = new pesanan();
        int pilihan = 0, index = 0, indexCari = 0;
        String jawaban = " ", cari = " ", barang = " ";
        String pembeli = " ", beli = "";
        boolean cek = true, cekBeli = false;
        System.out.println("=====OTIC BEACH RENTAL STORE=====");
        do
        {
            System.out.println("1. Lihat barang\n2. Pesan Barang\n3.Sorting barang");
            System.out.println("4. Cari barang\n5. Data pesanan\n6.Keluar toko");
            System.out.print("Pilih menu : ");
            pilihan = input.nextInt();
            if (pilihan == 1)
            {
                sewa.pembatas();
                System.out.println("Barang yang tersedia :");
                for (int i = 0; i < sewa.barangSewa.length;
                        i++)
                {
                    System.out.print((i + 1) + "."
                            + sewa.barangSewa[i]
                            + " Rp." + sewa.hargaSewa[i]
                            + "\n");
                }
                sewa.pembatas();
            } else if (pilihan == 2)
            {
                sewa.pembatas();
                System.out.println("Barang yang tersedia :");
                for (int i = 0; i < sewa.barangSewa.length; i++)
                {
                    System.out.print((i + 1) + "." + sewa.barangSewa[i]
                            + " Rp." + sewa.hargaSewa[i]
                            + "\n");
                }
                System.out.print("Nama pembeli : ");
                pembeli = inputLine.nextLine();
                pesan.pembeli[index] = pembeli;
                System.out.print("Barang yang dibeli : ");
                beli = inputLine.nextLine();
                for (int i = 0; i < sewa.barangSewa.length;
                        i++)
                {
                    if (beli.equalsIgnoreCase(sewa.barangSewa[i]))
                    {
                        pesan.barangPesanan[index]
                                = sewa.barangSewa[i];
                        pesan.hargaTotal[index]
                                = sewa.hargaSewa[i];
                        cekBeli = true;
                        break;
                    }
                }
                if (cekBeli == false)
                {
                    System.out.println("Barang tidak tersedia / ditemukan!");
                    sewa.pembatas();
                } else
                {
                    index++;
                    System.out.println("Data telah di input!");
                    sewa.pembatas();
                    pembeli = " ";
                    beli = " ";
                    cekBeli = false;
                }
            } else if (pilihan == 3)
            {
                System.out.println(
                        "Urutan barang sekarang : ");
                for (int i = 0; i < sewa.barangSewa.length;
                        i++)
                {
                    System.out.print((i + 1) + "."
                            + sewa.barangSewa[i]
                            + " Rp." + sewa.hargaSewa[i]
                            + "\n");
                }
                sewa.pembatas();
                System.out.println("1. Nama\n2. Harga");
                System.out.print("Ingin melihat barang sesuai ? (Nama / harga) : ");
                jawaban = inputLine.nextLine();
                if (jawaban.equalsIgnoreCase("nama"))
                {
                    System.out.println("1. Ascending(a-z)\n2.Descending(z - a) ");
                    System.out.print("Diurutkan secara?(asc / desc ): ");
                    jawaban = inputLine.nextLine();
                    if (jawaban.equalsIgnoreCase("asc"))
                    {
                        sortNamaAsc nmAsc = new sortNamaAsc();
                        nmAsc.getBubSort(sewa.barangSewa,
                                sewa.hargaSewa);
                        System.out.println(
                                "Selesai mengubah list barang !");
                        sewa.pembatas();
                    } else if (jawaban.equalsIgnoreCase("desc"))
                    {
                        sortNamaDesc nmDesc = new sortNamaDesc();
                        nmDesc.getBubSort(sewa.barangSewa,
                                sewa.hargaSewa);
                        System.out.println(
                                "Selesai mengubah list barang!");
                        sewa.pembatas();
                    } else
                    {
                        System.out.println("Pilihan tidak tersedia!\nKembali ke menu utama ....");
                        sewa.pembatas();
                    }
                } else if (jawaban.equalsIgnoreCase("harga"))
                {
                    System.out.println("1. Ascending(Rp.0- Rp.n)\n2.Descending(Rp.n - Rp .0)");
                    System.out.print("Diurutkan secara? (asc / desc): ");
                    jawaban = inputLine.nextLine();
                    if (jawaban.equalsIgnoreCase("asc"))
                    {
                        sortHargaAsc hrgAsc = new sortHargaAsc();
                        hrgAsc.getQuickSort(sewa.hargaSewa,
                                sewa.barangSewa);
                        System.out.println(
                                "Selesai mengubah list barang!");
                        sewa.pembatas();
                    } else if (jawaban.equalsIgnoreCase("desc"))
                    {
                        sortHargaDesc hrgDesc = new sortHargaDesc();
                        hrgDesc.getQuickSort(sewa.hargaSewa,
                                sewa.barangSewa);
                        System.out.println("Selesai mengubah list barang!");
                        sewa.pembatas();
                    } else
                    {
                        System.out.println("Pilihan tidak tersedia!\nKembali ke menu utama ....");
                        sewa.pembatas();
                    }
                }
            } else if (pilihan == 4)
            {
                System.out.print("Masukkan nama barang : ");
                cari = inputLine.nextLine();
                for (int i = 0; i < sewa.barangSewa.length;
                        i++)
                {
                    if (cari.equalsIgnoreCase(sewa.barangSewa[i]))
                    {
                        barang = sewa.barangSewa[i];
                        indexCari = i;
                        break;
                    }
                }
                if (barang.equalsIgnoreCase(" "))
                {
                    System.out.println("Barang tidak ditemukan !");
                    sewa.pembatas();
                } else
                {
                    System.out.print("Barang "
                            + sewa.barangSewa[indexCari] + " ditemukan pada index ke-"
                            + indexCari);
                    System.out.println(" dengan harga Rp."
                            + sewa.hargaSewa[indexCari]);
                    sewa.pembatas();
                    barang = " ";
                }
            } else if (pilihan == 5)
            {
                if (index == 0)
                {
                    System.out.println("Tidak terdapat data!");
                    sewa.pembatas();
                } else
                {
                    sewa.pembatas();
                    System.out.println(
                            "Berikut data yang tercatat: ");
                    for (int i = 0; i < index; i++)
                    {
                        System.out.println("Nama : "
                                + pesan.pembeli[i]);
                        System.out.println("Barang Sewaan : "
                                + pesan.barangPesanan[i]);
                        System.out.println("Harga : Rp."
                                + pesan.hargaTotal[i]);
                        sewa.pembatas();
                    }
                }
            } else if (pilihan == 6)
            {
                System.out.println("Terima kasih telah datang!");
                cek = false;
            } else
            {
                System.out.println("Menu tidak tersedia!");
            }
        } while (cek);
    }
}
