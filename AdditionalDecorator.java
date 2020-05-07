

public abstract class AdditionalDecorator extends Properti {
    protected Properti decoratedProperti;

    public AdditionalDecorator(Properti decoratedProperti) {
        super(decoratedProperti.getDeskripsi(), decoratedProperti.getHargaDasar());
        this.decoratedProperti = decoratedProperti;
    }

    @Override
    public abstract int kalkulasiHarga();
    
}