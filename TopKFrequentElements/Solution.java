//Record the frequency of every number and implement bucket sort


class Solution {
	public List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer>[] bucket = new List[nums.length+1];

		HashMap<Integer, Integer> freqMap = new HashMap<>();

		for(int num : nums) {
			freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
		}	

		for(int key : freqMap.keySet()) {
			int freq = freqMap.get(key);
			if(bucket[freq] == null) {
				bucket[freq] = new ArrayList<>();
			}
			bucket[freq].add(key);
		}

		List<Integer> ans = new ArrayList<>();

		for(int i = nums.length; i >= 0; i--) {
			if(bucket[i] == null) {
				continue;
			} else {
				if(bucket[i].size() >= k) {
					List<Integer> temp = bucket[i].subList(0, k);
					ans.addAll(temp);
					break;//Get all the numbers I need.
				} else {
					ans.addAll(bucket[i]);
					k -= bucket[i].size();
				}
			}
		}
		return ans;
	}
}