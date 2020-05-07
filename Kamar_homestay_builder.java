import java.util.ArrayList;

public class Kamar_homestay_builder extends Properti {
    private int jumlahKamarTidur;
    private ArrayList<Fasilitas> listFasilitas;

    public Kamar_homestay_builder(int hargaDasar, int jumlahKamarTidur) {
        super("Kamar_homestay", hargaDasar);
        this.jumlahKamarTidur = jumlahKamarTidur;
        this.listFasilitas = new ArrayList<>();
    }

    public Kamar_homestay_builder addKolamRenang() {
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

    public Kamar_homestay_builder addSarapan(int harga) {
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

    public ArrayList<Fasilitas> getListFasilitas() {
        return this.listFasilitas;
    }


    public void setJumlahKamarTidur(int jumlahKamarTidur) {
        this.jumlahKamarTidur = jumlahKamarTidur;
    }

    public int kalkulasiHarga() {
        int hargafasilitas= 0;
        for (int i=0;i<listFasilitas.size();i++) {
            hargafasilitas+=listFasilitas.get(i).kalkulasiHarga();
        }
        return this.hargaDasar+ hargafasilitas;
    }

    public Kamar_homestay build() {
        Kamar_homestay Kamar_homestay = new Kamar_homestay(hargaDasar, jumlahKamarTidur);
        Kamar_homestay.setHargaDasar(kalkulasiHarga());
        for (int i =0;i<this.listFasilitas.size();i++) {
            Kamar_homestay.addFasilitas(listFasilitas.get(i));
        }
        return Kamar_homestay;
    }

    public ArrayList<Fasilitas> getFasilitas() {
        return this.listFasilitas;
    }
}