import java.util.Scanner;

    record Operands(double num1, double num2) {
}

public class Calculator {
    private static Operands enteringNumbers(Scanner sc) {
        double num1, num2;

        System.out.print("Enter first number: ");
        while (!sc.hasNextDouble()) {
            System.out.println("Sorry you entered an invalid number. Try again");
            sc.next();
        }
        num1 = sc.nextDouble();

        System.out.print("Enter second number: ");
        while (!sc.hasNextDouble()) {
            System.out.println("Sorry you entered an invalid number. Try again");
            sc.next();
        }
        num2 = sc.nextDouble();

        return new Operands(num1, num2);
    }

    private static double calculations(Operands operands, char operation) {
        double result = 0;
        switch (operation) {
            case '+':
             result = operands.num1() + operands.num2();
             break;
            case '-':
             result = operands.num1() - operands.num2();
             break;
            case '*':
             result = operands.num1() * operands.num2();
             break;
            case '/':
             result = operands.num1() / operands.num2();
             break;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String answer = "";
       do {
           Operands number = enteringNumbers(sc);

           System.out.print("Choose operation: +, -, *, /: ");
           char c = sc.next().charAt(0);

           if (c == '/' && number.num2() == 0) {
               System.out.println("No valid result");
               continue;
           }
           double result = calculations(number, c);
           System.out.printf("Result: %.2f\n", result);
           
           System.out.println("Continue working? (yes/no)");
           answer = sc.next();
       } while (answer.equals("yes") || answer.equals("y"));

        sc.close();
    }
}