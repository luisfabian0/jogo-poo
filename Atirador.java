public class Atirador extends Combatente{
    private int precisao;
    private int ataqueBase;

    public Atirador(String nomeDeBatismo, int exp){
        super(nomeDeBatismo, exp, 100 + (exp * 2));
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
    public void atacar(Combatente alvo) {
        int danoTotal = this.ataqueBase + this.experiencia;
        if (random.nextInt(100) < this.precisao) { 
            danoTotal *= 2; 
            System.out.print("[ACERTO CRÍTICO! " + this.precisao + "% de chance] ");
        }
        System.out.println(nome + " disparou contra " + alvo.getNome() + " causando " + danoTotal + " de dano.");
        alvo.receberDano(danoTotal);
    }
}