import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stdinScanner = new Scanner(System.in);

        String stringInput;
        int intInput;

        Class usrClass = null;

        while(true) {
            System.out.println("Insira o nome da turma.");
            stringInput = stdinScanner.nextLine().trim();
            try {
                usrClass = new Class(stringInput);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Nome da turma e invalido.");
            }
        }

        while(true) {
            System.out.println("Digite <SAIR> para parar de inserir e exibir alunos da turma OU digite o nome do aluno.");
            stringInput = stdinScanner.nextLine().trim();
            if (stringInput.equalsIgnoreCase("SAIR"))
                break;

            System.out.println("Digite a idade do aluno.");
            while (true) {
                try {
                    intInput = stdinScanner.nextInt();
                    break;
                } catch (NoSuchElementException e) {
                    System.out.println("Idade precisa ser numero inteiro.");
                } finally {
                    stdinScanner.nextLine();
                }
            }

            try {
                Student newStudent = new Student(stringInput, intInput);
                usrClass.addStudent(newStudent);
            } catch (IllegalArgumentException e) {
                System.out.println("Aluno tem valores invalidos.");
            }
        }

        usrClass.printStudents();
    }
}

class Class {
    private String name;
    private List<Student> students = new ArrayList<>();

    public Class(String name) throws IllegalArgumentException {
        setName(name);
    }

    public void printStudents() {
        System.out.println("Turma: "+this.name);
        for (Student s : this.students)
            s.printInformation();
    }

    public void addStudent(Student s) {
        this.students.add(s);
    }

    public void setName(String name) throws IllegalArgumentException {
        if (name.isEmpty())
            throw new IllegalArgumentException();
        this.name = name;
    }
}

class Student {
    private String name;
    private int age;

    public Student(String name, int age) throws IllegalArgumentException {
        setAge(age);
        setName(name);
    }

    public void printInformation() {
        System.out.println("Nome: "+this.name+" Idade: "+this.age);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) throws IllegalArgumentException {
        if (name.isEmpty())
            throw new IllegalArgumentException();
        this.name = name;
    }

    public void setAge(int age) throws IllegalArgumentException {
        if (age <= 0)
            throw new IllegalArgumentException();
        this.age = age;
    }
}
