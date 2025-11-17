import java.util.*;

public class NextSmallerElement {

    public static int[] NextSmaller(int arr[]) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int[] nse = new int[n];

        for (int i = n - 1; i >= 0; i--) {

            // Pop all greater or equal elements
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }

            // Next smaller = top of stack OR -1
            nse[i] = stack.isEmpty() ? -1 : stack.peek();

            // Push current element
            stack.push(arr[i]);
        }

        return nse;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size
        int n = sc.nextInt();
        int[] arr = new int[n];

        // Input elements
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Call function
        int[] ans = NextSmaller(arr);

        // Print output
        for (int x : ans) {
            System.out.print(x + " ");
        }
    }
}
