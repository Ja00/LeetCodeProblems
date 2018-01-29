//Since it's a circle, we can devide the problem into 2 possible situations.
//[0, n-2] and [1, n-1]

class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }

        //Get the max from two situations.
        return Math.max(helper(nums, 0, nums.length - 2), helper(nums, 1, nums.length - 1));
    }
    

    //This is simply the simple version solution
    public int helper(int[] nums, int start, int end) {
        int n = nums.length;
        
        int rob = 0;
        int noRob = 0;
        
        for(int i = start; i <= end; i++) {
            int curRob = noRob + nums[i];
            noRob = Math.max(noRob, rob);
            rob = curRob;
        }
        return Math.max(rob, noRob);
    }
}