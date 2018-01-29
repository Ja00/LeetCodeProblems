//Solution with 2 for loops

//Core idea, keep track the LIS ends at pos i, using int[]

class Solution {
    public int lengthOfLIS(int[] nums) {
    	if(nums.length < 2) {
    		return nums.length;
    	}

    	int[] dp = new int[nums.length];

    	for(int i = 0; i < dp.length; i++) {
    		dp[i] = 1;
    	}

    	for(int i = 1; i < nums.length; i++) {
    		for(int j = 0; j < i; j++) {
    			if(nums[j] < nums[i]) {
    				//This is a possible increment
    				if(dp[j] + 1 > dp[i]) {
    					dp[i] = dp[j] + 1;
    					//after the inner loop, dp[i] will get its max.
    				}
    			}
    		}
    	}

    	int ans = 0;
    	for(int i = 0; i < dp.length; i++) {
    		ans = Math.max(ans, dp[i]);
    	}
    	return ans;
    }
}



//use Binary Search, O(nlng)
class Solution {
    public int lengthOfLIS(int[] nums) {
    	int[] dp = new int[nums.length];

    	int len = 0;

    	for(int num : nums) {
    		int i = Arrays.binarySearch(dp, 0, len, num);
    		if(i < 0) {
    			i = -(i + 1);
    		}
    		dp[i] = num;
    		if(i == len) {
    			len++;
    		}
    	}
    	return len;
    }
}