import java.util.*;

public class Matriks7 {
    public static void main(String[] args) {
        Scanner inputUser = new Scanner(System.in);

        System.out.println("========== PROGRAM OPERASI MATRIKS ===========");
        System.out.println("PROGRAM INI DIBUAT OLEH KELOMPOK 7");
        System.out.println("BERIKUT ANGGOTANYA :");
        System.out.println(">> DANU SUKO HANDIYANTO_1512623038 (KETUA)");
        System.out.println(">> DEFA RAHMATI RIFQI RAMADHANI_1512623005");
        System.out.println(">> FAISAL AZHAR SALAM_1512623055");
        System.out.println(">> MOHAMMAD ASYIF RAZA_1512623030");
        System.out.println(">> RURI FEBRIYANTI_1512623031\n");

        // DEKLARASI VARIABLE
        Scanner scanner = new Scanner(System.in);

        boolean reset0 = true;
        boolean reset1 = true;
        boolean reset2 = true;

        int[][] matA;
        int[][] matB;
        int[][] matC;

        int operasi1;

        while (reset0 == true) {

            // MENGAMBIL NILAI MATRIKS DARI USER
            matA = buatMatriks('A');
            System.out.println();
            matB = buatMatriks('B');

            reset1 = true;
            while (reset1 == true) {

                // PRINT MATRIKS A DAN SIFATNYA
                System.out.println();
                System.out.println("===== MATRIKS A =====");
                printMatriks(matA);
                defineMat(matA);

                // PRINT MATRIKS B DAN SIFATNYA
                System.out.println();
                System.out.println("===== MATRIKS B =====");
                printMatriks(matB);
                defineMat(matB);
                System.out.println();

                // MENENTUKAN KONDISI SESUAI ORDO MATRIKS
                if (isTambahKurang(matA,matB)) {
                    System.out.println("PILIH OPERASI MATRIKS :");
                    // UNTUK KONDISI PENJUMLAHAN
                    System.out.println("A + B = C (KETIK '1' LALU ENTER)");
                    // UNTUK KONDISI PENGURANGAN
                    System.out.println("A - B = C (KETIK '2' LALU ENTER)");
                    // UNTUK KONDISI PERKALIAN
                    System.out.println("A * B = C (KETIK '3' LALU ENTER)");
                } else if (isPerkalian(matA, matB)){
                    System.out.println("HANYA ADA PERKALIAN DIKARENAKAN KONDISI MATRIKS");
                    System.out.println("A * B = C (KETIK '3' LALU ENTER)");
                } else {
                    System.out.println("ORDO TIDAK SESUAI");
                    break;
                }

                while (reset2 == true){
                    System.out.print("MASUKKAN PILIHAN : ");
                    operasi1 = inputUser.nextInt();

                    //JIKA MEMASUKKAN '1' (PENJUMLAHAN)
                    if (operasi1 == 1){
                        matC = tambahMatriks(matA, matB);
                        System.out.println();
                        System.out.println("HASIL PENJUMLAHAN MATRIKS A DAN B :");
                        printMatriks(matC);
                        defineMat(matC);
                        System.out.println();
                        break;
                    }
                    //JIKA MEMASUKKAN '2' (PENGURANGAN)
                    else if (operasi1 == 2) {
                        matC = kurangMatriks(matA, matB);
                        System.out.println();
                        System.out.println("HASIL PENGURANGAN MATRIKS A DAN B :");
                        printMatriks(matC);
                        defineMat(matC);
                        System.out.println();
                        break;
                    }
                    //JIKA MEMASUKKAN '3' (PERKALIAN)
                    else if (operasi1 == 3) {
                        matC = kaliMatriks(matA, matB);
                        System.out.println();
                        System.out.println("HASIL PERKALIAN MATRIKS A DAN B :");
                        printMatriks(matC);
                        defineMat(matC);
                        System.out.println();
                        break;
                    }
                    //JIKA PILIHAN TIDAK TERSEDIA
                    else {
                        System.out.println("PILIHAN TIDAK SESUAI, SILAHKAN PILIH ULANG");
                    }
                }

                System.out.println("BUAT MATRIKS A DAN B BARU (KETIK '1' LALU ENTER)");
                System.out.println("QUIT (KETIK '2' LALU ENTER)");
                System.out.print("PILIH TINDAKAN DI ATAS INI :");
                operasi1 = scanner.nextInt();
                System.out.println();

                if (operasi1 == 1) {
                    reset0 = true;
                    reset1 = false;
                } else if (operasi1 == 2) {
                    reset0 = false;
                    reset1 = false;
                }
            }

        }
        scanner.close();
        System.out.println("PROGRAM TELAH SELESAO !!!");
    }

    // ===== PRINT MATRIKS =====
    private static void printMatriks(int[][] x) {
        // >> BUAT FOR DENGAN PANJANG i SEPANJANG JUMLAH INDEX ARRAY x
        // >> BUAT FOR DI DALAM FOR PERTAMA DENGAN PANJANG j SEPANJANG JUMLAH INDEX i PADA ARRAY x
        // >> MENAMPILKAN BARIS KE-i DAN KOLOM KE-j PADA ARRAY x
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {
                System.out.print(x[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // ===== INPUT USER =====
    private static int[][] buatMatriks(char x){
        // >> AMBIL INPUT DARI USER
        // >> INPUT DIMASUKKAN KE VARIABEL BARIS DAN KOLOM
        // >> TAMPILKAN JUMLAH KOLOM DAN BARIS
        Scanner inputUser = new Scanner(System.in);
        System.out.println("=== MENENTUKAN MATRIKS " + x + " ===");
        System.out.println("SILAHKAN MASUKKAN ORDO MATRIKS SESUAI KEINGINAN ANDA");
        System.out.print("MASUKKAN JUMLAH BARIS UNTUK MATRIKS " + x + ": ");
        int baris = inputUser.nextInt();
        System.out.print("MASUKKAN JUMLAH KOLOM UNTUK MATRIKS " + x + ": ");
        int kolom = inputUser.nextInt();
        System.out.println("MATRIKS " + x + " BER-ORDO " + baris + " X " + kolom + ".\n");
        // >> BUAT FOR DENGAN PANJANG i SEPANJANG JUMLAH INDEX ARRAY temp
        // >> BUAT FOR DI DALAM FOR PERTAMA DENGAN PANJANG j SEPANJANG JUMLAH INDEX ARRAY temp
        // >> MENAMPILKAN NILAI ELEMENT SESUAI BARIS DAN KOLOM
        // >> MENGAMBIL NILAI INPUT USER UNTUK SETIAP ELEMENT
        // >> MENAMPILKAN MATRIKS
        // >> MENGEMBALIKAN NILAI
        int[][] temp = new int[baris][kolom];
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                System.out.println("MASUKKAN NILAI ELEMENT PADA BARIS " + (i + 1) + " KOLOM " + (j + 1) + " UNTUK MATRIKS " + x + ":");
                temp[i][j] = inputUser.nextInt();
                printMatriks(temp);
            }
        } return temp;
    }

    // ===== KONDISI MATRIKS =====
    // UNTUK KONDISI PENJUMLAHAN DAN PENGURANGAN
    private static boolean isTambahKurang(int [][]x, int[][]y){
        // >> JIKA JUMLAH BARIS DAN KOLOM MATRIKS x SAMA DENGAN MATRIKS y MAKA RETURN TRUE
        // >> JIKA TIDAK MAKA RETURN FALSE
        if(x.length == y.length && x[0].length == y[0].length){
            return true;
        } else{
            return false;
        }
    }
    // UNTUK KONDISI PERKALIAN
    private static boolean isPerkalian(int [][]x, int[][]y){
        // >> JIKA JUMLAH INDEX KOLOM MATRIKS x SAMA DENGAN JUMLAH INDEX BARIS MATRIKS y MAKA RETURN TRUE
        // >> JIKA TIDAK MAKA RETURN FALSE
        if(x[0].length != y.length){
            return false;
        } else{
            return true;
        }
    }

    // ===== OPERASI MATRIKS =====
    // PENJUMLAHAN
    private static int[][] tambahMatriks(int[][] matriks1, int[][] matriks2) {
        // >> MENDEKLARASIKAN MATRIKS HASIL
        // >> MENAMBAHKAN SETIAP ELEMENT PADA SETIAP BARIS DAN KOLOM MENGGUNAKAN FOR LOOP
        // >> RETURN HASIL
        int[][] result = new int[matriks1.length][matriks1[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = matriks1[i][j] + matriks2[i][j];
            }
        }
        return result;
    }
    // PENGURANGAN
    private static int[][] kurangMatriks(int[][] matriks1, int[][] matriks2) {
        // >> MENDEKLARASIKAN MATRIKS HASIL
        // >> MENGURANGKAN SETIAP ELEMENT PADA SETIAP BARIS DAN KOLOM MENGGUNAKAN FOR LOOP
        // >> RETURN HASIL
        int[][] result = new int[matriks1.length][matriks1[0].length];
        for (int i = 0; i < matriks1.length; i++) {
            for (int j = 0; j < matriks1[0].length; j++) {
                result[i][j] = matriks1[i][j] - matriks2[i][j];
            }
        }
        return result;
    }
    // PERKALIAN
    private static int[][] kaliMatriks(int[][] x, int[][] y) {
        int xRows = x.length;
        int xCols = x[0].length;
        int yRows = y.length;
        int yCols = y[0].length;

        int[][] result = new int[xRows][yCols];
        // >> LOOP LUAR (i) BERJALAN MELALUI SETIAP BARIS DARI MATRIKS x.
        // >> LOOP DALAM (j) BERJALAN MELALUI SETIAP KOLOM DARI MATRIKS y.
        // >> LOOP DALAM SEKALI LAGI (k) BERJALAN MELALUI SETIAP KOLOM DARI MATRIKS x ATAU SETIAP BARIS DARI MATRIKS y.
        // >> PADA SETIAP PENGULANGAN, ELEMEN result[i][j] DIISI DENGAN :
        // >> HASIL PENJUMLAHAN DARI PERKALIAN SETIAP ELEMEN BARIS KE-i DARI MATRIKS x DENGAN ELEMEN KOLOM KE-j DARI MATRIKS y.
        // >> HASIL PENJUMLAHAN DISIMPAN DALAM VARIABEL sum.
        // >> SETELAH SEMUA PERKALIAN DIHITUNG DAN DISIMPAN DALAM sum,
        // >> HASILNYA DIMASUKKAN KE DALAM MATRIKS HASIL (result[i][j] = sum).
        for (int i = 0; i < xRows; i++) {
            for (int j = 0; j < yCols; j++) {
                int sum = 0;
                for (int k = 0; k < xCols; k++) {
                    sum += x[i][k] * y[k][j];
                }
                result[i][j] = sum;
            }
        }
        return result;
    }

    // ===== JENIS MATRIKS =====
    static void defineMat(int[][] x){
        // METHOD INI AKAN MENAMPILKAN SIFAT YANG ADA PADA MATRIKS
        // (MENGAMBIL NILAI BOOLEAN DARI METHOD DI BAWAHNYA)
        System.out.println("SIFAT MATRIKS :");
        boolean a = true;
        if(a = isPersegiMatriks(x)){
            System.out.println(">> MATRIKS PERSEGI (MEMILIKI JUMLAH BARIS DAN KOLOM YANG SAMA)");
        } else {
            System.out.println(">> MATRIKS PERSEGI PANJANG (JUMLAH BARIS DAN KOLOM BERBEDA)");
        } if(a = isSimetrisMatriks(x)){
            System.out.println(">> MATRIKS SIMETRI (JIKA DI TRANSPOSE HASILNYA AKAN SAMA)");
        } if(a = isDiagonalMatriks(x)){
            System.out.println(">> MATRIKS DIAGONAL (SELAIN DIAGONAL UTAMA BERNILAI NOL)");
        }
    }
    // MATRIKS PERSEGI ATAU PERSEGI PANJANG
    static boolean isPersegiMatriks(int[][] x){
        // >> JIKA PANJANG BARIS DAN KOLOM MATRIKS x BERNILAI SAMA MAKA BERLAKU :
        // >> TRUE, UNTUK MATRIKS PERSEGI
        // >> FALSE, UNTUK MATRIKS PERSEGI PANJANG
        if(x.length == x[0].length){
            return true;
        } else{
            return false;
        }
    }
    // MATRIKS SIMETRIS
    private static boolean isSimetrisMatriks(int[][] x){
        // >> JIKA a SAMA DENGAN MATRIKS PERSEGI MAKA BERLAKU :
        // >> TRUE, BUAT FOR DENGAN i LEBIH KECIL DARI INDEX MATRIKS x
        // >> BUAT KONDISI DI DALAM FOR JIKA NILAI MATRIKS x TIDAK SAMA DENGAN TRANSPOSE MATRIKS x MAKA :
        // >> JIKA TRUE MAKA RETURN FALSE
        // >> JIKA FALSE MAKA RETURN TRUE
        // >> JIKA MATRIKS TIDAK MEMENUHI KONDISI a SAMA DENGAN MATRIKS PERSEGI MAKA RETURN FALSE
        boolean a = true;
        if(a = isPersegiMatriks(x)){
            for(int i = 0; i < x.length; i++){
                for(int j = 0; j< x[i].length; j++){
                    if(x[i][j] != x[j][i]){
                        return false;
                    }
                }
            }
            return true;
        } else{
            return false;
        }
    }
    // MATRIKS DIAGONAL
    private static boolean isDiagonalMatriks(int[][] x){
        // >> JIKA MATRIKS x ADALAH PERSEGI
        // >> CEK SETIAP ELEMENT PADA SETIAP KOLOM DAN BARIS
        // >> JIKA TERDAPAT ELEMENT PADA SELAIN DIAGONAL UTAMA TIDAK SAMA DENGAN 0 MAKA RETURN FALSE
        // >> JIKA TIDAK MAKA RETURN TRUE
        // >> JIKA MATRIKS BUKAN MATRIKS PERSEGI MAKA RETURN FALSE
        boolean a = isPersegiMatriks(x);
        if(a = true){
            for(int i = 0; i < x.length; i++){
                for(int j = 0; j< x[i].length; j++){
                    if(i != j && x[i][j] != 0){
                        return false;
                    }
                }
            }
            return true;
        }
        else{
            return false;
        }
    }

}