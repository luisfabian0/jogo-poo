public abstract class Combatente{
    private int saude;
    private String nome;
    private int experiencia;

    public Combatente(String nomeDeBatismo, int exp){
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