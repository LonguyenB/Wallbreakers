class Solution {
    public int binaryGap(int N) {
        int[] binary = new int[32];
        int count = 0;
        int curNum = N;
        int ans = 0;
        int distance = -1;
        
        while (curNum >= 1) {
            int end = 31 - count;
            
            binary[end] = curNum % 2;
            curNum = curNum / 2;
            count++;
        }
        
        int curPos = 31 - count;
        int nextPos = curPos++;
        
        while (nextPos < 32) {
            if (binary[nextPos] == 1) {
                if (distance < (nextPos - curPos)) {
                    distance = nextPos - curPos;
                }
                curPos = nextPos;
                nextPos++;
            } else {
                nextPos++;
            }
        }
        
        return distance;
    }
}