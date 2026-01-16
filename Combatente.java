public abstract class Combatente{
    private int saude;
    private String nome;
    private int experiencia;

    public Combatente(int pv, String nomeDeBatismo, int exp){
        this.saude = pv;
        this.nome = nomeDeBatismo;
        this.experiencia = exp;
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
    

    public abstract void atacar();
}