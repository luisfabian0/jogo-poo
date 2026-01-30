public class Mago extends Combatente{
    private int mana;
    private int ataqueBase;

    public Mago(String nomeDeBatismo, int exp){
        super(nomeDeBatismo, exp, 150 + (exp * 2));
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
    public void atacar(Combatente alvo) {
        if (mana >= 15) {
            int danoMagico = (this.ataqueBase * 2) + this.experiencia;
            mana -= 15;
            System.out.println(nome + " lança um feitiço em " + alvo.getNome() + "!");
            alvo.receberDano(danoMagico);
        } else {
            System.out.println(nome + " está sem mana! Ataque físico e medita (+20 MP).");
            alvo.receberDano(this.ataqueBase);
            this.mana += 20; 
        }
    }
}