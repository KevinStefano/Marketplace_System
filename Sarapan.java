
public class Sarapan implements Fasilitas{
    private int harga;

    public Sarapan (int harga) {
        this.harga = harga;
    }

    @Override
    public String getDeskripsi() {
       return "Sarapan";
    }

	public int kalkulasiHarga() {
		return harga;
	}
}