public class Atirador extends Combatente{
    private int precisao;
    private int ataqueBase;

    public Atirador(int pv, String nomeDeBatismo, int exp){
        super(pv, nomeDeBatismo, exp);
        this.precisao = 10;
        this.ataqueBase = 15;
    }
    
    public int getAtaqueBase() {
        return ataqueBase;
    }
    public int getPrecisao() {
        return precisao;
    }

    @Override
    public void atacar(){
        
    }
}