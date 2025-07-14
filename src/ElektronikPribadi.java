public abstract class ElektronikPribadi extends Elektronik {
    protected String kapasitasBaterai;

    public ElektronikPribadi() {
        super();
    }

    public ElektronikPribadi(String nama, int tahunProduksi, int harga, String kapasitasBaterai) {
        super(nama, tahunProduksi, harga);
        this.kapasitasBaterai = kapasitasBaterai;
    }

    @Override
    public void info() {
        System.out.println("Nama: " + nama);
        System.out.println("Tahun Produksi: " + tahunProduksi);
        this.tahunProduksi = Math.min(tahunProduksi, MAX_TAHUN_PRODUKSI);
        System.out.println("Harga: Rp" + harga);
        System.out.println("Kapasitas Baterai: " + kapasitasBaterai);
    }
}
