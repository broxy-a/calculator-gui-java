import java.util.Scanner;

public class Calculator {
    private static double[] enteringNumbers(Scanner sc) {
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

        return new double[]{num1, num2};
    }

    private static double calculations(double[] numbers, char operation) {
        double result = 0;
        switch (operation) {
            case '+':
             result = numbers[0] + numbers[1];
             break;
            case '-':
             result = numbers[0] - numbers[1];
             break;
            case '*':
             result = numbers[0] * numbers[1];
             break;
            case '/':
             result = numbers[0] / numbers[1];
             break;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String answer = "";
       do {
           double[] nums = enteringNumbers(sc);

           System.out.print("Choose operation: +, -, *, /: ");
           char c = sc.next().charAt(0);

           if (c == '/' && nums[1] == 0) {
               System.out.println("No valid result");
               continue;
           }
           double result = calculations(nums, c);
           System.out.printf("Result: %.2f\n", result);
           
           System.out.println("Continue working? (yes/no)");
           answer = sc.next();
       } while (answer.equals("yes") || answer.equals("y"));

        sc.close();
    }
}