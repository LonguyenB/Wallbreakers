class Solution {
    public boolean isAnagram(String s, String t) {
        // sort the strings, if at each index, each char is the same, it's valid
        // can't be anagrams if it isn't the same length
        if (s.length() != t.length()) {
            return false;
        }
        
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        
        // if any char is not the same, false
        for (int i = 0; i < sArray.length; i++) {
            if (sArray[i] != tArray[i]) {
                return false;
            }
        }
        
        return true;
    }
}