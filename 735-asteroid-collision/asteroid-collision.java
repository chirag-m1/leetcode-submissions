class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> st = new ArrayDeque<>();
        for(int ast : asteroids) {
            while(ast < 0 && !st.isEmpty() && Math.abs(ast) > st.peek() && st.peek() >= 0) {
                st.pop();
            }

            if(!st.isEmpty() && st.peek() > Math.abs(ast) && ast < 0) {
                continue;
            }
            else if(!st.isEmpty() && st.peek() == Math.abs(ast) && ast < 0) {
                st.pop();
                continue;
            }
            else {
                st.push(ast);
            }
        }
        int size = st.size();
        int[] ans = new int[size];
        int i = size-1;
        while(i >= 0 && !st.isEmpty()) {
            ans[i] = st.pop();
            i--;
        }
        return ans;
    }
}