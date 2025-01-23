import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class ComputeRPN {
    public static void main(String[] args) {
        // MyStackA stackA = new MyStackA();
        MyStackL stackL = new MyStackL();
        Scanner in = new Scanner(System.in);
        String rpn = in.nextLine();
        StringTokenizer st = new StringTokenizer(rpn);

        while (st.hasMoreTokens()) {
            String t = st.nextToken();
            if (isNumeric(t))
                stackL.push(Double.parseDouble(t));
            else {
                double b = stackL.pop();
                double a = stackL.pop();
                if (t.equals("-")) {
                    stackL.push(a - b);
                } else if (t.equals("+")) {
                    stackL.push(a + b);
                } else if (t.equals("*")) {
                    stackL.push(a * b);
                } else if (t.equals("/")) {
                    stackL.push(a / b);
                }
            }
        }
        System.out.println(stackL);
        in.close();
    }

    private static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }
}
