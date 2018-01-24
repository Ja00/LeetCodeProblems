//calculate the idle slots

class Solution {
    public int leastInterval(char[] tasks, int n) {
    	int[] map = new int[26];
    	for(char ch : tasks) {
    		map[ch - 'A']++;
    	}
    	Arrays.sort(map);
    	int max_val = map[25] - 1, idle = max_val * n; //Most possible idle slots

    	for(int i = 24; i >= 0 && map[i] > 0; i--) {
    		idle -= Math.min(map[i], max_val);
    	}

    	return idle > 0 ? idle + tasks.length : tasks.length;

    }	

}