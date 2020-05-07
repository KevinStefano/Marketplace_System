public class KolamRenang implements Fasilitas {
    Properti prop;

    public KolamRenang () {
    }

    @Override
    public String getDeskripsi() {
       return "Kolam Renang";
    }

	@Override
	public int kalkulasiHarga() {
		return  0;
	}
}