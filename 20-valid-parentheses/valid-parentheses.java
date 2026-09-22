class Solution {
    public boolean isValid(String s) {
        Deque<Character> st = new ArrayDeque<>();
        for(char ch : s.toCharArray()) {
            if(ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
            }
            else {
                if(st.isEmpty()) {
                    return false;
                }
                char c = st.pop();
                if((c == '(' && ch != ')') || (c == '[' && ch != ']') || (c == '{' && ch != '}')) {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}