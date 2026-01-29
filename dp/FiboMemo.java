// top-down approach with memoization
public class FiboMemo {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(fibTopDown(n)); // Output: 55
        System.out.println(fibBottomUp(n)); // Output: 55
        System.out.println(fibSpaceOptimized(n)); // Output: 55
    }


    //time complexity: O(n)
//space complexity: O(n)+O(n) for recursion stack
    public static int fibTopDown(int n) {
        int[] dp = new int[n + 1];
        return fibMemo(n, dp);
    }
    private static int fibMemo(int n, int[] dp) {
        if (n <= 1) {
            return n;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        dp[n] = fibMemo(n - 1, dp) + fibMemo(n - 2, dp);
        return dp[n];
    }

//time complexity: O(n)
//space complexity: O(n)
    private static int fibBottomUp(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
     }

     //time complexity: O(n)
     //space complexity: O(1)
        private static int fibSpaceOptimized(int n) {
            if (n <= 1) {
                return n;
            }
            int prev2 = 0; // F(0) 
            int prev1 = 1; // F(1)
            int current = 0;
            for (int i = 2; i <= n; i++) {
                current = prev1 + prev2; // F(n) = F(n-1) + F(n-2)
                prev2 = prev1;           // Move prev2 to F(n-1)
                prev1 = current;         // Move prev1 to F(n)
            }
            return current;
        }

}
