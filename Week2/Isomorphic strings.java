class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        
        // s and t have same length
        // go through each index and compare char mappings. 
        // if one key is found but the value is different, return false
        // if the key is not found, check if the value is already present.
        // if it is, return false (only a 1-1 mapping)
        // if it gets through the whole loop, return true
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(sChar[i])) {
                if (map.get(sChar[i]) != tChar[i]) {
                    return false;
                }
            } else {
                if (map.containsValue(tChar[i])) {
                    return false;
                }
                map.put(sChar[i], tChar[i]);
            }
        }
        
        return true;
    }
}