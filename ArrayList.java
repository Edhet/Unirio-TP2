import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> lista = new ArrayList<>();

        Scanner input = new Scanner(System.in);

        while(true) {
            System.out.println("Insira a String: ");
            String inputString = input.nextLine();

            if (inputString.equals("")) {
                break;
            }

            if (!lista.contains(inputString)) {
                lista.add(inputString);
            }
        }

        for (int j = lista.size() - 1; j >= 0; j--) {
            System.out.println(lista.get(j));
        }

        ArrayList<ContadorDeLetra> letras = new ArrayList<>();

        Scanner input = new Scanner(System.in);
        String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        String inputString = input.nextLine().trim().toUpperCase();

        for (char c : alfabeto.toCharArray()) {
            ContadorDeLetra novaLetra = new ContadorDeLetra(c, 0);
            letras.add(novaLetra);
        }

        for (char c : inputString.toCharArray())
            for (ContadorDeLetra l : letras)
                if (l.letra == c) {
                    l.quantidade++;
                    break;
                }

        for (ContadorDeLetra l : letras)
            System.out.println("Letra: " + l.letra + ", Quantidade: " + l.quantidade + ".");
    }
}

        class ContadorDeLetra {
            public char letra;
            public int quantidade;

            public ContadorDeLetra(char letra, int quantidade) {
                this.letra = letra;
                this.quantidade = quantidade;
            }
        }