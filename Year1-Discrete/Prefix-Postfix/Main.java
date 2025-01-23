public class Main {
    public static void main(String[] args) {
        String infix = "17 ^ 22 ^ (15 - 10) * (14 + (77 / 11))";
        InfixConverter newInfix = new InfixConverter(infix);
        System.out.println("Infix   : " + infix);
        newInfix.toPrefix();
        newInfix.toPostfix();
    }
}
