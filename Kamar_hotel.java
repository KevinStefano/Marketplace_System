import java.util.ArrayList;

public class Kamar_hotel extends Properti {
  
    private int jumlahKamar;
    private Tipe tipe;

    public Kamar_hotel(int hargaDasar, int jumlahKamar, Tipe tipe) {
        super("Kamar_hotel "+tipe, hargaDasar);
        super.setJumlah(jumlahKamar);
        this.jumlahKamar = jumlahKamar;
        this.tipe = tipe;
        this.listFasilitas = new ArrayList<Fasilitas>();
    }
    
    public void setJumlah(int jumlah) {
        this.jumlahKamar = jumlah;
    }

    public int getJumlah() {
        return this.jumlahKamar;
    }
    
    public void setTipe(Tipe tipe) {
        this.tipe = tipe;
    }

    public Tipe getTipe() {
        return this.tipe;
    }

    @Override
    public int kalkulasiHarga() {
        return this.hargaDasar*this.jumlahKamar;
    }

	public Kamar_hotel_builder addKolamRenang() {
		return null;
	}

}