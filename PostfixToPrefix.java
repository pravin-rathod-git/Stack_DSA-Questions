public class PostfixToPrefix {

    // Convert Postfix to Prefix
    public static String PostFixToPrefix(String str) {

        java.util.Stack<String> stack = new java.util.Stack<>();

        for (int i = 0; i < str.length(); i++) {

            char c = str.charAt(i);

            // If operand → push as string
            if (Character.isLetterOrDigit(c)) {
                stack.push(c + "");
            }
            // If operator → pop 2 operands and combine
            else {
                String op1 = stack.pop();  // first popped → right operand
                String op2 = stack.pop();  // second popped → left operand

                // Form prefix: operator + operand2 + operand1
                String expr = c + op2 + op1;

                // Push result back into stack
                stack.push(expr);
            }
        }

        // Final prefix expression is at stack top
        return stack.pop();
    }

    // MAIN FUNCTION
    public static void main(String[] args) {

        String postfix = "ab+c*";

        System.out.println("Postfix : " + postfix);
        System.out.println("Prefix  : " + PostFixToPrefix(postfix));
    }
}
