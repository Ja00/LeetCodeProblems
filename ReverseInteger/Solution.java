//Simply reverse, but check overflow by doing reverse calculation.

class Solution {
    public int reverse(int x) {
    	int result = 0;//this is the return value

 		while(x != 0) {
 			int tail = x % 10;
 			int newResult = result * 10 + tail;
 			if((newResult - tail) / 10 != result) {
 				//if overflow, they can't be equal.
 				return 0;
 			}
 			result = newResult;
 			x /= 10;
 		}
 		return result;
    }
}