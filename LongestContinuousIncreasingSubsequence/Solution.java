//Compare the max to every local maxLen
//Don't forget to compare the last possible local maxLen,
//since it might reach the end of the array and can't 
//get compared in the for loop.

class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int max = 1, cur = max;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i-1]) {
                cur++;
            }else {
                max = Math.max(max, cur);
                cur = 1;
            }
        }
        max = Math.max(max, cur);//For the last possible maxLen.
        return max;
    }
}