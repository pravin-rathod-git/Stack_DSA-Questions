import java.util.*;

public class SumOfSubArrayRanges {

    // ---------- FUNCTION TO CALCULATE SUM OF SUBARRAY RANGES ----------
    public static long subArrayRanges(int[] nums) {
        return sumSubarrayMax(nums) - sumSubarrayMin(nums);
    }

    // ---------- SUM OF SUBARRAY MINIMUMS ----------
    public static long sumSubarrayMin(int[] arr) {
        int n = arr.length;
        int[] nse = nextSmaller(arr);
        int[] pse = prevSmaller(arr);

        long result = 0;
        for (int i = 0; i < n; i++) {
            long left = i - pse[i];
            long right = nse[i] - i;
            result += (long) arr[i] * left * right;
        }
        return result;
    }

    // next smaller element
    private static int[] nextSmaller(int[] arr) {
        int n = arr.length;
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                nse[st.pop()] = i;
            }
            st.push(i);
        }
        while (!st.isEmpty()) nse[st.pop()] = n;
        return nse;
    }

    // previous smaller element
    private static int[] prevSmaller(int[] arr) {
        int n = arr.length;
        int[] pse = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                pse[st.pop()] = i;
            }
            st.push(i);
        }
        while (!st.isEmpty()) pse[st.pop()] = -1;
        return pse;
    }

    // ---------- SUM OF SUBARRAY MAXIMUMS ----------
    public static long sumSubarrayMax(int[] arr) {
        int n = arr.length;
        int[] nge = nextGreater(arr);
        int[] pge = prevGreater(arr);

        long result = 0;
        for (int i = 0; i < n; i++) {
            long left = i - pge[i];
            long right = nge[i] - i;
            result += (long) arr[i] * left * right;
        }
        return result;
    }

    // next greater element
    private static int[] nextGreater(int[] arr) {
        int n = arr.length;
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                nge[st.pop()] = i;
            }
            st.push(i);
        }
        while (!st.isEmpty()) nge[st.pop()] = n;
        return nge;
    }

    // previous greater element
    private static int[] prevGreater(int[] arr) {
        int n = arr.length;
        int[] pge = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                pge[st.pop()] = i;
            }
            st.push(i);
        }
        while (!st.isEmpty()) pge[st.pop()] = -1;
        return pge;
    }

    // ---------------- MAIN FUNCTION ----------------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        long result = subArrayRanges(arr);

        System.out.println("Sum of Subarray Ranges = " + result);
    }
}
