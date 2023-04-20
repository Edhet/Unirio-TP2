import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inputHearer = new Scanner(System.in);
        int n = inputHearer.nextInt();
        double[] grades = new double[n];

        System.out.println("Insira notas: ");
        for (int i = 0; i < n; i++)
            grades[i] = inputHearer.nextInt();

        double average = 0;
        for (double g : grades)
            average += g;
        average = average / n;
        System.out.println("Media de notas: "+average);

        System.out.println("Notas maiores que a media: ");
        for (double g : grades)
            if (g > average)
                System.out.println(g);
    }
}