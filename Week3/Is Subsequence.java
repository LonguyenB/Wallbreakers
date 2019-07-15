class Solution {
    public boolean isSubsequence(String s, String t) {
        // take the indexOf of each character in s from the index of the prev char
        // if there is none, it's not a subsequence
        char[] sub = s.toCharArray();
        
        int prev = 0;
        for (int i = 0 ; i < sub.length; i++) {
            if (t.indexOf(sub[i], prev) == -1) {
                return false;
            }
            prev = t.indexOf(sub[i], prev) + 1;
        }
        
        return true;
    }
}