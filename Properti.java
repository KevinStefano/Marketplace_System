import java.util.ArrayList;

public abstract class Properti{
    protected String deskripsi;
    protected int hargaDasar;
    protected int jumlah;
    protected ArrayList<Fasilitas> listFasilitas = new ArrayList<>();
    
    public Properti(String deskripsi, int hargaDasar) {
        this.deskripsi = deskripsi;
        this.hargaDasar = hargaDasar;
        this.jumlah = 1;
    }

    public void setDeskripsi(String desk) {
        this.deskripsi = desk;
    }

    public void setHargaDasar(int harga) {
        this.hargaDasar = harga;
    }

    public String getDeskripsi() {
        return this.deskripsi;
    }

    public int getHargaDasar() {
        return this.hargaDasar;
    }

    public  int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public void addFasilitas(Fasilitas fasilitas) {
        listFasilitas.add(fasilitas);
    }

    public ArrayList<Fasilitas> getListFasilitas() {
        return this.listFasilitas;
    }

    public abstract int kalkulasiHarga();
}