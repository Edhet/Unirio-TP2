import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(Conversor.indoarabicoParaRomano(102).get());
    }
}

final class Conversor {
    private static HashMap<Integer, String> CENTENAS, DEZENAS, UNIDADES;

    static {
        CENTENAS = new HashMap<>();
        CENTENAS.putAll(Map.of(
                1, "C",
                2, "CC",
                3, "CCC",
                4, "CD",
                5, "D",
                6, "DC",
                7, "DCC",
                8, "DCCC",
                9, "CM"
        ));

        DEZENAS = new HashMap<>();
        DEZENAS.putAll(Map.of(
                1, "X",
                2, "XX",
                3, "XXX",
                4, "XL",
                5, "L",
                6, "LX",
                7, "LXX",
                8, "LXXX",
                9, "XC"
        ));

        UNIDADES = new HashMap<>();
        UNIDADES.putAll(Map.of(
                1, "I",
                2, "II",
                3, "III",
                4, "IV",
                5, "V",
                6, "VI",
                7, "VII",
                8, "VIII",
                9, "IX"
        ));
    }

    private Conversor() {

    }

    public static Optional<String> indoarabicoParaRomano(int num) {
        if (num < 0 || num > 999)
            return Optional.empty();

        StringBuilder numeroRomano = new StringBuilder();

        String resultado = CENTENAS.get(num / 100);
        numeroRomano.append((resultado != null) ? resultado : "");

        resultado = DEZENAS.get(num / 10);
        numeroRomano.append((resultado != null) ? resultado : "");

        resultado = UNIDADES.get(num % 10);
        numeroRomano.append((resultado != null) ? resultado : "");

        return Optional.of(numeroRomano.toString());
    }
}
