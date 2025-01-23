import java.util.Stack;

public class InfixConverter {
    private String infix;

    public InfixConverter(String infix) {
        this.infix = infix;
    }

    private boolean arithmeticMath(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }

    private int precedence(char c) {
        switch (c) {
            case '^':
                return 3;
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                return 0;
        }
    }

    public void toPrefix() {
        Stack<Character> operatorStack = new Stack<>();
        StringBuilder prefix = new StringBuilder();

        for (int i = infix.length() - 1; i >= 0; i--) {
            char c = infix.charAt(i);
            if (Character.isDigit(c)) {
                StringBuilder operand = new StringBuilder();
                operand.append(c);
                while (i > 0 && Character.isDigit(infix.charAt(i - 1))) {
                    operand.insert(0, infix.charAt(i - 1));
                    i--;
                }
                prefix.append(operand.reverse()).append(" ");
            } else if (c == ')') {
                operatorStack.push(c);
            } else if (c == '(') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != ')') {
                    prefix.append(operatorStack.pop()).append(" ");
                }
                operatorStack.pop();
            } else if (arithmeticMath(c)) {
                while (!operatorStack.isEmpty() && operatorStack.peek() != ')'
                        && precedence(c) < precedence(operatorStack.peek())) {
                    prefix.append(operatorStack.pop()).append(" ");
                }
                operatorStack.push(c);
            }
        }

        while (!operatorStack.isEmpty()) {
            prefix.append(operatorStack.pop()).append(" ");
        }
        System.out.println("Prefix  : " + prefix.reverse().toString());
    }

    public void toPostfix() {
        Stack<Character> operatorStack = new Stack<>();
        StringBuilder postfix = new StringBuilder();
        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);
            if (Character.isDigit(c)) {
                StringBuilder operand = new StringBuilder();
                operand.append(c);
                while (i < infix.length() - 1 && Character.isDigit(infix.charAt(i + 1))) {
                    operand.append(infix.charAt(++i));
                }
                postfix.append(operand).append(" ");
            } else if (c == '(') {
                operatorStack.push(c);
            } else if (c == ')') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    postfix.append(operatorStack.pop()).append(" ");
                }
                operatorStack.pop();
            } else if (arithmeticMath(c)) {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '('
                        && precedence(c) <= precedence(operatorStack.peek())) {
                    postfix.append(operatorStack.pop()).append(" ");
                }
                operatorStack.push(c);
            }
        }

        while (!operatorStack.isEmpty()) {
            postfix.append(operatorStack.pop()).append(" ");
        }
        System.out.println("Postfix : " + postfix.toString().trim());
    }
}
