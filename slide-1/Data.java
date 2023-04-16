import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        String input;

        System.out.println("Crie uma data no formato: dd-mm-aaaa\nInsira 'SAIR' para sair.");
        while (true) {
            input = inputScanner.nextLine().trim();
            if (input.equalsIgnoreCase("SAIR"))
                return;

            Date dateInObject;
            try {
                dateInObject = new Date(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Data inserida e invalida.");
                continue;
            }

            System.out.println(dateInObject.getDate() + "\n" +
                    "Data Valida: " + dateInObject.isValidDate() + "\n" +
                    "Ano bisexto: " + dateInObject.isLeapYear() + "\n");
        }
    }
}

class Date {
    private int year, month, day;

    public Date(String timestamp) throws IllegalArgumentException {
        String[] timestampPieces = timestamp.split("-");

        if (timestampPieces.length != 3)
            throw new IllegalArgumentException("Invalid Timestamp Format");

        try {
            this.year = Integer.parseInt(timestampPieces[2]);
            this.month = Integer.parseInt(timestampPieces[1]);
            this.day = Integer.parseInt(timestampPieces[0]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }

        if (!validMonth())
            throw new IllegalArgumentException("Invalid Month Value");
        if (!validDay())
            throw new IllegalArgumentException("Invalid Day Value");
    }

    public String getDate() {
        return String.format("%s/%s/%s", this.day, this.month, this.year);
    }

    public boolean isLeapYear() {
        return (this.year % 4 == 0 && !(this.year % 100 == 0)) | this.year % 400 == 0;
    }

    public boolean isValidDate() {
        return true; //Se o objeto foi criado ele já é uma data válida
    }

    private boolean validDay() {
        final int[] daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (isLeapYear())
            daysInMonths[1] = 29;
        return day <= daysInMonths[this.month - 1] && this.day > 0;
    }

    private boolean validMonth() {
        return this.month < 12 && this.month > 0;
    }
}