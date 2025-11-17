public class InfixToPrefix {

    // Function to return precedence of operators
    public static int precedence(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    // ================================
    // INFIX → POSTFIX (Helper function)
    // ================================
    public static String infixToPostfix(String s) {

        StringBuilder result = new StringBuilder();
        java.util.Stack<Character> stack = new java.util.Stack<>();

        for (char c : s.toCharArray()) {

            // If operand -> add to result
            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            }
            // If '(' -> push to stack
            else if (c == '(') {
                stack.push(c);
            }
            // If ')' -> pop until '('
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop(); // Remove '('
            }
            // Operator encountered
            else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }

        // Pop all remaining operators
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    // ====================================
    // INFIX → PREFIX (Main Conversion Logic)
    // ====================================
    public static String InfixToPrefixEx(String s) {

        // Step 1: Reverse the string
        StringBuilder input = new StringBuilder(s);
        input.reverse();

        // Step 2: Swap '(' with ')'
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(')
                input.setCharAt(i, ')');
            else if (input.charAt(i) == ')')
                input.setCharAt(i, '(');
        }

        // Step 3: Convert reversed expression to postfix
        String postfix = infixToPostfix(input.toString());

        // Step 4: Reverse postfix → prefix
        return new StringBuilder(postfix).reverse().toString();
    }

    // ======================
    // MAIN FUNCTION
    // ======================
    public static void main(String[] args) {

        String infix = "a+b*(c^d-e)^(f+g*h)-i";

        System.out.println("Infix Expression : " + infix);

        String prefix = InfixToPrefixEx(infix);

        System.out.println("Prefix Expression : " + prefix);
    }
}
