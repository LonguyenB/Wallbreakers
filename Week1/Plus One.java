class Solution {
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        
        for (int i = length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i] = digits[i] + 1;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        
        int[] newLength = new int[length + 1];
        newLength[0] = 1;
        
        for (int i = 1; i < length + 1; i++) {
            newLength[i] = digits[i - 1];
        }
        
        return newLength;
    }
}