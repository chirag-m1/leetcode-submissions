class Solution {
    public int[] singleNumber(int[] nums) {
        int b1 = 0;
        int b2 = 0;
        int xor = nums[0];
        for(int i = 1; i < nums.length; i++) {
            xor = xor ^ nums[i];
        }
        int diffBit = (xor & (xor - 1)) ^ xor;
        for(int i = 0; i < nums.length; i++) {
            if((diffBit & nums[i]) != 0) {
                b1 = b1 ^ nums[i];
            }
            else {
                b2 = b2 ^ nums[i];
            }
        }
        return new int[] {b1, b2};
    }
}