import java.util.*;

class Solution {

    public int sumSubarrayMins(int[] arr) {
        int[] nse = nextSmaller(arr);    // Next Smaller Element (right)
        int[] pse = prevSmaller(arr);    // Previous Smaller Element (left)

        long total = 0;
        int mod = 1_000_000_007;

        for (int i = 0; i < arr.length; i++) {
            long left = i - pse[i];
            long right = nse[i] - i;

            long contribution = (left * right % mod) * arr[i] % mod;
            total = (total + contribution) % mod;
        }

        return (int) total;
    }

    // NEXT SMALLER ELEMENT (Right)
    public int[] nextSmaller(int[] arr) {
        int n = arr.length;
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return nse;
    }

    // PREVIOUS SMALLER ELEMENT (Left)
    public int[] prevSmaller(int[] arr) {
        int n = arr.length;
        int[] pse = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return pse;
    }

    // MAIN FUNCTION
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] arr = {3, 1, 2, 4};

        int result = sol.sumSubarrayMins(arr);

        System.out.println("Sum of Subarray Minimums = " + result);
    }
}
