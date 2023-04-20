import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inputHearer = new Scanner(System.in);

        System.out.println("Insira N: ");
        int n = inputHearer.nextInt();

        int[] v = new int[n];

        System.out.println("Insira vetor V: ");
        for (int i = 0; i < n; i++)
            v[i] = inputHearer.nextInt();

        System.out.println("Insira K: ");
        int k = inputHearer.nextInt();
        Integer[] counter = new Integer[n];
        int counterIndex = 0;

        for (int i = 0; i < v.length; i++)
            if (v[i] == k) {
                counter[counterIndex] = i;
                counterIndex++;
            }

        System.out.println("Posicoes de K em NV: ");
        int count = 0;
        for (Integer i : counter)
            if (i != null) {
                System.out.println(i);
                count++;
            }
        if (count == 0)
            System.out.println("Numero nao encontrado");
    }
}