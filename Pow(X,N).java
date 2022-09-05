//Brute force:

class Solution {
    public double myPow(double x, int n) {
        double ans = 1.0;
        if(n == 0) return ans;
        long temp = (n < 0) ? -n : n;
        for(long i = 0; i < temp; i++) {
            ans = ans * x;
        }
        if(n < 0) {
            ans = 1/ans;
        }
        return ans;
    }
}

//Time complexity = O(N)
//Space complexity = O(1)


//Binary Exponentiation:

class Solution {
    public double myPow(double x, int n) {
        double ans = 1;
        long temp = Math.abs((long)n);
        while(temp > 0) {
            if(temp % 2 == 1) {
                ans = ans * x;
            }
            temp = temp / 2;    
            x = x * x;
        }
        return (n < 0) ? (double) 1/ (double)ans : ans;
    }
}

//Time complexity = O(Log(N))
//Space complexity = O(1)
