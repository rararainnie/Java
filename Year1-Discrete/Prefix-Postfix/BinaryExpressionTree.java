import java.util.Stack;

class ExpressionNode {
    public char value;
    public ExpressionNode left;
    public ExpressionNode right;

    public ExpressionNode(char value) {
        this.value = value;
    }
}

public class BinaryExpressionTree {
    private String postfix;

    public BinaryExpressionTree(String postfix) {
        this.postfix = postfix;
    }

    public ExpressionNode buildTree() {
        Stack<ExpressionNode> stack = new Stack<>();
        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);
            if (Character.isDigit(c)) {
                ExpressionNode node = new ExpressionNode(c);
                stack.push(node);
            } else {
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Invalid postfix expression");
                }
                ExpressionNode right = stack.pop();
                ExpressionNode left = stack.pop();
                ExpressionNode node = new ExpressionNode(c);
                node.left = left;
                node.right = right;
                stack.push(node);
            }
        }
        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid postfix expression");
        }
        return stack.pop();
    }

    private void printTree(ExpressionNode node, int level) {
        if (node == null) {
            return;
        }
        printTree(node.right, level + 1);
        for (int i = 0; i < level; i++) {
            System.out.print("     ");
        }
        System.out.println(node.value);
        printTree(node.left, level + 1);
    }

    public void printTree() {
        ExpressionNode root = buildTree();
        printTree(root, 0);
    }
}
