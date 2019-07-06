class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        if (A.length() == 0 && B.length() == 0) {
            return new String[0];
        }
        
        HashMap<String, Integer> words = new HashMap<String, Integer>();
        int count = 0;
        
        String[] aWords = A.split(" ");
        String[] bWords = B.split(" ");
        
        // count each word in the two sentences 
        for (int i = 0; i < aWords.length; i++) {
            if (words.containsKey(aWords[i])) {
                words.put(aWords[i], words.get(aWords[i]) + 1);
            } else {
                words.put(aWords[i], 1);
            }
        }
        
        for (int i = 0; i < bWords.length; i++) {
            if (words.containsKey(bWords[i])) {
                words.put(bWords[i], words.get(bWords[i]) + 1);
            } else {
                words.put(bWords[i], 1);
            }
        }
        
        
        // count how many words are uncommon
        // if the word has a value of 1, that means it only appears once, and therefore only in one sentence
        // which means it is uncommon
        for (Map.Entry<String, Integer> entry : words.entrySet()) {
            if (entry.getValue() == 1) {
                count++;
            }
        }
        
        // initialize new array based on the count of uncommon words
        String[] uncommon = new String[count];
        
        count = 0;
        
        // go through and add the uncommon words
        // would this be easier to create an arraylist, then read the arraylist into a new array
        // rather than looping through entries again?
        for (Map.Entry<String, Integer> entry : words.entrySet()) {
            if (entry.getValue() == 1) {
                uncommon[count] = entry.getKey();
                count++;
            }
        }
        
        return uncommon;
    }
}