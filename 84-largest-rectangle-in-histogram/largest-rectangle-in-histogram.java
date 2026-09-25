class Solution {
    int[] findPSE(int[] arr) {
        Deque<Integer> st = new ArrayDeque<>();
        int[] ans = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return ans;
    }

    int[] findNSE(int[] arr) {
        Deque<Integer> st = new ArrayDeque<>();
        int[] ans = new int[arr.length];
        for(int i = arr.length - 1; i >= 0; i--) {
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? arr.length : st.peek();
            st.push(i);
        }
        return ans;
    }
    public int largestRectangleArea(int[] heights) {
        int[] pse = findPSE(heights);
        int[] nse = findNSE(heights);
        int maxi = 0;
        for(int i = 0; i < heights.length; i++) {
            int area = (nse[i] - pse[i] - 1) * heights[i];
            maxi = Math.max(area, maxi);
        }
        return maxi;
    }
}