public class Tanque extends Combatente{
    private int vigor;
    private int ataqueBase;

    public Tanque(int pv, String nomeDeBatismo, int exp){
        super(pv, nomeDeBatismo, exp);
        vigor = 10;
        ataqueBase = 15;
    }

    public int getAtaqueBase() {
        return ataqueBase;
    }

    public int getVigor() {
        return vigor;
    }

    @Override
    public void atacar(){
            
    }
    
}