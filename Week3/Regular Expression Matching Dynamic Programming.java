class Solution {
    public boolean isMatch(String s, String p) {
        char[] strings = s.toCharArray();
        char[] pattern = p.toCharArray();
        
        if (p.length() == 1) {
            if (s.length() == 1 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
                return true;
            } else {
                return false;
            }
        }
        
        boolean[][] table = new boolean[s.length() + 1][p.length() + 1];
        table[0][0] = true;
        
        for (int i = 1; i < table[0].length; i++) { 
            if (pattern[i - 1] == '*') {
                table[0][i] = table[0][i - 2];
            }
        }
        
        for (int i = 1; i < table.length; i++) {
            for (int j = 1; j < table[0].length; j++) {
                if (pattern[j - 1] == '.' || pattern[j - 1] == strings[i - 1]) {
                    table[i][j] = table[i - 1][j - 1];
                } else if (pattern[j - 1] == '*') {
                    table[i][j] = table[i][j - 2];
                    if (pattern[j - 2] == '.' || pattern[j - 2] == strings[i - 1]) {
                        table[i][j] = table[i][j] | table[i - 1][j];
                    }
                } else {
                    table[i][j] = false;
                }
            }
        }
        
        return table[strings.length][pattern.length];
    }
}