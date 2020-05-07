
public class Main {
    public static void main(String[] args) {
        Registry registry = new Registry();

        //Add Pemilik
        System.out.println("-------PEMILIK--------");
        registry.addPemilik("Kevin", new Kamar_hotel_builder(400000, 10, Tipe.standar)
            .addKolamRenang()
            .addSarapan(80000)
            .build());
        
        registry.addPemilik("Kevin", new Kamar_hotel_builder(600000, 3, Tipe.deluxe)
            .addKolamRenang()
            .addSarapan(80000)
            .build());
        registry.getPemilik("Kevin").tampilkan();

        registry.addPemilik("Hana", new Unit_apartemen_builder(700000, 2)
        .addSarapan(60000)
        .build());

        registry.addPemilik("Hana", new Unit_apartemen_builder(700000, 2)
        .addSarapan(60000)
        .build());

        registry.addPemilik("Hana", new Unit_apartemen_builder(700000, 2)
        .addSarapan(60000)
        .build());

        registry.addPemilik("Hana", new Kamar_homestay_builder(150000, 5)
        .build()); 
        
        registry.getPemilik("Hana").tampilkan();


        //Add Pelanggan
        System.out.println("-------PELANGGAN--------");
        registry.addPelanggan("Hans", "hans@hmail.com", "081580005882");
        registry.addPelanggan("Vino", "Vinos@hmail.com", "08155236988");
        registry.getPelanggan("Hans").tampilkanBiodata();
        registry.getPelanggan("Vino").tampilkanBiodata();

        //Beli/Sewa Properti case 1
        registry.buy("Hans", "Kevin",1, 1);
        registry.buy("Hans", "Hana",4, 1);
        System.out.println("-------PEMBELIAN 1 HANS--------");
        registry.getPelanggan("Hans").tampilkanProperti();

        System.out.println("-------DAFTAR SETELAH PEMBELIAN 1--------");
        registry.getPemilik("Kevin").tampilkan();
        registry.getPemilik("Hana").tampilkan();

        //Beli/Sewa Properti case 2
        registry.buy("Vino", "Hana",3, 1);
        System.out.println("-------PEMBELIAN 1 VINO--------");
        registry.getPelanggan("Vino").tampilkanProperti();

        System.out.println("-------DAFTAR SETELAH PEMBELIAN 2--------");
        registry.getPemilik("Kevin").tampilkan();
        registry.getPemilik("Hana").tampilkan();

        //BROADCAST OLEH PEMILIK 1
        System.out.println("-------BROADCAST DARI PEMILIK 1--------");
        registry.getPemilik("Kevin").broadcast("Jangan lupa dilengkapi pembayarannya ya");
        System.out.println("");

        //BROADCAST OLEH PEMILIK 2
        System.out.println("-------BROADCAST DARI PEMILIK 2--------");
        registry.getPemilik("Hana").broadcast("Terima kasih sudah membeli di saya");
    }
}