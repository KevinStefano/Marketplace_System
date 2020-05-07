import java.util.ArrayList;

public class Kamar_hotel_builder extends Properti {

    private int jumlahKamar;
    private Tipe tipe;
    private ArrayList<Fasilitas> listFasilitas;

    Kamar_hotel_builder(int hargaDasar, int jumlahKamar, Tipe tipe) {
        super("Kamar_hotel "+tipe, hargaDasar);
        this.jumlahKamar = jumlahKamar;
        this.tipe = tipe;
        this.listFasilitas = new ArrayList<Fasilitas>();
    }

    public Kamar_hotel_builder addKolamRenang() {
        int i = 0;
        while (i<this.listFasilitas.size()) {
            if (listFasilitas.get(i).getDeskripsi().equals("Kolam Renang")) {
                break;
            }
            i++;
        }

        if (i==this.listFasilitas.size()) {
            listFasilitas.add(new KolamRenang());
        }
        return this;
    }

    public Kamar_hotel_builder addSarapan(int harga) {
        int i = 0;
        while (i<this.listFasilitas.size()) {
            if (listFasilitas.get(i).getDeskripsi().equals("Sarapan")) {
                this.listFasilitas.remove(i);
                break;
            }
            i++;
        }
        listFasilitas.add(new Sarapan(harga));
        return this;
    }
    

    public int kalkulasiHarga() {
        int hargafasilitas= 0;
        for (int i=0;i<listFasilitas.size();i++) {
            hargafasilitas+=listFasilitas.get(i).kalkulasiHarga();
        }
        return this.hargaDasar*this.jumlahKamar + hargafasilitas;
    }

    public Kamar_hotel build() {
        Kamar_hotel kamar_hotel = new Kamar_hotel(hargaDasar, jumlahKamar, tipe);
        kamar_hotel.setHargaDasar(kalkulasiHarga());
        for (int i =0;i<this.listFasilitas.size();i++) {
            kamar_hotel.addFasilitas(listFasilitas.get(i));
            // System.out.println(listFasilitas.get(i).getDeskripsi());
        }
        return kamar_hotel;
    }

    public ArrayList<Fasilitas> getFasilitas() {
        return this.listFasilitas;
    }
}