public class SarapanDecorator extends AdditionalDecorator implements Fasilitas {

    private int harga;

    public SarapanDecorator(Properti decoratedProperti, int harga) {
        super(decoratedProperti);
        this.harga= harga;
        this.setHargaDasar(kalkulasiHarga());
        this.setJumlah(decoratedProperti.jumlah);
        for(int i = 0;i<decoratedProperti.getListFasilitas().size();i++) {
            this.addFasilitas(decoratedProperti.getListFasilitas().get(i));
        }
        this.addFasilitas(new Fasilitas(){
        
            @Override
            public int kalkulasiHarga() {
                return this.kalkulasiHarga();
            }
        
            @Override
            public String getDeskripsi() {
                return "Sarapan";
            }
        });
    }

    @Override
    public int kalkulasiHarga() {
        return decoratedProperti.getHargaDasar()+harga;
    }

    
}