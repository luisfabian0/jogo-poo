public class Mago extends Combatente{
    private int mana;
    private int ataqueBase;

    public Mago(int pv, String nomeDeBatismo, int exp, int mana){
        super(pv, nomeDeBatismo, exp);
        mana = 10;
        ataqueBase = 15;    
        
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