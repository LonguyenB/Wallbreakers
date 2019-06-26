class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        HashMap<Character, Integer> mapS = new HashMap<Character, Integer>();
        HashMap<Character, Integer> mapT = new HashMap<Character, Integer>();
        
        for (int i = 0; i < s.length(); i++) {
            if (mapS.get(s.charAt(i)) == null) {
                mapS.put(s.charAt(i), 1);
            } else {
                mapS.put(s.charAt(i), mapS.get(s.charAt(i)) + 1); 
            }
            if (mapT.get(t.charAt(i)) == null) {
                mapT.put(t.charAt(i), 1);
            } else {
                mapT.put(t.charAt(i), mapT.get(t.charAt(i)) + 1); 
            }
        }

        for (char key : mapS.keySet()) {
            if (!mapT.containsKey(key)) {
                return false;
            } else if (!mapS.get(key).equals(mapT.get(key))) {
                return false;
            }
        }

        return true;
    }
}