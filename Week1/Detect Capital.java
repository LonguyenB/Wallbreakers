class Solution {
    public boolean detectCapitalUse(String word) {
        String temp = word.toUpperCase();
        if (word.equals(temp)) {
            return true;
        } else if (word.equals(temp.toLowerCase())) {
            return true;
        } else {
            String restOfString = word.substring(1).toLowerCase();
            if (word.substring(1).equals(restOfString)) {
                return true;
            }
        }
        
        return false;
    }
}