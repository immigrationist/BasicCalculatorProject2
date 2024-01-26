import java.util.Scanner;
import java.util.InputMismatchException;

public class BasicCalculator{
    public static double performArithmeticOperation(int num1, int num2, char operation){
        double result = 0.0;

        if(operation == '+')
            result = num1 + num2;
        else if(operation == '-')
            result = num1 - num2;
        else if(operation == 'x')
            result = num1 * num2;
        else if(operation == '/')
            result = num1 / num2;
        else
            System.out.println("Invalid character!");

        return result;
    }

    public static int evaluateStatusCode(int num2, char operation){
        int statusCode;

        if(operation != '+' && operation != '-' && operation != 'x' && operation != '/')
            statusCode = 0;
        else if(num2 == 0 && operation == '/')
            statusCode = 1;
        else
            statusCode = 2;

        return statusCode;
    }
    public static void main(String[] args) {
        int num1;
        int num2;
        char operation;
        String answer = "yes";
        double result;
        int statusCode;

        Scanner scanner = new Scanner(System.in);

            while (answer.equalsIgnoreCase("yes")) {
                try {
                    System.out.println("Please enter first number");
                    num1 = scanner.nextInt();
                    System.out.println("Please enter second number");
                    num2 = scanner.nextInt();
                    System.out.println("Please enter operation from the given options: +, -, x, /");
                    operation = scanner.next().charAt(0);

                    statusCode = evaluateStatusCode(num2, operation);

                    if (statusCode == 2) {
                        result = performArithmeticOperation(num1, num2, operation);
                        System.out.println("the result is: " + result);
                    }
                    else if (statusCode == 1)
                        System.out.println("Can't divide by 0!!!");
                    else
                        System.out.println("Invalid input for operation, please choose between" +
                                "+, -, x, /");
                }
                catch (InputMismatchException ime) {
                    System.out.println("Input problem!");
                    scanner.next();
                }
                catch (Exception e) {
                    System.out.println("Keyboard malfunctioned!");
                }

                System.out.println("Would you like to try again, yes/no");
                answer = scanner.next();
            }
     }
}
