public class Main {
    public static void main(String[] args) {
        Carta[] cartas = new Carta[2];

        for (int i = 0; i < 2; i++) {
            int val = gerarNumero();
            for (Carta c : Carta.values())
                if (c.ordinal() == val)
                    cartas[i] = c;
        }

        if (cartas[0].val == cartas[1].val) {
            System.out.println(
                    "Carta primeiro: " + cartas[0] +
                    "\nCarta segundo: " + cartas[1] +
                    "\nAs duas cartas tem " + "valor igual"
            );
            return;
        }

        boolean primeiraMaiorQueSegunda = cartas[0].val > cartas[1].val;
        System.out.println(
                "Carta primeiro: " + cartas[0] +
                "\nCarta segundo: " + cartas[1] +
                (primeiraMaiorQueSegunda ? "\nPrimeiro jogador ganhou" : "\nSegundo jogador ganhou")
        );
    }

    public static int gerarNumero() {
        int MIN = 0, MAX = 13;
        return (int) ((Math.random() * (MAX - MIN)) + MIN);
    }
}

enum Carta {
    REI(10), RAINHA(10), CORINGA(10), AS(10),
    UM(1), DOIS(2), TRES(3), QUATRO(4), CINCO(5), SEIS(6), SETE(7), OITO(8), NOVE(9), DEZ(10);

    public final int val;

    Carta(int val) {
        this.val = val;
    }
}