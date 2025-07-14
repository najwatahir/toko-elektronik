import java.util.Scanner;

public class Tablet extends Elektronik {
    private String os;

    public Tablet() {
        super();
    }

    public Tablet(String nama, int tahun, int harga, String os) {
        super(nama, tahun, harga);
        this.os = os;
    }

    @Override
    public void inputData(Scanner sc) {
        System.out.print("Nama Tablet: ");
        this.nama = sc.nextLine();
        System.out.print("Tahun Produksi: ");
        this.tahunProduksi = sc.nextInt();
        this.tahunProduksi = Math.min(tahunProduksi, MAX_TAHUN_PRODUKSI);
        System.out.print("Harga: ");
        this.harga = sc.nextInt();
        sc.nextLine();
        System.out.print("Sistem Operasi: ");
        this.os = sc.nextLine();
    }

    @Override
    public void info() {
        System.out.println("Nama: " + nama);
        System.out.println("Tahun Produksi: " + tahunProduksi);
        System.out.println("Harga: Rp" + harga);
        System.out.println("OS: " + os);
    }

    @Override
    public String toFileString() {
        return "Tablet|" + nama + "|" + tahunProduksi + "|" + harga + "|" + os;
    }
}
