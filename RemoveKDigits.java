import java.util.*;

public class RemoveKDigits {

    public String removeKdigits(String num, int k) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);

            // Remove larger previous digits to make number smallest
            while (!stack.isEmpty() && k > 0 && stack.peek() > c) {
                stack.pop();
                k--;
            }

            stack.push(c);
        }

        // If still digits need to be removed, remove from end
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        // Build result
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }

        res.reverse();

        // Remove leading zeros
        while (res.length() > 0 && res.charAt(0) == '0') {
            res.deleteCharAt(0);
        }

        // If empty, return "0"
        return (res.length() == 0) ? "0" : res.toString();
    }

    // ----------------------
    //       MAIN METHOD
    // ----------------------
    public static void main(String[] args) {
        Solution sol = new Solution();

        String num = "1432219";
        int k = 3;

        String result = sol.removeKdigits(num, k);

        System.out.println("Output: " + result);
    }
}
