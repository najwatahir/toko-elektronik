import java.util.Scanner;

public class Kulkas extends ElektronikRumahTangga {
    private int jumlahPintu;
    private int kapasitasKulkas;

    public Kulkas() {
        super();
    }

    public Kulkas(String[] parts) {
        super(parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), parts[4]);
        this.jumlahPintu = Integer.parseInt(parts[5]);
        this.kapasitasKulkas = Integer.parseInt(parts[6]);
    }

    @Override
    public void inputData(Scanner input) {
        System.out.print("Nama Kulkas: ");
        nama = input.nextLine();
        System.out.print("Tahun Produksi: ");
        tahunProduksi = input.nextInt();
        this.tahunProduksi = Math.min(tahunProduksi, MAX_TAHUN_PRODUKSI);
        System.out.print("Harga: ");
        harga = input.nextInt(); input.nextLine();
        System.out.print("Kapasitas Listrik: ");
        kapasitasListrik = input.nextLine();
        System.out.print("Jumlah Pintu: ");
        jumlahPintu = input.nextInt();
        System.out.print("Kapasitas (Liter): ");
        kapasitasKulkas = input.nextInt(); input.nextLine();
    }

    @Override
    public void info() {
        super.info();
        System.out.println("Jumlah Pintu: " + jumlahPintu);
        System.out.println("Kapasitas Kulkas: " + kapasitasKulkas + "L");
    }

    @Override
    public String toFileString() {
        return "Kulkas|" + nama + "|" + tahunProduksi + "|" + harga + "|" + kapasitasListrik + "|" + jumlahPintu + "|" + kapasitasKulkas;
    }
}
