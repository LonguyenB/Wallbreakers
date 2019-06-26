class Solution {
    public void reverseString(char[] s) {
        int stringSize = s.length;
        int end = stringSize - 1;
        
        for (int i = 0; i < stringSize / 2; i++) {
            char temp = s[i];
            
            s[i] = s[end];
            s[end] = temp;
            end--;
        }
    }
}