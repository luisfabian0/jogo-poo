public class CombatenteFactory {

    public static Combatente criar(String tipo, String nome, int exp) {
        return switch (tipo.toUpperCase()) {
            case "T" -> new Tanque(nome, exp);
            case "M" -> new Mago(nome, exp);
            case "A" -> new Atirador(nome, exp);
            default -> throw new IllegalArgumentException("Tipo inválido");
        };
    }
}