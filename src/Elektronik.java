import java.util.Scanner;

public abstract class Elektronik {
    protected String nama;
    protected int tahunProduksi, harga;
    public static final int MAX_TAHUN_PRODUKSI = 2025;

    public Elektronik() {}

    public Elektronik(String nama, int tahunProduksi, int harga) {
        this.nama = nama;
        this.tahunProduksi = Math.min(tahunProduksi, MAX_TAHUN_PRODUKSI);
        this.harga = harga;
    }

    public abstract void inputData(Scanner sc);
    public abstract void info();
    public abstract String toFileString();
}
