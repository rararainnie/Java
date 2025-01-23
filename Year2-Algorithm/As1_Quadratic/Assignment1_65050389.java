import java.util.Scanner;

public class Assignment1_65050389 {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        double a, b, c;

        System.out.print("Input a = ");
        a = userInput.nextDouble();
        System.out.print("Input b = ");
        b = userInput.nextDouble();
        System.out.print("Input c = ");
        c = userInput.nextDouble();

        if (a == 0) {
            if (b != 0) {
                System.out.printf("x = %.2f\n", (-c / b));
            } else {
                System.out.println("Not a valid quadratic equation.");
            }
        } else {
            double discriminant = Math.pow(b, 2) - 4 * a * c;
            System.out.print("\nOutput: ");

            if (discriminant < 0) {
                double realPart = -b / (2 * a);
                double imgPart = Math.sqrt(-discriminant) / (2 * a);
                System.out.printf("x = %.2f + %.2fi or %.2f - %.2fi\n", realPart, imgPart, realPart, imgPart);
            } else {
                double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
                System.out.printf("x = %.2f or %.2f\n", x1, x2);
            }
        }

        userInput.close();
    }
}
