public class Kamar {
    private int nomorKamar;
    private String tipe;
    private double harga;
    private boolean tersedia;

    public Kamar(int nomorKamar, String tipe, double harga) {
        this.nomorKamar = nomorKamar;
        this.tipe = tipe;
        this.harga = harga;
        this.tersedia = true;
    }

    public int getNomorKamar() {
        return nomorKamar;
    }

    public void setNomorKamar(int nomorKamar) {
        this.nomorKamar = nomorKamar;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public boolean isTersedia() {
        return tersedia;
    }

    public void setTersedia(boolean tersedia) {
        this.tersedia = tersedia;
    }
}
