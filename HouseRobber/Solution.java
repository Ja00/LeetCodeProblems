class Solution {
    public int rob(int[] nums) {
        int rob = 0;
        int noRob = 0;
        
        for(int n : nums) {
            int robCur = noRob + n;
            noRob = Math.max(rob, noRob);
            rob = robCur;
        }
        return Math.max(rob, noRob);
    }
}