public class Main {
    public static void main(String[] args) {
        Employee e1 = new Employee("Eu", "Silva", 1000.00);
        Employee e2 = new Employee("Tu", "Ferreira", 2400.00);

        System.out.println("\nAntes do aumento:");
        printEmpInfo(e1);
        printEmpInfo(e2);

        givePayrise(e1);
        givePayrise(e2);

        System.out.println("\nDepois do aumento:");
        printEmpInfo(e1);
        printEmpInfo(e2);
    }

    public static void givePayrise(Employee e) {
        final double salary = e.getMonthlySalary();
        e.setMonthlySalary(salary + salary * 0.2);
    }

    public static void printEmpInfo(Employee e) {
        System.out.println("Nome: " + e.getFirstName());
        System.out.println("Sobrenome: " + e.getLastName());
        System.out.println("Salario: " + e.getMonthlySalary());
    }
}

class Employee {
    private String firstName, lastName;
    private double monthlySalary;

    public Employee(String firstName, String lastName, double monthlySalary) {
        setFirstName(firstName);
        setLastName(lastName);
        setMonthlySalary(monthlySalary);
    }

    public Employee() {
        this.firstName = "";
        this.lastName = "";
        this.monthlySalary = 0;
    }

    public String getFirstName() {
        return firstName;
    }

    public boolean setFirstName(String firstName) {
        if (firstName.length() == 0)
            return false;
        this.firstName = firstName;
        return true;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean setLastName(String lastName) {
        if (lastName.length() == 0)
            return false;
        this.lastName = lastName;
        return true;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public boolean setMonthlySalary(double monthlySalary) {
        if (monthlySalary > 20000.0 || monthlySalary <= 0.0)
            return false;
        this.monthlySalary = monthlySalary;
        return true;
    }
}