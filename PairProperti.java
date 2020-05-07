public class PairProperti {
    
    private int ID;
    private String pemilik;
    private int jumlah;
    private Properti properti;

    PairProperti(int ID, String pemilik, Properti properti) {
        this.ID = ID;
        this.properti = properti;
        this.pemilik  =pemilik;
        this.jumlah =properti.getJumlah();
    }

    int getJumlah() {
        return this.jumlah;
    }

    void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }
    int getID() {
        return this.ID;
    }

    Properti getProperti () {
        return this.properti;
    }

    String getPemilik() {
        return this.pemilik;
    }


}