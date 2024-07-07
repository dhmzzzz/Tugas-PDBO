import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String nama;
    private String alamat;
    private List<Kamar> kamar;
    private List<Reservasi> riwayatReservasi;

    public Hotel(String nama, String alamat) {
        this.nama = nama;
        this.alamat = alamat;
        this.kamar = new ArrayList<>();
        this.riwayatReservasi = new ArrayList<>();
    }

    public void tambahKamar(Kamar kamar) {
        this.kamar.add(kamar);
    }

    public List<Kamar> getKamar() {
        return kamar;
    }

    public Kamar getKamarByNomor(int nomorKamar) {
        for (Kamar kamar : kamar) {
            if (kamar.getNomorKamar() == nomorKamar) {
                return kamar;
            }
        }
        return null;
    }

    public void tambahReservasi(Reservasi reservasi) {
        this.riwayatReservasi.add(reservasi);
    }

    public List<Reservasi> getRiwayatReservasi() {
        return riwayatReservasi;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}