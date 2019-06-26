class Solution {
    public String reverseWords(String s) {
        StringBuilder build = new StringBuilder();
        String[] split = s.split(" ");
        
        for (String str : split) {
            build.append(new StringBuilder(str).reverse() + " ");
        }
        
        return build.toString().trim();
    }
}