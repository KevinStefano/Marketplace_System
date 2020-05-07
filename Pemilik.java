
import java.util.ArrayList;

public class Pemilik {
    private String nama;
    private ArrayList<PairProperti> listProp;
    private ArrayList<PairPropertiTersewa> listPropTersewa;

    public Pemilik() {
    }
    public Pemilik(String nama) {
        this.nama= nama;
        this.listProp = new ArrayList<PairProperti>();
        this.listPropTersewa = new ArrayList<>();
    }

    public void addProp (Properti prop) {
       this.listProp.add(new PairProperti(this.listProp.size()+1, this.nama, prop));
    }

    public void addListPropTersewa(PairProperti pairprop, int jumlah, Pelanggan pelanggan){
        PairPropertiTersewa pairPropPemilik = new PairPropertiTersewa(pairprop.getID(), nama, pairprop.getProperti(),pelanggan);
        int jumlahakhir  =0;
        if (pairprop.getJumlah()<jumlah) {
            jumlahakhir = jumlah - pairprop.getJumlah();
        }
        else {
            jumlahakhir = jumlah;
        }
        pairPropPemilik.setJumlah(jumlahakhir);
        this.listPropTersewa.add(pairPropPemilik);
    }

    public String getNama() {
        return this.nama;
    }

    public Properti getProp(String namaProperti) {
        int i = 0;
        while (i<this.listProp.size()) {
            if (this.listProp.get(i).getProperti().getDeskripsi().equalsIgnoreCase(namaProperti)) {
                return this.listProp.get(i).getProperti();
            }
            i++;
        }
        return null;
    }

    public PairProperti getPairProperti(int ID) {
        return this.listProp.get(ID-1);
    }

    public void delProperti(int ID, int jumlah) {
        int jumlahakhir = this.listProp.get(ID-1).getJumlah()-jumlah;
        if (jumlahakhir<=0) {
            this.listProp.get(ID-1).setJumlah(0);
        }
        else {
            this.listProp.get(ID-1).setJumlah(jumlahakhir);
        }
    }

    public void tampilkan() {
        System.out.println(this.nama);
        for (int i=0;i<this.listProp.size();i++) {
                System.out.println(this.listProp.get(i).getID() + ". " +this.listProp.get(i).getProperti().getDeskripsi());
                System.out.println("Jumlah : " + this.listProp.get(i).getJumlah());
                System.out.println("Fasilitas :");
                if (this.listProp.get(i).getProperti().getListFasilitas().size()==0) {
                    System.out.println("Tidak ada");
                }
                for (int j =0; j<this.listProp.get(i).getProperti().getListFasilitas().size();j++) {
                    System.out.print("- ");
                    System.out.println(listProp.get(i).getProperti().getListFasilitas().get(j).getDeskripsi());
                }
                
                System.out.println("");
        }
    }

    public void sendMessage(String message, String Pelanggan) {
        for (int i =0;i<this.listPropTersewa.size();i++) {
            if (Pelanggan.equalsIgnoreCase(this.listPropTersewa.get(i).getPelanggan().getNama())) {
                this.listPropTersewa.get(i).getPelanggan().getMessage(this, message);
            }
        }
    }

    public void broadcast(String message) {
        for (int i =0;i<this.listPropTersewa.size();i++) {
            this.listPropTersewa.get(i).getPelanggan().getMessage(this, message);
        }
    }
}

class PairPropertiTersewa {
    private int ID;
    private String pemilik;
    private int jumlah;
    private Properti properti;
    private Pelanggan pelanggan;

    PairPropertiTersewa(int ID, String pemilik, Properti properti, Pelanggan pelanggan) {
        this.ID = ID;
        this.properti = properti;
        this.pemilik  =pemilik;
        this.jumlah =properti.getJumlah();
        this.pelanggan = pelanggan;
    }

    Pelanggan getPelanggan() {
        return this.pelanggan;
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
