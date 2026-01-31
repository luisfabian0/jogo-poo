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

        if (equipeCombatente.equalsIgnoreCase("A") && combatentesAL.size() >= 3) {
            System.out.println("A Aliança da Luz já possui 3 combatentes. Escolha outra equipe.");
            return;
        }

        if (equipeCombatente.equalsIgnoreCase("B") && combatentesHS.size() >= 3) {
            System.out.println("A Horda das Sombras já possui 3 combatentes. Escolha outra equipe.");
            return;
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

        personagem = CombatenteFactory.criar(tipoCombatente, nomeCombatente, expCombatente);

        if (equipeCombatente.equals("A")) {
            combatentesAL.add(personagem);
        } else {
            combatentesHS.add(personagem);
        }

    }

    public Combatente escolherAlvoVivo(ArrayList<Combatente> equipe) {

        ArrayList<Combatente> vivos = new ArrayList<>();

        for (Combatente c : equipe) {
            if (c.estaVivo())
                vivos.add(c);
        }

        if (vivos.isEmpty())
            return null;

        Collections.shuffle(vivos);
        return vivos.get(0);
    }

    public boolean equipeViva(ArrayList<Combatente> equipe) {
        for (Combatente c : equipe) {
            if (c.estaVivo()) {
                return true;
            }
        }
        return false;
    }

    private void imprimirPlacar() {
        System.out.println("\n*** SITUAÇÃO ATUAL ***");
        System.out.println("--- Aliança da Luz --- \n");
        for (Combatente c : combatentesAL) {
            String status = c.estaVivo() ? c.getSaude() + " PV" : "MORTO";
            System.out.println(c.getNome() + " [" + c.getClass().getSimpleName() + "]: " + status );
        }

        System.out.println("--- Horda das Sombras --- \n");
        for (Combatente c : combatentesHS) {
            String status = c.estaVivo() ? c.getSaude() + " PV" : "MORTO";
            System.out.println(c.getNome() + " [" + c.getClass().getSimpleName() + "]: " + status);
        }
        System.out.println("**********************\n");
    }

    public void orquestrarJogo() {

        while (equipeViva(combatentesHS) && equipeViva(combatentesAL)) {
            Collections.shuffle(combatentesAL);
            Collections.shuffle(combatentesHS);

            orquestrarRodada();
        }

        if(equipeViva(combatentesAL)){
            System.out.println("A ALIANÇA DA LUZ VENÇEU!");
        }else{
            System.out.println("A HORDA DAS SOMBRAS VENÇEU!");
        }

        return;
    }

    public void orquestrarRodada() {

        ArrayList<Combatente> ordem = new ArrayList<>();

        // adiciona apenas os vivos
        for (Combatente c : combatentesAL) {
            if (c.estaVivo())
                ordem.add(c);
        }

        for (Combatente c : combatentesHS) {
            if (c.estaVivo())
                ordem.add(c);
        }

        // embaralha a ordem de ataque
        Collections.shuffle(ordem);

        System.out.println("\n--- NOVA RODADA ---");

        for (Combatente atacante : ordem) {

            if (!atacante.estaVivo())
                continue; // pode ter morrido antes da vez

            ArrayList<Combatente> inimigos = combatentesAL.contains(atacante) ? combatentesHS : combatentesAL;

            Combatente alvo = escolherAlvoVivo(inimigos);

            if (alvo != null) {
                atacante.atacar(alvo);
            }
        }
        imprimirPlacar();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
    }
}
