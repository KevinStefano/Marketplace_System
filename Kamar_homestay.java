import java.util.ArrayList;

public class Kamar_homestay extends Properti {
    private int jumlahKamar;

    public Kamar_homestay(int hargaDasar, int jumlahKamar) {
        super("Kamar_homestay", hargaDasar);
        this.jumlahKamar = jumlahKamar;
        this.listFasilitas = new ArrayList<>();
    }
    

    public void setJumlahKamar(int jumlah) {
        this.jumlahKamar = jumlah;
    }

    public int getJumlah() {
        return this.jumlahKamar;
    }
    
    @Override
    public int kalkulasiHarga() {
        return this.hargaDasar*this.jumlahKamar;
    }
    
}