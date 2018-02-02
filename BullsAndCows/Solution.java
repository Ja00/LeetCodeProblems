//Solution 1, using 2 maps(array)

class Solution {
    public String getHint(String secret, String guess) {
        int[] m1 = new int[10], m2 = new int[10];
        int len = secret.length(), bulls = 0, cows = 0;
        for(int i = 0; i < len; i++) {
            char s = secret.charAt(i), g = guess.charAt(i);
            if(s == g) {
                bulls++;
            } else {
            	//record the occurrence when they are !=
                m1[s - '0']++;
                m2[g - '0']++;
            }
        }
        for(int i = 0; i < 10; i++) {
        	//find the overlap
            if(m1[i] > 0 && m2[i] > 0) {
                cows += Math.min(m1[i], m2[i]);
            }
        }
        return bulls + "A" + cows + "B";
    }
}


//Solution 2, using only 1 array.


class Solution {
    public String getHint(String secret, String guess) {
    	int bulls = 0, cows = 0;

    	int[] numbers = new int[10];

    	for(int i = 0; i < secret.length(); i++) {
    		char s = secret.charAt(i), g = guess.charAt(i);
    		if(s == g) {
    			bulls++;
    		} else {
    			if(numbers[s - '0'] < 0) {
    				cows++;
    			}
    			if(numbers[g -'0'] > 0) {
    				cows++;
    			}
    			numbers[s - '0']++;
    			numbers[g - '0']--;
    		}
    	}
    	return bulls + "A" + cows + "B";
    }
}

