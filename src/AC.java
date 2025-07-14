import java.util.Scanner;

public class AC extends ElektronikRumahTangga {
    private String tipeAC;

    public AC() {
        super();
    }

    public AC(String[] parts) {
        super(parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), parts[4]);
        this.tipeAC = parts[5];
    }


    @Override
    public void inputData(Scanner sc) {
        super.inputData(sc);
        System.out.print("Tipe AC (Split/Portable/Cassette): ");
        this.tipeAC = sc.nextLine();
    }

    @Override
    public void info() {
        super.info();
        System.out.println("Tipe AC: " + tipeAC);
    }

    @Override
    public String toFileString() {
        return "AC|" + nama + "|" + tahunProduksi + "|" + harga + "|" + kapasitasListrik + "|" + tipeAC;
    }
}
