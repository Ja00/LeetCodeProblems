//Solution 1:
//Very Straightforward, 1,2,3,4,5,6,7,8,9,10(after sorted)
//no matter what, there's going to be a [1,x] pair,
//and 1 has to be counted into the SUM but x does not.
//So what should the x be? As small as possible, then, 2.
//Otherwise, if we take like [1,3], then 2 has to be added, but 3 can't be added.
//In this case, we miss the better solution : [1,2],[3,y]......

//According to this idea, we just need to pair k with the smallest number larger than k.

class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for(int i = 0; i < nums.length/2 ; i++){
            sum += nums[2 * i];
        }
        return sum;
    }
}


//Solution 2:
//The idea is smiliar, but it uses Hashing to reduce the time-complexity.
//Since the hash array use values in the nums[] as index, there's a natural order in it (no need to sort).
//keep track if the current hashing is the odd one or even one.
//Skip odd, and add even.

class Solution {
    public int arrayPairSum(int[] nums) {
        int[] hash = new int[20001];
        //as the range of number is given.
        int sum = 0, p = 0;
        for(int num : nums) {
            hash[num+10000]++;//this is the coolest part.
        }
        for(int i = 0; i< hash.length; i++) {
            while(hash[i] > 0) {
                if(p % 2 == 0) {
                    sum += (i - 10000);
                }
                p++;
                hash[i]--;
            }
        }
        return sum;
    }
}