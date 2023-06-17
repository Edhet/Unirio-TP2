import java.util.*;

public class Main {
    public static void main(String[] args) {
        Proteina proteina = new Proteina("UUUCUUAAG");
        System.out.println(proteina.getNome());
        System.out.println(proteina.getTrincas());
    }
}

class Proteina {
    private static final HashMap<String, String> NOMES;

    static {
        NOMES = new HashMap<>();
        NOMES.putAll(Map.of(
                "UUU", "Phe",
                "CUU", "Leu",
                "UUA", "Loa",
                "AAG", "Lisina",
                "UCU", "Ser",
                "UAU", "Tyr",
                "CAA", "Gin"
        ));
    }

    private List<String> trincas;
    private String nome;

    public Proteina(String sequencia) throws IllegalArgumentException {
        if (sequencia.length() % 3 != 0)
            throw new IllegalArgumentException("Numero de caracteres na sequencia de trincas invalido");
        separarTrincas(sequencia);
        gerarNome();
    }

    private void separarTrincas(String sequencia) {
        trincas = new ArrayList<>();
        StringBuilder trinca;
        for (int i = 0; i < sequencia.length(); i += 3) {
            trinca = new StringBuilder();
            for (int j = i; j < i + 3; j++)
                trinca.append(sequencia.charAt(j));
            trincas.add(trinca.toString());
        }
    }

    private void gerarNome() throws IllegalArgumentException {
        StringBuilder nome = new StringBuilder();
        for (String trinca : trincas) {
            String nomeAmino = NOMES.get(trinca);

            if (nomeAmino == null)
                throw new IllegalArgumentException("Trinca com nome nao especificado inserida");

            nome.append(nomeAmino).append("-");
        }

        final int LAST_CHAR = nome.length() - 1;
        if (nome.charAt(LAST_CHAR) == '-')
            nome.deleteCharAt(LAST_CHAR);

        this.nome = nome.toString();
    }

    public String getNome() {
        return nome;
    }

    public List<String> getTrincas() {
        return trincas;
    }
}
