import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankAccount newAccount = new BankAccount(0.0);
        Scanner inputScanner = new Scanner(System.in);
        String input;

        System.out.println("Escolha operacao: SACAR <valor>, DEPOSITAR <valor>, CHECAR, SAIR");
        while (true) {
            input = inputScanner.nextLine();
            String[] arguments = input.split(" ");
            switch (arguments[0].trim().toUpperCase()) {
                case "SACAR" -> withdrawMoney(newAccount, arguments);
                case "DEPOSITAR" -> depositMoney(newAccount, arguments);
                case "CHECAR" -> checkBalance(newAccount);
                case "SAIR" -> {
                    return;
                }
            }
        }
    }

    private static void checkBalance(BankAccount newAccount) {
        System.out.printf("Balanco: %.2f\n", newAccount.getBalance());
    }

    private static void depositMoney(BankAccount newAccount, String[] arguments) {
        if (arguments.length != 2) {
            System.out.println("Parametros invalidos.");
            return;
        }

        double argument;
        try {
            argument = Double.parseDouble(arguments[1]);
            final double newBalance = newAccount.depositToBalance(argument);
            System.out.printf("Novo balanco: %.2f\n", newBalance);
        } catch (NumberFormatException e) {
            System.out.println("Parametro nao e numero.");
        }
    }

    private static void withdrawMoney(BankAccount newAccount, String[] arguments) {
        if (arguments.length != 2) {
            System.out.println("Parametros invalidos.");
            return;
        }

        double argument;
        try {
            argument = Double.parseDouble(arguments[1]);
            final double newBalance = newAccount.withdrawFromBalance(argument);
            System.out.printf("Novo balanco: %.2f\n", newBalance);
        } catch (NumberFormatException e) {
            System.out.println("Parametro nao e numero.");
        } catch (Exception e) {
            System.out.println("Saldo insuficiente");
        }
    }
}

class BankAccount {
    private double balance;

    public BankAccount(double startingMoney) {
        setBalance(startingMoney);
    }

    public double depositToBalance(double amount) {
        if (amount > 0)
            this.balance += amount;
        return this.balance;
    }

    public double withdrawFromBalance(double amount) throws Exception {
        if (hasEnoughBalanceToWithdraw())
            this.balance -= amount + 1.5;
        else
            throw new Exception("Invalid Balance Error");
        return this.balance;
    }

    private boolean hasEnoughBalanceToWithdraw() {
        return this.balance > 1.5;
    }

    public boolean setBalance(double balance) {
        if (balance <= 0)
            return false;
        this.balance = balance;
        return true;
    }

    public double getBalance() {
        return balance;
    }
}
