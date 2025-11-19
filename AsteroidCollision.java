import java.util.*;

public class AsteroidCollision {

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int num : asteroids) {
            if (num > 0) {
                stack.push(num);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(num)) {
                    stack.pop();
                }

                if (!stack.isEmpty() && stack.peek() > 0 && stack.peek() == Math.abs(num)) {
                    stack.pop();
                    continue;
                }

                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(num);
                }
            }
        }

        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }

    // -------------------------------
    //            MAIN METHOD
    // -------------------------------
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] asteroids = {5, 10, -5};
        int[] result = sol.asteroidCollision(asteroids);

        System.out.print("Output: ");
        for (int x : result) {
            System.out.print(x + " ");
        }
    }
}
