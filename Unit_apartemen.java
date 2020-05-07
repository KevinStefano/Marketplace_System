import java.util.ArrayList;

public class Unit_apartemen extends Properti {
    private int jumlahKamarTidur;

    public Unit_apartemen(int hargaDasar, int jumlahKamarTidur) {
        super("Unit_apartemen", hargaDasar);
        this.jumlahKamarTidur = jumlahKamarTidur;
        this.listFasilitas = new ArrayList<>();
        
    }


    public void setJumlahKamarTidur(int jumlahKamarTidur) {
        this.jumlahKamarTidur = jumlahKamarTidur;
    }

    @Override
    public int kalkulasiHarga() {
        return this.hargaDasar;
    }


}