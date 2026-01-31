public class Tanque extends Combatente{
    private int vigor;
    private int ataqueBase;

    public Tanque(String nomeDeBatismo, int exp){
        super(nomeDeBatismo, exp, 200 + (exp * 5));
        this.vigor = 10;
        this.ataqueBase = 15;
    }

    @Override
    public void atacar(Combatente alvo){
        int danoTotal = this.ataqueBase + this.getExperiencia();
        System.out.println(this.getNome() + " (Guardião) ataca " + alvo.getNome() + " com força de " + danoTotal);
        alvo.receberDano(danoTotal);    
    }
    
    @Override
    public void receberDano(int dano) {
        if (vigor >= 10 && random.nextInt(100) < 30) { 
            System.out.println(this.getNome() + " bloqueou o ataque completamente! [Vigor -10]");
            vigor -= 10;
        } else {
            super.receberDano(dano);
        }
    }
}