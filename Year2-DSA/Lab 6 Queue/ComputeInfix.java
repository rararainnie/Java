import java.util.*;

public class ComputeInfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an infix expression: ");
        String input = scanner.nextLine();
        scanner.close();

        MyQueueL rpnQueue = shuntingYard(input);
        System.out.println("RPN Expression: " + rpnQueue.toString());

        double result = evaluateRPN(rpnQueue);
        System.out.println("Result: " + result);
    }

    public static MyQueueL shuntingYard(String infixExpression) {
        MyQueueL rpnQueue = new MyQueueL();
        Stack<Character> operatorStack = new Stack<>();
        Map<Character, Integer> precedence = Map.of('+', 1, '-', 1, '*', 2, '/', 2);

        StringTokenizer tokenizer = new StringTokenizer(infixExpression);
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            char c = token.charAt(0);

            if (Character.isDigit(c)) {
                rpnQueue.enqueue(token);
            } else if (isOperator(c)) {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(' &&
                        precedence.get(operatorStack.peek()) >= precedence.get(c)) {
                    rpnQueue.enqueue(String.valueOf(operatorStack.pop()));
                }
                operatorStack.push(c);
            } else if (c == '(') {
                operatorStack.push(c);
            } else if (c == ')') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    rpnQueue.enqueue(String.valueOf(operatorStack.pop()));
                }
                operatorStack.pop(); // Pop the '('
            }
        }

        while (!operatorStack.isEmpty()) {
            rpnQueue.enqueue(String.valueOf(operatorStack.pop()));
        }

        return rpnQueue;
    }

    public static double evaluateRPN(MyQueueL rpnQueue) {
        Stack<Double> operandStack = new Stack<>();

        while (!rpnQueue.isEmpty()) {
            String token = rpnQueue.dequeue();
            if (isNumeric(token)) {
                operandStack.push(Double.parseDouble(token));
            } else if (isOperator(token.charAt(0))) {
                double b = operandStack.pop();
                double a = operandStack.pop();
                double result = applyOperator(a, b, token.charAt(0));
                operandStack.push(result);
            }
        }

        return operandStack.pop();
    }

    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    public static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    public static double applyOperator(double a, double b, char operator) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}