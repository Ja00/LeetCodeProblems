//Override the self-defined Comparator

class Solution {
	public String largestNumber(int[] nums) {
		if(nums == null || nums.length == 0) {
			return "";
		}

		String[] strs = new String[nums.length];

		for(int i = 0; i < nums.length; i++) {
			strs[i] = String.valueOf(nums[i]);
		}

		Comparator<String> comp = new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				String s1 = a + b;
				String s2 = b + a;
				return s2.compareTo(s1);//determine a or b should be in the front
			}
		};

		Arrays.sort(strs, comp);

		if(strs[0].charAt(0) == '0') {
			//first char of the "largest" number is 0, then all 0
			return "0";
		}

		StringBuffer sb = new StringBuffer();

		for(String str : strs) {
			sb.append(str);
		}
		return sb.toString();
	}
}