import java.util.Random;
public abstract class Combatente{
    protected int saude;
    protected String nome;
    protected int experiencia;
    protected Random random = new Random();

    public Combatente(String nomeDeBatismo, int exp, int saudeInicial){
        this.nome = nomeDeBatismo;
        this.experiencia = exp;
        this.saude = saudeInicial;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public String getNome() {
        return nome;
    }
    public int getSaude() {
        return saude;
    }
    public boolean estaVivo() {
        return this.saude > 0;
    }
    public void receberDano(int dano) {
        this.saude -= dano;
        if(this.saude < 0) this.saude = 0;
    }

    public abstract void atacar(Combatente alvo);
}