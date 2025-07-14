import java.util.Scanner;

public class HP extends ElektronikPribadi {
    private String imei;

    public HP() {
        super();
    }

    public HP(String[] parts) {
        super(parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), parts[4]);
        this.imei = parts[5];
    }




    @Override
    public void inputData(Scanner sc) {
        System.out.print("Nama HP: ");
        this.nama = sc.nextLine();
        System.out.print("Tahun Produksi: ");
        this.tahunProduksi = sc.nextInt();
        this.tahunProduksi = Math.min(tahunProduksi, MAX_TAHUN_PRODUKSI);
        System.out.print("Harga: ");
        this.harga = sc.nextInt();
        sc.nextLine();
        System.out.print("Sistem Operasi: ");
        this.imei = sc.nextLine();
    }

    @Override
    public void info() {
        System.out.println("Nama: " + nama);
        System.out.println("Tahun Produksi: " + tahunProduksi);
        System.out.println("Harga: Rp" + harga);
        System.out.println("OS: " + imei);
    }

    @Override
    public String toFileString() {
        return "HP|" + nama + "|" + tahunProduksi + "|" + harga + "|" + imei;
    }
}
