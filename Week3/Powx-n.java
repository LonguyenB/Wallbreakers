class Solution {
    public double myPow(double x, int n) {
        // all edge cases
        if (n == 0) {
            return 1.00;
        }
        if (x == 1) {
            return 1;
        }
        if (x == 0) {
            return 0;
        }
        if (x == -1 && n % 2 == 0) {
            return 1;
        }
        if (x == -1 && n % 2 != 0) {
            return -1;
        }
        if (n == Integer.MIN_VALUE) {
            return 0;
        }
        // negative is divide n number of times
        if (n < 0) {
            return 1 / myPow(x, -n);
        }
        
        // had to do this, halved the amount of operations necessary since saving the value 
        double splitOp = myPow(x, n / 2);
        // one of the properties of exponents, x^(n/2) * x^(n/2) = x^n
        if (n % 2 == 0) {
            return splitOp * splitOp;
        } else {
            return x * splitOp * splitOp;
        }
    }
}