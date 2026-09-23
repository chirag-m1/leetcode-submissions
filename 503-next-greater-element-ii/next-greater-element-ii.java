class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Deque<Integer> st = new ArrayDeque<>();

        for(int i = 2 * n-1; i >= 0; i--) {
            int ind = i % n;
            while(!st.isEmpty() && nums[ind] >= st.peek()) {
                st.poll();
            }
            if(i < n) {
                ans[i] = st.isEmpty() ? -1 : st.peek();
            }
            st.push(nums[ind]);
        }
        return ans;
    }
}