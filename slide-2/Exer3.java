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

        System.out.println("Insira P: ");
        int p = inputHearer.nextInt();

        if (p >= v.length || p < 0) {
            System.out.println("Posicao invalida")
            return;
        }

        int next, older = v[p];
        for (int i = p; i < v.length; i++) {
            if (i+1 >= v.length)
                break;
            next = v[i+1];
            v[i+1] = older;
            older = next;
        }
        v[p] = k;

        for (int value: v)
            System.out.print(value);
    }
}
