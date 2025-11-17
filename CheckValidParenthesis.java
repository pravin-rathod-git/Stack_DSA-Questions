import java.util.Stack;

public class CheckValidParenthesis{

    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {

            // If opening bracket → push it
            if (c == '(' || c == '{' || c == '[') {
                st.push(c);
            } 
            else { 
                // If closing bracket and stack empty → invalid
                if (st.isEmpty()) return false;

                char top = st.pop();

                // Mismatch conditions
                if (c == ')' && top != '(') return false;
                if (c == '}' && top != '{') return false;
                if (c == ']' && top != '[') return false;
            }
        }

        // If stack is empty → all brackets matched correctly
        return st.isEmpty();
    }

    public static void main(String[] args) {
        CheckValidParenthesis sol = new CheckValidParenthesis();

        String test1 = "()";
        String test2 = "()[]{}";
        String test3 = "(]";
        String test4 = "([{}])";
        String test5 = "((";

        System.out.println(sol.isValid(test1)); // true
        System.out.println(sol.isValid(test2)); // true
        System.out.println(sol.isValid(test3)); // false
        System.out.println(sol.isValid(test4)); // true
        System.out.println(sol.isValid(test5)); // false
    }
}
