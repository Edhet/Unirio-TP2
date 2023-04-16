import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bem-vindo à calculadora de funções quadráticas!");
        System.out.println("Favor entre com os valores de a, b e c:");

        Scanner keyboardScanner = new Scanner(System.in);
        double a = keyboardScanner.nextDouble();
        double b = keyboardScanner.nextDouble();
        double c = keyboardScanner.nextDouble();

        QuadraticFunction objFunc = new QuadraticFunction(a, b, c);

        System.out.printf("\nO objeto função criado é %s\n",
                objFunc.getFunctionDescription());
        System.out.printf("O X do vértice vale %f e o Y do vértice vale %f\n",
                objFunc.getXVertex(), objFunc.getYVertex());
        System.out.printf("As raízes da função valem %f e %f\n",
                objFunc.getNegativeRoot(), objFunc.getPositiveRoot());
        System.out.printf("A concavidade da função é %s\n",
                (Objects.equals(objFunc.getConcavitySide(), "Up")) ? "Cima" : "Baixo");
    }
}

class QuadraticFunction {
    private double a, b, c;

    public QuadraticFunction(double a, double b, double c) {
        setA(a);
        setB(b);
        setC(c);
    }

    public QuadraticFunction() {
        this.a = 1;
        this.b = 0;
        this.c = 0;
    }

    public String getFunctionDescription() {
        return String.format("f(x) = %fx² %fx %s%f", this.a, this.b, (this.c > 0) ? "+" : "", this.c);
    }

    public String getConcavitySide() {
        return (a < 0) ? "Down" : "Up";
    }

    public double getPositiveRoot() {
        return ((this.b * -1) + Math.sqrt(this.delta())) / (2 * a);
    }

    public double getNegativeRoot() {
        return ((this.b * -1) - Math.sqrt(this.delta())) / (2 * a);
    }

    public double getXVertex() {
        return (this.b * -1) / (2 * this.a);
    }

    public double getYVertex() {
        return (this.delta() * -1) / (4 * this.a);
    }

    private double delta() {
        return this.b * this.b - 4 * this.a * this.c;
    }

    public void setA(double a) {
        if (a != 0)
            this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setC(double c) {
        this.c = c;
    }
}
