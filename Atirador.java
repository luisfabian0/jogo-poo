public class Atirador extends Combatente{
    private int pv;
    private int precisao;
    private int ataqueBase;

    public Atirador(String nomeDeBatismo, int exp){
        super( nomeDeBatismo, exp);
        this.pv = 100;
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