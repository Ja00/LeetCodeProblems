//2-pass
//Any simple sorting algorithm, selection sort, bubble sort, buckle sort.......


//1-pass
//The key idea is that the order is 0 -> 1 -> 2. It means that there are only 3 possibilities.
//We need to figure out the right position for all the 0 and 2, then 1 is auto positioned.

class Solution {
	public void sortColors(int[] nums) {
		int p1 = 0, p2 = nums.length-1, index = 0;
		//index is the iterating pointer, p1 track the current 
		while(index <= p2) {
			if(nums[index] == 0) {
				nums[index] = nums[p1];
				nums[p1] = 0;
				p1++;
			}
			if(nums[index] == 2) {
				nums[index] = nums[p2];
				nums[p2] = 2;
				p2--;
				index--;//This is a very important line, as you need to apply 
				//the test on the number after swapping.
			}
			index++;
		}
	}
}