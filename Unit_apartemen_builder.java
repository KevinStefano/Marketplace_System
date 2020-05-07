import java.util.ArrayList;

public class Unit_apartemen_builder extends Properti {
    private int jumlahKamarTidur;
    private ArrayList<Fasilitas> listFasilitas;

    public Unit_apartemen_builder(int hargaDasar, int jumlahKamarTidur) {
        super("Unit_apartemen", hargaDasar);
        this.jumlahKamarTidur = jumlahKamarTidur;
        this.listFasilitas = new ArrayList<>();
    }

    public Unit_apartemen_builder addKolamRenang() {
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

    public Unit_apartemen_builder addSarapan(int harga) {
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

    public Unit_apartemen build() {
        Unit_apartemen unit_apartemen = new Unit_apartemen(hargaDasar, jumlahKamarTidur);
        unit_apartemen.setHargaDasar(kalkulasiHarga());
        for (int i =0;i<this.listFasilitas.size();i++) {
            unit_apartemen.addFasilitas(listFasilitas.get(i));
        }
        return unit_apartemen;
    }

    public ArrayList<Fasilitas> getFasilitas() {
        return this.listFasilitas;
    }
}