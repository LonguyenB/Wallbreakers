class Solution {
    public String reverseVowels(String s) {
        char[] sChars = s.toCharArray();
        String vowels = "aeiouAEIOU";
        boolean isVowel = false;
        
        int end = s.length() - 1;
        int i = 0;
        while (i < end) {
            isVowel = false;
            if (vowels.indexOf(s.charAt(i)) > -1) {
                while (end > i && !isVowel) {
                    if (vowels.indexOf(s.charAt(end)) > -1) {
                        isVowel = true;
                        char temp = s.charAt(i);
                        sChars[i] = s.charAt(end);
                        sChars[end] = temp;
                        end--;
                        i++;
                    } else {
                        end--;
                    }
                }
            } else {
                i++;
            }
        }
        
        return String.valueOf(sChars);
    }
}