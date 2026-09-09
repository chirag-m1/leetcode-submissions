class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int bit = 31; bit >= 0; bit--) {
            int count = 0;
            for(int i = 0; i < nums.length; i++) {
                if((nums[i] & (1 << bit)) != 0) {
                    count++;
                }
            }
            if(count % 3 != 0) {
                ans = ans | (1 << bit);
            }
        } 
        return ans;
    }
}