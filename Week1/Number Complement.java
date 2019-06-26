class Solution {
    public int findComplement(int num) {
        int count = 0;
        int curNum = num;
        int ans = 0;
        
        while (curNum >= 1) {
            int end = 31 - count;

            int remainder = curNum % 2;
            if (remainder == 1) {
                remainder = 0;
            } else {
                remainder = 1;
            }
            int value = (remainder) * (int) Math.pow(2, count);
            
            ans = ans + value;

            curNum = curNum / 2;
            count++;
        }
        return ans;
    }
}