class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        HashMap<String, Integer> transCount = new HashMap<String, Integer>();
        
        // each index in morse corresponds to index in alphabet (since both are alphabetically ordered)
        // for each word, check each letter and make the transformation and add to/update hashmap
        for (int  i = 0; i < words.length; i++) {
            String trans = "";
            for (char c : words[i].toCharArray()) {
                int index = alphabet.indexOf(c);
                trans = trans + morse[index];
                
            }
            
            // update hashmap appropriately
            if (!transCount.containsKey(trans)) {
                transCount.put(trans, 1);
            } else {
                transCount.put(trans, transCount.get(trans) + 1);
            }
        }
        
        return transCount.size();
    }
}