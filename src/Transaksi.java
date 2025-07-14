public class Transaksi implements InterfaceTransaksi {
    private String username;
    private String namaBarang;
    private int jumlah;

    public Transaksi(String username, String namaBarang, int jumlah) {
        this.username = username;
        this.namaBarang = namaBarang;
        this.jumlah = jumlah;
    }

    @Override
    public void simpanTransaksi() {
        // tidak dipakai disini karena langsung lewat MainElektronik
    }

    @Override
    public String toFileString() {
        return username + "|" + namaBarang + "|" + jumlah;
    }
}
