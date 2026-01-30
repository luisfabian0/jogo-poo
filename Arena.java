
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Arena {

    private ArrayList<Combatente> combatentesAL = new ArrayList<>();
    private ArrayList<Combatente> combatentesHS = new ArrayList<>();
    
    Scanner sc = new Scanner(System.in);

    public void adicionarPersonagem() {

        Combatente personagem;

        // ===== EQUIPE =====
        System.out.println(
                "O combatente pertence a qual equipe?\n" +
                        "Digite A para Aliança da Luz\n" +
                        "Digite B para Horda das Sombras");
        String equipeCombatente = sc.nextLine().trim();

        while (!equipeCombatente.equalsIgnoreCase("A") &&
                !equipeCombatente.equalsIgnoreCase("B")) {

            System.out.println("Equipe inválida. Digite A ou B:");
            equipeCombatente = sc.nextLine().trim();
        }

        // ===== NOME =====
        System.out.println("Qual o nome do combatente?");
        String nomeCombatente = sc.nextLine().trim();

        while (nomeCombatente.isEmpty()) {
            System.out.println("Nome não pode ser vazio. Digite novamente:");
            nomeCombatente = sc.nextLine().trim();
        }

        // ===== EXPERIÊNCIA =====
        System.out.println("Qual o nível de experiência do combatente?");
        while (!sc.hasNextInt()) {
            System.out.println("Digite um número válido:");
            sc.next();
        }
        int expCombatente = sc.nextInt();
        sc.nextLine(); // consome o ENTER

        // ===== TIPO =====
        System.out.println(
                "Qual o tipo do combatente?\n" +
                        "Digite A para Atirador\n" +
                        "Digite T para Tanque\n" +
                        "Digite M para Mago");
        String tipoCombatente = sc.nextLine().trim();

        while (!tipoCombatente.equalsIgnoreCase("A") &&
                !tipoCombatente.equalsIgnoreCase("T") &&
                !tipoCombatente.equalsIgnoreCase("M")) {

            System.out.println("Tipo inválido. Digite A, T ou M:");
            tipoCombatente = sc.nextLine().trim();
        }

        // ===== CRIAÇÃO DO PERSONAGEM =====
        switch (tipoCombatente.toUpperCase()) {
            case "T":
                personagem = new Tanque(nomeCombatente, expCombatente);
                break;

            case "M":
                personagem = new Mago(nomeCombatente, expCombatente);
                break;

            case "A":
                personagem = new Atirador(nomeCombatente, expCombatente);
                break;

            default:
                personagem = null;
        }
        ;

        if (equipeCombatente.equals('A')) {
            combatentesAL.add(personagem);
        } else {
            combatentesHS.add(personagem);
        }

    }

    public Combatente escolherAlvoVivo(ArrayList<Combatente> equipe) {

        ArrayList<Combatente> vivos = new ArrayList<>();

        for (Combatente c : equipe) {
            if (c.saude > 0)
                vivos.add(c);
        }

        if (vivos.isEmpty())
            return null;

        Collections.shuffle(vivos);
        return vivos.get(0);
    }

    public boolean equipeViva(ArrayList<Combatente> equipe) {
        for (Combatente c : equipe) {
            if (c.saude > 0) {
                return true;
            }
        }
        return false;
    }

    public void orquestrarJogo() {

        while (equipeViva(combatentesHS) && equipeViva(combatentesAL)) {
            Collections.shuffle(combatentesAL);
            Collections.shuffle(combatentesHS);

            orquestrarRodada();
        }

        System.out.println("O jogo acabou");
        return;
    }

    public void orquestrarRodada() {

        ArrayList<Combatente> ordem = new ArrayList<>();

        // adiciona apenas os vivos
        for (Combatente c : combatentesAL) {
            if (c.saude > 0)
                ordem.add(c);
        }

        for (Combatente c : combatentesHS) {
            if (c.saude > 0)
                ordem.add(c);
        }

        // embaralha a ordem de ataque
        Collections.shuffle(ordem);

        System.out.println("\n--- NOVA RODADA ---");

        for (Combatente atacante : ordem) {

            if (atacante.saude <= 0)
                continue; // pode ter morrido antes da vez

            ArrayList<Combatente> inimigos = combatentesAL.contains(atacante) ? combatentesHS : combatentesAL;

            Combatente alvo = escolherAlvoVivo(inimigos);

            if (alvo != null) {
                atacante.atacar(alvo);
            }
        }

    }
}
