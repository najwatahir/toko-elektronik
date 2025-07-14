import java.util.Scanner;

public class Microwave extends ElektronikRumahTangga {
    private float kapasitasLiter;
    private boolean grillFitur;

    public Microwave() {
        super();
    }

    public Microwave(String[] parts) {
        super(parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), parts[4]);
        this.kapasitasLiter = Float.parseFloat(parts[5]);
        this.grillFitur = Boolean.parseBoolean(parts[6]);
    }


    @Override
    public void inputData(Scanner input) {
        System.out.print("Nama Microwave: ");
        nama = input.nextLine();
        System.out.print("Tahun Produksi: ");
        tahunProduksi = input.nextInt();
        this.tahunProduksi = Math.min(tahunProduksi, MAX_TAHUN_PRODUKSI);
        System.out.print("Harga: ");
        harga = input.nextInt(); input.nextLine();
        System.out.print("Kapasitas Listrik: ");
        kapasitasListrik = input.nextLine();
        System.out.print("Kapasitas (Liter): ");
        kapasitasLiter = input.nextFloat();
        System.out.print("Ada fitur Grill? (y/n): ");
        char c = input.next().toLowerCase().charAt(0);
        grillFitur = (c == 'y');
        input.nextLine();
    }

    @Override
    public void info() {
        super.info();
        System.out.println("Kapasitas: " + kapasitasLiter + "L");
        System.out.println("Fitur Grill: " + (grillFitur ? "Ya" : "Tidak"));
    }

    @Override
    public String toFileString() {
        return "Microwave|" + nama + "|" + tahunProduksi + "|" + harga + "|" + kapasitasListrik + "|" + kapasitasLiter + "|" + grillFitur;
    }
}
