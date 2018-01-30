//The key part is to determine the sub-problem sets

//Here the sub problem should be with i 0s and j 1s, the maximum # of strings I can form,
//but not thinking regarding to the array size.

class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        
        for(String str : strs) {
            int[] count = count(str);
            for(int i = m; i >= count[0]; i--) {
                for(int j = n; j >= count[1]; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-count[0]][j-count[1]] + 1);
                }
            }
        }
        return dp[m][n];
    }
    
    public int[] count(String str) {
        int[] count = new int[2];
        char[] arr = str.toCharArray();
        for(char ch : arr) {
            count[ch - '0']++;
        }
        return count;
    }
}