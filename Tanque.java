public class Tanque extends Combatente{
    private int pv; 
    private int vigor;
    private int ataqueBase;

    public Tanque(String nomeDeBatismo, int exp){
        super(nomeDeBatismo, exp);
        this.pv = 200;
        this.vigor = 10;
        this.ataqueBase = 15;
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