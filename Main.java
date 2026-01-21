import java.util.Scanner;

public class Main {

    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
    
    }

    public void comecarJogo() {
        
        System.out.println("Começar uma nova batalha? (S/N)");
        String resp = sc.nextLine().trim();

        while (!resp.equalsIgnoreCase("S") && !resp.equalsIgnoreCase("N")) {
            System.out.println("Resposta inválida. Digite S ou N:");
            resp = sc.nextLine().trim();
        }

        if(resp.equalsIgnoreCase("S")){
            Arena arena = new Arena();
            arena.adicionarPersonagem();
        }else{
            return;
        }

    }
}
