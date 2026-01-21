public class Mago extends Combatente{
    private int pv;
    private int mana;
    private int ataqueBase;

    public Mago(String nomeDeBatismo, int exp){
        super(nomeDeBatismo, exp);
        this.pv = 150;
        this.mana = 10;
        this.ataqueBase = 15;    
        
    }

    public int getAtaqueBase() {
        return ataqueBase;
    }

    public int getMana() {
        return mana;
    }

    @Override
    public void atacar(){

    }
}