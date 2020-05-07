import java.util.ArrayList;

public class Pelanggan {
    private String nama;
    private String email;
    private String nomortelp;
    private ArrayList<PairProperti> listProp;

    public Pelanggan() {
        this.nama = "XXXX";
        this.email = "XXXX@gmail.com";
        this.nomortelp = "XXXX";
        this.listProp = new ArrayList<>();
    }
    public Pelanggan(String nama, String email, String nomortelp) {
        this.nama = nama;
        this.email = email;
        this.nomortelp = nomortelp;
        this.listProp = new ArrayList<>();
    }

    public void tampilkanBiodata() {
        System.out.println(this.nama);
        System.out.println(this.email);
        System.out.println(this.nomortelp);
        System.out.println("");
    }

    public void tampilkanProperti() {
        for(int i =0; i<this.listProp.size(); i++) {
            System.out.println("ID = "+this.listProp.get(i).getID()+" ("+this.listProp.get(i).getPemilik()+")");
            System.out.println("Nama Properti = " + this.listProp.get(i).getProperti().getDeskripsi());
            System.out.println("Jumlah = " + this.listProp.get(i).getJumlah());
            System.out.println("");
        }
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    public void setEmail (String email) {
        this.email = email;
    }
    public void setNomortelp(String no) {
        this.nomortelp = no;
    }

    public String getNama() {
        return this.nama;
    }

    public String getEmail() {
        return this.email;
    }

    public String getNomortelp() {
        return this.nomortelp;
    }

    public void buyProperti (PairProperti pairprop, int jumlah) {
        int jumlahakhir = 0;
        PairProperti pairPropPelanggan = new PairProperti(pairprop.getID(), pairprop.getPemilik(),pairprop.getProperti());
        if (pairprop.getJumlah()<jumlah) {
            jumlahakhir = jumlah - pairprop.getJumlah();
        }
        else {
            jumlahakhir = jumlah;
        }
        pairPropPelanggan.setJumlah(jumlahakhir);
        this.listProp.add(pairPropPelanggan);
     }

     public void getMessage (Pemilik pemilik, String message) {
         System.out.println("Hi "+this.nama+", this is message from " + pemilik.getNama());
         System.out.println(message);
     }
}