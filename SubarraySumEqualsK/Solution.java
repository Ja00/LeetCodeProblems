//Solution 1: every subarray has a [start, end] structure.
//Based on this structure, we can iterate through the whole array.
//By using sum[] array to record the sum upon current element, it slightly recude the complexity.
//But it's still O(n^2)

class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        int res = 0;
        for(int i = 1; i < nums.length; i++) {
            sum[i] = sum[i-1] + nums[i];
        }
        for(int i = 0; i < nums.length; i++) {
            for(int j = i; j < nums.length; j++) {
                if(sum[j] - sum[i] + nums[i] == k) {
                    res++;
                }
            }
        }
        return res;
    }
}


//Solution 2: forget about finding start or end.
//if sum[i] - sum[j] = 0, that means sum between i & j is 0
//Extending the same thought further, sum[i] - sum[j] = k --> subarray sum [i, j] = k (well, i is not included, but we don't care about the boundary index)
//Thus, we need to find current sum and see how many times sum - k has occurred to find total count.

class Solution {
	public int subarraySum(int[] nums, int k) {
		int sum = 0, count = 0;
		HashMap<Integer, Integer> map = new HashMap<>();//using HashMap to do the recording.
		//<sum value, occuring time>
		map.put(0,1);
		for(int i = 0; i < nums.length; i++) {
			sum += nums[i];

			if(map.containsKey(sum - k)) {
				count += map.get(sum - k);
			}
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		return count;
	}
}