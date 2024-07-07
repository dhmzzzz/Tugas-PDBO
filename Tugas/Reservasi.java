import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Reservasi {
    private Pelanggan pelanggan;
    private Kamar kamar;
    private Date tanggalCheckIn;
    private Date tanggalCheckOut;
    private List<LayananTambahan> layananTambahan;

    public Reservasi(Pelanggan pelanggan, Kamar kamar, Date tanggalCheckIn, Date tanggalCheckOut) {
        this.pelanggan = pelanggan;
        this.kamar = kamar;
        this.tanggalCheckIn = tanggalCheckIn;
        this.tanggalCheckOut = tanggalCheckOut;
        this.layananTambahan = new ArrayList<>();
    }

    public Pelanggan getPelanggan() {
        return pelanggan;
    }

    public void setPelanggan(Pelanggan pelanggan) {
        this.pelanggan = pelanggan;
    }

    public Kamar getKamar() {
        return kamar;
    }

    public void setKamar(Kamar kamar) {
        this.kamar = kamar;
    }

    public Date getTanggalCheckIn() {
        return tanggalCheckIn;
    }

    public void setTanggalCheckIn(Date tanggalCheckIn) {
        this.tanggalCheckIn = tanggalCheckIn;
    }

    public Date getTanggalCheckOut() {
        return tanggalCheckOut;
    }

    public void setTanggalCheckOut(Date tanggalCheckOut) {
        this.tanggalCheckOut = tanggalCheckOut;
    }

    public long hitungDurasiMenginap() {
        long durasi = tanggalCheckOut.getTime() - tanggalCheckIn.getTime();
        return durasi / (1000 * 60 * 60 * 24);
    }

    public void tambahLayananTambahan(LayananTambahan layanan) {
        this.layananTambahan.add(layanan);
    }

    public List<LayananTambahan> getLayananTambahan() {
        return layananTambahan;
    }
}
