import java.util.Scanner;

record Operands(double num1, double num2) {}

public class Calculator {
    private static Operands enteringNumbers(Scanner sc) {
        double num1, num2;

        System.out.print("Enter first number: ");
        while (!sc.hasNextDouble()) {
            System.out.println("Sorry you entered an invalid number. Try again");
            System.out.print("Enter first number: ");
            sc.next();
        }
        num1 = sc.nextDouble();

        System.out.print("Enter second number: ");
        while (!sc.hasNextDouble()) {
            System.out.println("Sorry you entered an invalid number. Try again");
            System.out.print("Enter second number: ");
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
            default:
                throw new IllegalArgumentException("Unknown operation");
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String answer = "";
       do {
           Operands number = enteringNumbers(sc);

           System.out.print("Choose operation: +, -, *, /, %: ");
           char c = sc.next().charAt(0);

           double result = 0;
           try {
               if (c == '/' && number.num2() == 0) {
                   throw new ArithmeticException("divide by zero is impossible");
               }
               result = calculations(number, c);
           } catch (IllegalArgumentException | ArithmeticException e) {
               System.out.println("Error: " + e.getMessage());
           }

           System.out.printf("Result: %.2f\n", result);
           
           System.out.println("Continue working? (yes/no)");
           answer = sc.next().toLowerCase();
       } while (answer.equals("yes") || answer.equals("y"));

        sc.close();
    }
}
