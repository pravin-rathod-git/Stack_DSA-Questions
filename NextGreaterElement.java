import java.util.*;

public class NextGreaterElement {

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        java.util.Stack<Integer> stack = new java.util.Stack<>();

        int n1 = nums1.length;
        int n2 = nums2.length;

        for (int i = n2 - 1; i >= 0; i--) {

            // Pop all smaller elements
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                stack.pop();
            }

            // If stack empty → no next greater
            if (stack.isEmpty()) {
                map.put(nums2[i], -1);
            } else {
                map.put(nums2[i], stack.peek());
            }

            // Push current element
            stack.push(nums2[i]);
        }

        // Prepare result for nums1
        int[] ans = new int[n1];
        for (int i = 0; i < n1; i++) {
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input nums1
        int n1 = sc.nextInt();
        int[] nums1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            nums1[i] = sc.nextInt();
        }

        // Input nums2
        int n2 = sc.nextInt();
        int[] nums2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            nums2[i] = sc.nextInt();
        }

        int[] ans = nextGreaterElement(nums1, nums2);

        // Print result
        for (int x : ans) {
            System.out.print(x + " ");
        }
    }
}
