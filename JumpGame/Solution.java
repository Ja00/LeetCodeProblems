//This idea focus on the 0s
//If a[i] == 0, that means from index 0 to i-1, there should be at
//least 1 value that enables a JUMP to skip this 0 to reach the last element.
//Keep track on the length of this jump

class Solution {
    public boolean canJump(int[] nums) {
    	if(nums.length < 2) {
    		return true;
    	}

    	for(int i = nums.length - 2; i >= 0; i--) {
    		if(nums[i] == 0) {
    			int jump = 1;
    			while(jump > nums[i]) {
    				jump++;
    				i--;
    				if(i < 0) {
    					return false;//can't find the value to skip this 0.
    				}
    			}
    		}
    	}
    	return true;
    }
}