import java.util.*;

public class NGEinCircular {

    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] nge = new int[n];
        java.util.Stack<Integer> stack = new java.util.Stack<>();

        // Traverse twice for circular behavior
        for (int i = 2 * n - 1; i >= 0; i--) {

            // Pop all smaller or equal elements
            while (!stack.isEmpty() && stack.peek() <= nums[i % n]) {
                stack.pop();
            }

            // Fill result during the first pass (i < n)
            if (i < n) {
                nge[i] = stack.isEmpty() ? -1 : stack.peek();
            }

            // Push current number
            stack.push(nums[i % n]);
        }

        return nge;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size
        int n = sc.nextInt();
        int[] nums = new int[n];

        // Input array elements
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Call function
        int[] ans = nextGreaterElements(nums);

        // Print output
        for (int x : ans) {
            System.out.print(x + " ");
        }
    }
}
