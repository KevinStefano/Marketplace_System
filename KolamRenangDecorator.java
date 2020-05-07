public class KolamRenangDecorator extends AdditionalDecorator implements Fasilitas{

    public KolamRenangDecorator(Properti decoratedProperti) {
        super(decoratedProperti);
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
                return "Kolam Renang";
            }
        });
    }

    @Override
    public int kalkulasiHarga() {
        return decoratedProperti.getHargaDasar()+0;
    }
    
}