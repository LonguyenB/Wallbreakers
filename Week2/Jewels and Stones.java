class Solution {
    public int numJewelsInStones(String J, String S) {
        HashMap<Character, Integer> countJewels = new HashMap<Character, Integer>();
        int count = 0;
        
        // for each char in S (or stones we have), check if it appears in J (if it's a jewel)
        // if it is, add to map, and update value as required
        for (char c : S.toCharArray()) {
            if (J.indexOf(c) != -1) {
                if (!countJewels.containsKey(c)) {
                    countJewels.put(c, 1);
                } else {
                    countJewels.put(c, countJewels.get(c) + 1);
                }
            }
        }
        
        // count the number of jewels
        for (Map.Entry<Character, Integer> entry : countJewels.entrySet()) {
            count = count + entry.getValue();
        }
        
        return count;
    }
}