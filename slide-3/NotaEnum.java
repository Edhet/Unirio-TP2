import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double i = s.nextDouble();
        Nota n = Nota.informarConceitoDeNota(i);
        System.out.println(n.toString());
    }
}

enum Nota {
    PESSIMO(0.0, 2.9), RUIM(3.0, 4.9), REGULAR(5.0, 6.9), BOM(7.0, 8.9), MUITOBOM(9.0, 10.0), INVALIDO(0.0, 0.0);
    public final double min, max;

    Nota(double min, double max) {
        this.min = min;
        this.max = max;
    }

    public static Nota informarConceitoDeNota(double nota) {
        for (Nota n : Nota.values()) {
            if (noIntervalo(n, nota))
                return n;
        }
        return Nota.INVALIDO;
    }

    private static boolean noIntervalo(Nota nota, double val) {
        return val <= nota.max && val >= nota.min;
    }
}