import java.util.ArrayList;

public abstract class Properti{
    protected String deskripsi;
    protected int hargaDasar;
    protected ArrayList<Fasilitas> listFasilitas;

    public Properti(String deskripsi, int hargaDasar) {
        this.deskripsi = deskripsi;
        this.hargaDasar = hargaDasar;
        this.listFasilitas = new ArrayList<Fasilitas>();
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
        return 1;
    }

    public void addFasilitas(Fasilitas fasilitas) {
        listFasilitas.add(fasilitas);
    }

    public ArrayList<Fasilitas> getListFasilitas() {
        return this.listFasilitas;
    }

    public abstract int kalkulasiHarga();
}