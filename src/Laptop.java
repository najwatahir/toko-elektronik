import java.util.Scanner;

public class Laptop extends ElektronikPribadi {
    private String kapasitasBaterai;
    private String processor;
    private String serialNumber;

    public Laptop() {
        super();
    }

    public Laptop(String[] parts) {
        super(parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), parts[4]);
        this.tahunProduksi = Math.min(tahunProduksi, MAX_TAHUN_PRODUKSI);
        this.processor = parts[5];
        this.serialNumber = parts[6];
    }


    @Override
    public void inputData(Scanner input) {
        System.out.print("Nama Laptop: ");
        this.nama = input.nextLine();
        System.out.print("Tahun Produksi: ");
        this.tahunProduksi = input.nextInt();
        this.tahunProduksi = Math.min(tahunProduksi, MAX_TAHUN_PRODUKSI);
        System.out.print("Harga: ");
        this.harga = input.nextInt(); input.nextLine();
        System.out.print("Kapasitas Baterai: ");
        this.kapasitasBaterai = input.nextLine();
        System.out.print("Processor: ");
        this.processor = input.nextLine();
        System.out.print("Serial Number: ");
        this.serialNumber = input.nextLine();
    }

    @Override
    public void info() {
        System.out.println("=== INFORMASI LAPTOP ===");
        System.out.println("Nama: " + nama);
        System.out.println("Tahun Produksi: " + tahunProduksi);
        System.out.println("Harga: Rp" + harga);
        System.out.println("Kapasitas Baterai: " + kapasitasBaterai);
        System.out.println("Processor: " + processor);
        System.out.println("Serial Number: " + serialNumber);
    }

    @Override
    public String toFileString() {
        return "Laptop|" + nama + "|" + tahunProduksi + "|" + harga + "|" + kapasitasBaterai + "|" + processor + "|" + serialNumber;
    }
}
