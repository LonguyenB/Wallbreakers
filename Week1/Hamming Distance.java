class Solution {
    public int hammingDistance(int x, int y) {
        int[] xBinary = new int[32];
        int[] yBinary = new int[32];
        int ans = 0;
        
        int xNum = x;
        int yNum = y;
        int count = 0;
        
        while (xNum >= 1 || yNum >= 1) {
            int end = 31 - count;
            xBinary[end] = xNum % 2;
            yBinary[end] = yNum % 2;
            
            xNum = xNum / 2;
            yNum = yNum / 2;
            
            count++;
        }

        for (int i = 31; i >= 0; i--) {
            if (xBinary[i] != yBinary[i]) {
                ans++;
            }
        }
            
        return ans;
    }
}