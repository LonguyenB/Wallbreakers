class Solution {
    public boolean isPalindrome(String s) {
        String norm = s.toLowerCase();
        norm = norm.replaceAll("[^a-zA-Z0-9]", "");
        System.out.println(norm);
        if (norm.isEmpty() || (norm.length() == 1)) { 
            return true;
        } else {
            int end = norm.length() - 1;
            System.out.println(end);
            for (int i = 0; i < norm.length() / 2; i++) {                
                if (norm.charAt(i) != norm.charAt(end)) {
                    return false;
                }
                end--;
            }
            return true;
        }
    }
}