import java.util.Scanner;

public class Main {

    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Main jogo = new Main();
        jogo.comecarJogo();
    }

    public void comecarJogo() {
    System.out.println("Começar uma nova batalha? (S/N)");
    String resp = sc.nextLine().trim();

    while (!resp.equalsIgnoreCase("S") && !resp.equalsIgnoreCase("N")) {
        System.out.println("Resposta inválida. Digite S ou N:");
        resp = sc.nextLine().trim();
    }

    if (resp.equalsIgnoreCase("S")) {
        Arena arena = new Arena();
        
        boolean adicionando = true;
        while (adicionando) {
            arena.adicionarPersonagem();
            
            System.out.println("Deseja adicionar outro combatente? (S/N)");
            String continuar = sc.nextLine().trim();
            if (continuar.equalsIgnoreCase("N")) {
                adicionando = false;
            }
        }
        
        System.out.println("\n=== A BATALHA VAI COMEÇAR! ===");
        arena.orquestrarJogo();
        
    } else {
        System.out.println("Fim do programa.");
    }
}
}
