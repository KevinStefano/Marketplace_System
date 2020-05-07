import java.util.ArrayList;

public class Registry {
    private ArrayList<Pemilik> listPemilik;
    private ArrayList<Pelanggan> listPelanggan;

    public Registry() {
        this.listPemilik = new ArrayList<Pemilik>();
        this.listPelanggan = new ArrayList<Pelanggan>();
    }

    public void addPemilik(String nama, Properti properti) {
        int i =0;
        while (i<listPemilik.size()) {
            if (nama.equalsIgnoreCase(listPemilik.get(i).getNama())) {
                listPemilik.get(i).addProp(properti);
                break;
            }
            i++;
        }
        if (i==listPemilik.size()) {
            listPemilik.add(new Pemilik(nama));
            listPemilik.get(i).addProp(properti);
        }
    }

    public Pemilik getPemilik(String nama) {
        int i =0;
        while (i<listPemilik.size()) {
            if (nama.equalsIgnoreCase(listPemilik.get(i).getNama())) {
                
                break;
            }
            i++;
        }
        return listPemilik.get(i);
    }
    
    public void addPelanggan(String nama, String email, String nomortelp) {
        this.listPelanggan.add(new Pelanggan(nama,email,nomortelp));
    }

    public Pelanggan getPelanggan(String nama) {
        int i =0;
        while (i<listPelanggan.size()) {
            if (nama.equalsIgnoreCase(listPelanggan.get(i).getNama())) { 
                break;
            }
            i++;
        }
        return listPelanggan.get(i);
    }


    public void buy(String namaPelanggan, String namaPemilik, int idBeli, int jumlah) {
        getPelanggan(namaPelanggan).buyProperti(getPemilik(namaPemilik).getPairProperti(idBeli),jumlah);
        getPemilik(namaPemilik).addListPropTersewa(getPemilik(namaPemilik).getPairProperti(idBeli), jumlah, getPelanggan(namaPelanggan));
        getPemilik(namaPemilik).delProperti(idBeli, jumlah);
    }

    

}