class Solution {
    
    private int[][][] dp;

    public int numTeams(int[] rating) {
        
        int n = rating.length;
        dp = new int[n][n][4];
        
        for (int[][] mat : dp) {
            for (int[] row : mat) 
                Arrays.fill(row, -1);
        }

        int ans = solve(n - 1, -1, 0, rating);
        
        for (int[][] mat : dp) {
            for (int[] row : mat) 
                Arrays.fill(row, -1); 
        }

        reverse(rating);
        ans += solve(n - 1, -1, 0, rating);
        return ans;
    }

    private int solve(int idx, int lastIdx, int k, int[] rating) {
        if (k == 3) return 1;
        if (idx < 0) return 0;

        if (lastIdx != -1 && dp[idx][lastIdx][k] != -1) 
            return dp[idx][lastIdx][k];

        int notTaken = solve(idx - 1, lastIdx, k, rating);
        int taken = 0;

        if (lastIdx == -1 || rating[idx] > rating[lastIdx]) 
            taken = solve(idx - 1, idx, k + 1, rating);
        
        if (lastIdx == -1) 
            lastIdx = 0;

        return dp[idx][lastIdx][k] = taken + notTaken;
    }

    private void reverse(int[] arr) {
        
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
