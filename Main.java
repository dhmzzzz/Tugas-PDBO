import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Hotel hotel = new Hotel("Saturnus Hotel", "Jalan Utama 123");

        // Menambahkan beberapa kamar ke hotel
        Kamar kamar1 = new Kamar(101, "Biasa", 300.0);
        Kamar kamar2 = new Kamar(102, "VIP", 500.0);
        
        hotel.tambahKamar(kamar1);
        hotel.tambahKamar(kamar2);

        try {
            // Input untuk Pelanggan
            System.out.println("Masukkan nama pelanggan:");
            String namaPelanggan = scanner.nextLine();
            System.out.println("Masukkan email pelanggan:");
            String emailPelanggan = scanner.nextLine();
            System.out.println("Masukkan nomor telepon pelanggan:");
            String nomorTeleponPelanggan = scanner.nextLine();

            Pelanggan pelanggan = new Pelanggan(namaPelanggan, emailPelanggan, nomorTeleponPelanggan);

            // Input untuk Pemilihan Kamar
            System.out.println("Kamar yang tersedia:");
            for (Kamar kamar : hotel.getKamar()) {
                if (kamar.isTersedia()) {
                    System.out.println("Nomor Kamar: " + kamar.getNomorKamar() + ", Tipe: " + kamar.getTipe() + ", Harga: " + kamar.getHarga());
                }
            }
            System.out.println("Masukkan nomor kamar untuk reservasi:");
            int nomorKamar = scanner.nextInt();
            scanner.nextLine(); // Konsumsi newline
            Kamar kamarTerpilih = hotel.getKamarByNomor(nomorKamar);
            if (kamarTerpilih != null && kamarTerpilih.isTersedia()) {
                kamarTerpilih.setTersedia(false);

                // Input untuk Tanggal Reservasi
                System.out.println("Masukkan tanggal check-in (yyyy-mm-dd):");
                String tanggalCheckInStr = scanner.nextLine();
                System.out.println("Masukkan tanggal check-out (yyyy-mm-dd):");
                String tanggalCheckOutStr = scanner.nextLine();
                Date tanggalCheckIn = java.sql.Date.valueOf(tanggalCheckInStr);
                Date tanggalCheckOut = java.sql.Date.valueOf(tanggalCheckOutStr);

                Reservasi reservasi = new Reservasi(pelanggan, kamarTerpilih, tanggalCheckIn, tanggalCheckOut);
                long durasiMenginap = reservasi.hitungDurasiMenginap();
                double totalHarga = durasiMenginap * kamarTerpilih.getHarga();

                // Input untuk Layanan Tambahan
                System.out.println("Tambahkan layanan tambahan? (y/n)");
                String tambahanLayanan = scanner.nextLine();
                while (tambahanLayanan.equalsIgnoreCase("y")) {
                    System.out.println("Masukkan nama layanan tambahan:");
                    String namaLayanan = scanner.nextLine();
                    System.out.println("Masukkan harga layanan tambahan:");
                    double hargaLayanan = scanner.nextDouble();
                    scanner.nextLine(); // Konsumsi newline

                    LayananTambahan layananTambahan = new LayananTambahan(namaLayanan, hargaLayanan);
                    reservasi.tambahLayananTambahan(layananTambahan);
                    totalHarga += hargaLayanan;

                    System.out.println("Tambahkan layanan tambahan lagi? (y/n)");
                    tambahanLayanan = scanner.nextLine();
                }

                // Input untuk Pembayaran
                System.out.println("Masukkan metode pembayaran (Kartu Kredit/Tunai):");
                String metodePembayaran = scanner.nextLine();
                Pembayaran pembayaran = new Pembayaran(reservasi, totalHarga, metodePembayaran);

                hotel.tambahReservasi(reservasi);

                System.out.println("Reservasi dibuat untuk " + pelanggan.getNama() + " di kamar " + kamarTerpilih.getNomorKamar());
                System.out.println("Tanggal Check-in: " + tanggalCheckIn);
                System.out.println("Tanggal Check-out: " + tanggalCheckOut);
                System.out.println("Durasi Menginap: " + durasiMenginap + " hari");
                System.out.println("Total Harga: " + totalHarga);
                System.out.println("Metode Pembayaran: " + metodePembayaran);

                // Proses Check-out
                System.out.println("Apakah Anda ingin check-out sekarang? (y/n)");
                String checkout = scanner.nextLine();
                if (checkout.equalsIgnoreCase("y")) {
                    kamarTerpilih.setTersedia(true);
                    System.out.println("Check-out berhasil. Terima kasih telah menginap di " + hotel.getNama());
                    
                    // Input untuk Penilaian
                    System.out.println("Masukkan penilaian Anda (1-5):");
                    int rating = scanner.nextInt();
                    scanner.nextLine(); // Konsumsi newline
                    System.out.println("Masukkan komentar Anda:");
                    String komentar = scanner.nextLine();

                    Penilaian penilaian = new Penilaian(pelanggan, rating, komentar);
                    System.out.println("Terima kasih atas penilaian Anda!");
                }
            } else {
                System.out.println("Kamar tidak tersedia atau nomor kamar tidak valid.");
            }
        } finally {
            scanner.close();
        }
    }
}