public class BarangElektronik {
    public static Elektronik inputBarang(String line) {
        try {
            String[] parts = line.split("\\|");
            String tipe = parts[0];

            return switch (tipe) {
                case "Kulkas" -> new Kulkas(parts);
                case "Microwave" -> new Microwave(parts);
                case "AC" -> new AC(parts);
                case "Laptop" -> new Laptop(parts);
                case "HP" -> new HP(parts);
                default -> null;
            };
        } catch (Exception e) {
            System.out.println("Gagal parsing barang: " + line);
            return null;
        }
    }
}
