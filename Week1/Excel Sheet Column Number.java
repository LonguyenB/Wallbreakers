class Solution {
    public int titleToNumber(String s) {
        int numberOfLetters = s.length();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        int colNum = 0;
        
        for (int i = 0; i < numberOfLetters; i++) {
            int exp = numberOfLetters - i - 1;
            int numLetter = alphabet.indexOf(s.charAt(i)) + 1;
            int value = numLetter * (int) Math.pow(26, exp);
            
            colNum = colNum + value;
        }
        
        return colNum;
    }
}