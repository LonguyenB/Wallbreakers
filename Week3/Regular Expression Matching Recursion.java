class Solution {
    public boolean isMatch(String s, String p) {
        if (p.length() == 0) {
            if (s.length() == 0) {
                return true;
            } else {
                return false;
            }
        }

        if (p.length() == 1) {
            return s.length() == 1 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        }

        // now p is guaranteed at least 2 chars
        if (p.charAt(1) != '*') {
            if (s.length() == 0) {
                return false;
            } else {
                return (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1), p.substring(1));
            }
        } else {
            
            while (s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
                // check the pattern to find new char (some variation such as a*a or .*a etc)
                if (isMatch(s, p.substring(2))) {
                    return true;
                }
                
                // then check next part of string when new char
                s = s.substring(1);
            }
            return isMatch(s, p.substring(2));

        }
    }
}