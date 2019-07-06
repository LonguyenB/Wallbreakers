class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seenNum = new HashSet<>();
        // if the number's already 1, then it is happy. Don't bother with loop
        if (n == 1) {
            return true;
        }
        
        // as long as the num 1, signifying a happy number, loop through the number and add the squares
        // if new number is 1, done
        // if not, check if the number is in the set. If it is that means it will loop endlessly
        // if it's not in the set, add it and then continue with the loop
        int count = 0;
        int checkNum = n;
        while (count != 1) {
            count = 0;
            int sum = 0;
            while (checkNum > 0) {
                int temp = checkNum % 10;
                sum = sum + temp * temp;
                checkNum = checkNum / 10;
                count = sum;
            }
            
            if (seenNum.contains(count)) {
                return false;
            }
            
            seenNum.add(count);
            checkNum = count;
        }
        
        return true;
    }
}