class Solution {
    public double myPow(double x, int n) {
        double ans = 1;
        long power = n;
        if(power < 0) {
            power = -power;
        }
        while(power > 0) {
            if(power % 2 != 0) {
                ans = ans * x;
                power = power - 1;
            }
            else {
                x = x * x;
                power = power / 2;
            }
        }
        return n < 0 ? 1.0 / ans : ans;
    }
}