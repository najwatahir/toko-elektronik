import java.util.Scanner;

public abstract class ElektronikRumahTangga extends Elektronik {
    protected String kapasitasListrik;

    public ElektronikRumahTangga() {
        super();
    }

    public ElektronikRumahTangga(String nama, int tahunProduksi, int harga, String kapasitasListrik) {
        super(nama, tahunProduksi, harga);
        this.kapasitasListrik = kapasitasListrik;
    }

    @Override
    public void info() {
        System.out.println("Nama: " + nama);
        System.out.println("Tahun Produksi: " + tahunProduksi);
        System.out.println("Harga: Rp" + harga);
        System.out.println("Kapasitas Listrik: " + kapasitasListrik);
    }

    @Override
    public void inputData(Scanner sc) {
        System.out.print("Nama: ");
        nama = sc.nextLine();
        System.out.print("Tahun Produksi: ");
        tahunProduksi = sc.nextInt();
        System.out.print("Harga: ");
        harga = sc.nextInt(); sc.nextLine();
        System.out.print("Kapasitas Listrik: ");
        kapasitasListrik = sc.nextLine();
    }

}
