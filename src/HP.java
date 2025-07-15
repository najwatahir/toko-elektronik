import java.util.Scanner;

public class HP extends ElektronikPribadi {
    private String os;

    public HP() {
        super();
    }

    public HP(String[] parts) {
        super(parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), parts[4]);
        this.os = parts[5];
    }




    @Override
    public void inputData(Scanner input) {
        System.out.print("Nama HP: ");
        this.nama = input.nextLine();
        System.out.print("Tahun Produksi: ");
        this.tahunProduksi = input.nextInt();
        this.tahunProduksi = Math.min(tahunProduksi, MAX_TAHUN_PRODUKSI);
        System.out.print("Harga: ");
        this.harga = input.nextInt();
        input.nextLine();
        System.out.print("Sistem Operasi: ");
        this.os = input.nextLine();
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
        return "HP|" + nama + "|" + tahunProduksi + "|" + harga + "|" + os;
    }
}
