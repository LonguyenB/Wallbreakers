class Solution {
    public String longestCommonPrefix(String[] strs) {
        int numStr = strs.length;
        String pre = "";
        
        if (strs.length == 0) {
            return pre;
        }
        
        for (String str : strs) {
            if (str.length() == 0) {
                return pre;
            }
        }

        String base = strs[0];
        
        for (int i = 0; i < base.length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (i > strs[j].length() - 1) {
                    return pre;
                }
                if (base.charAt(i) != strs[j].charAt(i)) {
                    return pre;
                }
            }
            
            pre = pre + base.charAt(i);
        }
        
        return pre;
    }
}