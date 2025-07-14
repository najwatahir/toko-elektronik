import java.util.*;
import java.io.*;

public class MainElektronik {
    private static Scanner input = new Scanner(System.in);

    private static List<Elektronik> barangList = new ArrayList<>();
    private static Set<String> namaSet = new HashSet<>();
    private static Map<String, Elektronik> mapData = new HashMap<>();

    public static void main(String[] args) {
        loadBarangDariFile();
        boolean login = false;
        String username = "";
        String password = "";

        while (!login) {
            System.out.println("=== LOGIN ===");
            System.out.print("Username: "); username = input.nextLine();
            System.out.print("Password: "); password = input.nextLine().toLowerCase();

            if (password.equals("admin123")) {
                login = true;
                adminMenu();
            } else if (password.equals("user123")) {
                login = true;
                userMenu(username);
            } else {
                System.out.println("Username/password salah. Silahkan input ulang\n\n");
            }
        }
    }

    private static void adminMenu() {
        while (true) {
            System.out.println("\n=== ADMIN MENU ===");
            System.out.println("1. Tambah Barang");
            System.out.println("2. Lihat Barang");
            System.out.println("3. Lihat Semua Transaksi");
            System.out.println("4. Hapus Barang");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            int pilih = input.nextInt(); input.nextLine();

            switch (pilih) {
                case 1 -> tambahBarang();
                case 2 -> lihatBarang();
                case 3 -> lihatSemuaTransaksi();
                case 4 -> hapusBarang();
                case 0 -> { System.out.println("Keluar."); return; }
                default -> System.out.println("Pilihan salah.");
            }
        }
    }

    private static void userMenu(String username) {
        while (true) {
            System.out.println("\n=== USER MENU ===");
            System.out.println("1. Lihat Barang");
            System.out.println("2. Beli Barang");
            System.out.println("3. Lihat Transaksi Saya");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            int pilih = input.nextInt(); input.nextLine();

            switch (pilih) {
                case 1 -> lihatBarang();
                case 2 -> beliBarang(username);
                case 3 -> lihatTransaksiUser(username);
                case 0 -> { System.out.println("Keluar."); return; }
                default -> System.out.println("Pilihan salah.");
            }
        }
    }

    private static void loadBarangDariFile() {
        barangList.clear();
        namaSet.clear();
        mapData.clear();
        try (Scanner sc = new Scanner(new File("barang.txt"))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                Elektronik e = BarangElektronik.inputBarang(line);
                if (e != null) {
                    barangList.add(e);
                    namaSet.add(e.nama);
                    mapData.put(e.nama, e);
                }
            }
        } catch (IOException e) {
            System.out.println("Belum ada data barang.");
        }
    }


    private static void simpanSemuaBarangKeFile() {
        try (FileWriter fw = new FileWriter("barang.txt")) {
            for (Elektronik e : barangList) {
                fw.write(e.toFileString() + "\n");
            }
        } catch (IOException ex) {
            System.out.println("Gagal simpan barang: " + ex.getMessage());
        }
    }

    private static void tambahBarang() {
        System.out.println("\n=== Tambah Barang ===");
        System.out.println("1. Kulkas");
        System.out.println("2. Microwave");
        System.out.println("3. AC");
        System.out.println("4. HP");
        System.out.println("5. Laptop");
        System.out.println("6. Tablet");
        System.out.print("Pilih jenis: ");
        int jenis = input.nextInt(); input.nextLine();

        Elektronik e = null;
        switch (jenis) {
            case 1 :
                e = new Kulkas();
                break;
            case 2 :
                e = new Microwave();
                break;
            case 3 :
                e = new AC();
                break;
            case 4 :
                e = new HP();
                break;
            case 5 :
                e = new Laptop();
                break;
            case 6 :
                e = new Tablet();
                break;
            default : System.out.println("Jenis tidak dikenali.");
        }

        if (e != null) {
            e.inputData(input);
            if (namaSet.contains(e.nama)) {
                System.out.println("Nama barang sudah ada!");
                return;
            }
            barangList.add(e);
            namaSet.add(e.nama);
            mapData.put(e.nama, e);
            simpanSemuaBarangKeFile();
            System.out.println("Barang berhasil disimpan!");
        }
    }

    private static void lihatBarang() {
        if (barangList.isEmpty()) {
            System.out.println("Tidak ada barang.");
            return;
        }
        for (Elektronik e : barangList) {
            e.info();
            System.out.println("----------------");
        }
    }

    private static void hapusBarang() {
        System.out.print("Nama barang yang ingin dihapus: ");
        String nama = input.nextLine();
        if (!namaSet.contains(nama)) {
            System.out.println("Barang tidak ditemukan.");
            return;
        }
        barangList.removeIf(e -> e.nama.equalsIgnoreCase(nama));
        namaSet.remove(nama);
        mapData.remove(nama);
        simpanSemuaBarangKeFile();
        System.out.println("Barang berhasil dihapus.");
    }

    private static void beliBarang(String username) {
        lihatBarang();
        System.out.print("\nMasukkan nama barang persis: ");
        String namaBarang = input.nextLine();
        Elektronik e = mapData.get(namaBarang);
        if (e == null) {
            System.out.println("Barang tidak ditemukan.");
            return;
        }
        System.out.print("Jumlah: ");
        int jumlah = input.nextInt(); input.nextLine();
        Transaksi t = new Transaksi(username, namaBarang, jumlah);
        simpanTransaksiKeFile(t);
        System.out.println("Transaksi berhasil disimpan!");
    }

    private static void simpanTransaksiKeFile(Transaksi t) {
        try (FileWriter fw = new FileWriter("transaksi.txt", true)) {
            fw.write(t.toFileString() + "\n");
        } catch (IOException ex) {
            System.out.println("Gagal simpan transaksi: " + ex.getMessage());
        }
    }

    private static void lihatTransaksiUser(String username) {
        System.out.println("\n=== Transaksi Anda ===");
        try (Scanner sc = new Scanner(new File("transaksi.txt"))) {
            boolean ada = false;
            while (sc.hasNextLine()) {
                String[] parts = sc.nextLine().split("\\|");
                if (parts[0].equals(username)) {
                    System.out.println("Barang: " + parts[1] + ", Jumlah: " + parts[2]);
                    ada = true;
                }
            }
            if (!ada) System.out.println("Belum ada transaksi.");
        } catch (IOException e) {
            System.out.println("Gagal membaca transaksi: " + e.getMessage());
        }
    }

    private static void lihatSemuaTransaksi() {
        System.out.println("\n=== Semua Transaksi ===");
        try (Scanner sc = new Scanner(new File("transaksi.txt"))) {
            if (!sc.hasNextLine()) {
                System.out.println("Belum ada transaksi.");
                return;
            }
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        } catch (IOException e) {
            System.out.println("Gagal membaca transaksi: " + e.getMessage());
        }
    }
}
