public class PrefixToPostfix {

    // Convert Prefix to Postfix
    public static String PrefixtoPostfix(String str) {

        java.util.Stack<String> stack = new java.util.Stack<>();

        // Prefix is scanned from RIGHT to LEFT
        for (int i = str.length() - 1; i >= 0; i--) {

            char c = str.charAt(i);

            // If operand → push as string
            if (Character.isLetterOrDigit(c)) {
                stack.push(c + "");
            }
            // If operator
            else {
                String op1 = stack.pop(); // first operand
                String op2 = stack.pop(); // second operand

                // Form postfix: operand1 + operand2 + operator
                String expr = op1 + op2 + c;

                stack.push(expr);
            }
        }

        return stack.pop();
    }

    // MAIN FUNCTION
    public static void main(String[] args) {

        String prefix = "*+ab-cd";

        System.out.println("Prefix  : " + prefix);
        System.out.println("Postfix : " + PrefixtoPostfix(prefix));
    }
}
