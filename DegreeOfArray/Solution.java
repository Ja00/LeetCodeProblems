//The idea is to find the shortest subarray countaining all elements with highest freq.
//That means sub[0] is the first k and sub[n-1] is the last k, while k is the num with highest freq.


class Solution {
    public int findShortestSubArray(int[] nums) {
    	//need something to track first and last appearance of every number
    	HashMap<Integer, Integer> left = new HashMap<>(), right = new HashMap<>(),
    							count = new HashMap<>();

    	for(int i = 0; i < nums.length; i++) {
    		int cur = nums[i];
    		if(left.get(cur) == null) {
    			//cur never appears.
    			left.put(cur, i);
    		}
    		right.put(cur, i);//track last appearance
    		count.put(cur, count.getOrDefault(cur, 0) + 1);//update counts
    	}

    	int ans = nums.length;//shrinking based on original length

    	int degree = Collections.max(count.values());//should be O(n)

    	for(int key : count.keySet()) {
    		if(count.get(key) == degree) {
    			//find a number occurance equals degree
    			ans = Math.min(ans, right.get(key) - left.get(key) + 1);
    		}
    	}
    	return ans;
    }
}