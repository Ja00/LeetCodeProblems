//The key to solution is to keep the pointer of current edting index

class Solution {
    public int compress(char[] chars) {
		int modPo = 0;//Current editing pointer

		for(int i = 0, count = 0; i < chars.length; i++) {

			//There are 2 situations that count can't increase.
			//1. Reach a different char.
			//2. Reach the end of the array.
			//Otherwise, increment count.
			count++;

			if(i == chars.length-1 || chars[i] != chars[i+1]) {
				//First, assign the char to chars[modPo].
				chars[modPo] = chars[i];
				modPo++;//track the pointer

				//Second, get the accurance of the char.
				//If count == 1, just keep going.
				//If count > 1, need to parse the count into the array.
				if(count != 1) {
					char[] arr = String.valueOf(count).toCharArray();
					for(int j = 0; j < arr.length; j++, modPo++) {
						chars[modPo] = chars[j];
					}
				}

				//Finally, set the count back to 0.
				count = 0;
			}
		}
		return modPo;
	}
}