class Solution {
    public boolean wordPattern(String pattern, String str) {
        HashMap<Character, String> map = new HashMap<Character, String>();
        String[] split = str.split(" ");
        
        int count = 0;
        // if the pattern doesn't have as many chars as there are words, it already doesn't follow
        if (pattern.toCharArray().length != split.length) {
            return false;
        }
        
        // map each unique character in the pattern to each the first corresponding word in string
        // that means if a maps to cat and dog, the map will associate a to cat and not dog
        // if it is already mapped, check if the word is the correct value, if not, return false
        // also make sure that the word is not already mapped to another char (1:1 mapping)
        for (char c : pattern.toCharArray()) {
            if (!map.containsKey(c)) {
                if (map.containsValue(split[count])) {
                    return false;
                }
                map.put(c, split[count]);
                count++;
            } else {
                if (!map.get(c).equals(split[count])) {
                    return false;
                }
                count++;
            }
        }
        
        return true;
    }
}