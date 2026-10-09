import java.util.ArrayList;
import java.util.Scanner;

public class StatistikNilai {
    static final int SELESAI = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> daftar = new ArrayList<>();

        System.out.println("===== STATISTIK NILAI KELAS =====");
        System.out.println("Ketik -1 kalau sudah selesai.");

        int input;
        do {
            System.out.print("Nilai ke-" + (daftar.size() + 1) + " : ");
            input = scanner.nextInt();

            if (input == SELESAI) {
                break;
            }

            if (input < 0 || input > 100) {
                System.out.println("  Ditolak, harus 0-100");
                continue;
            }

            daftar.add(input);
        } while (input != SELESAI);

        System.out.println();
        System.out.println("Nilai tersimpan : " + daftar);
        System.out.println("Jumlah          : " + daftar.size());

        int total = 0;
        for (int nilai : daftar) {
            total += nilai;
        }
        double rataRata = (double) total / daftar.size();
        System.out.printf("Rata-rata       : %.2f\n", rataRata);

        /*
         * ALASAN NILAI AWAL:
         * Nilai awal diambil dari data pertama (daftar.get(0)) untuk memastikan
         * pembanding adalah data valid di dalam list, bukan angka sembarang (seperti 0 atau 100)
         * yang berisiko menyebabkan bug jika rentang nilai soal diubah.
         */
        int tertinggi = daftar.get(0);
        int terendah = daftar.get(0);
        for (int nilai : daftar) {
            if (nilai > tertinggi) tertinggi = nilai;
            if (nilai < terendah) terendah = nilai;
        }
        System.out.println("Tertinggi       : " + tertinggi);
        System.out.println("Terendah        : " + terendah);

        /*
         * ALASAN PUTARAN KEDUA:
         * Jumlah mahasiswa di atas rata-rata baru bisa dihitung setelah semua nilai selesai diinput
         * (putaran kedua). Pada saat input sedang berjalan, nilai rata-rata keseluruhan belum diketahui.
         */
        int diatasRata = 0;
        for (int nilai : daftar) {
            if (nilai > rataRata) diatasRata++;
        }
        System.out.println("Di atas rata2   : " + diatasRata + " orang");

        int[] jumlahGrade = new int[5];
        for (int nilai : daftar) {
            if (nilai >= 90) jumlahGrade[0]++;
            else if (nilai >= 80) jumlahGrade[1]++;
            else if (nilai >= 70) jumlahGrade[2]++;
            else if (nilai >= 60) jumlahGrade[3]++;
            else jumlahGrade[4]++;
        }

        System.out.print("Distribusi      : ");
        char[] namaGrade = {'A', 'B', 'C', 'D', 'E'};
        for (int i = 0; i < jumlahGrade.length; i++) {
            System.out.print(namaGrade[i] + "=" + jumlahGrade[i]);
            if (i < jumlahGrade.length - 1) System.out.print(" ");
        }
        System.out.println();
    }
}