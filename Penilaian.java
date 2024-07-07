public class Penilaian {
    private Pelanggan pelanggan;
    private int rating;
    private String komentar;

    public Penilaian(Pelanggan pelanggan, int rating, String komentar) {
        this.pelanggan = pelanggan;
        this.rating = rating;
        this.komentar = komentar;
    }

    public Pelanggan getPelanggan() {
        return pelanggan;
    }

    public void setPelanggan(Pelanggan pelanggan) {
        this.pelanggan = pelanggan;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getKomentar() {
        return komentar;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }
}
