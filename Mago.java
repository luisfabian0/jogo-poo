public class Mago extends Combatente{
    private int mana;
    private int ataqueBase;

    public Mago(String nomeDeBatismo, int exp){
        super(nomeDeBatismo, exp, 150 + (exp * 2));
        this.mana = 10;
        this.ataqueBase = 15;
    }

    @Override
    public void atacar(Combatente alvo) {
        if (mana >= 15) {
            int danoMagico = (this.ataqueBase * 2) + this.getExperiencia();
            mana -= 15;
            System.out.println(this.getNome() + " lança um feitiço em " + alvo.getNome() + "!");
            alvo.receberDano(danoMagico);
        } else {
            System.out.println(this.getNome() + " está sem mana! Ataque físico e medita (+20 MP).");
            alvo.receberDano(this.ataqueBase);
            this.mana += 20; 
        }
    }
}