public class Pembayaran {
    private Reservasi reservasi;
    private double jumlah;
    private String metodePembayaran;

    public Pembayaran(Reservasi reservasi, double jumlah, String metodePembayaran) {
        this.reservasi = reservasi;
        this.jumlah = jumlah;
        this.metodePembayaran = metodePembayaran;
    }

    public Reservasi getReservasi() {
        return reservasi;
    }

    public void setReservasi(Reservasi reservasi) {
        this.reservasi = reservasi;
    }

    public double getJumlah() {
        return jumlah;
    }

    public void setJumlah(double jumlah) {
        this.jumlah = jumlah;
    }

    public String getMetodePembayaran() {
        return metodePembayaran;
    }

    public void setMetodePembayaran(String metodePembayaran) {
        this.metodePembayaran = metodePembayaran;
    }
}