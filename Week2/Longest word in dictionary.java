class Solution {
    public String longestWord(String[] words) {
        Node root = new Node();
        // use an impossible value for string
        root.word = "0";
            
        // as each word is inserted, it will use the previously modified tree as a base
        // in a sense, so if a is already in the tree, it will go to a then add the next 
        // character
        for (String word : words) {
            root.insert(word);
        }
        return dfs(root, "");
    }
    
    class Node {
        // a-z so 26 chars
        Node[] children = new Node[26];
        String word = "";
        
        // just inserts each consecutive character as a child of the previous character
        public void insert(String str) {
            char[] chars = str.toCharArray();
            Node cur = this;
            
            for (int i = 0; i < chars.length; i++) {
                // gives a 0 indexed value of the character's position in the lowercase alphabet
                // just a simpler way of getting index when compared to writing the alphabet
                // and getting the index but this only works for lowercase
                // uppercase is different, and a mix requires a different way altogether
                int index = chars[i] - 'a';
                
                if (cur.children[index] == null) {
                    cur.children[index] = new Node();
                }
                
                cur = cur.children[index];
            }
            
            cur.word = str;
        }
    }
    
    public String dfs(Node node, String str) {
        String ans = "";
        
        // only hits this at the end or in new child (basically an empty child)
        if (node == null || node.word.length() == 0) {
            return str;
        }
        if (!node.word.equals("0")) {
            str = node.word;
        }
        for (Node child : node.children) {
            String temp = dfs(child, str);
            if ((temp.length() > ans.length()) || (temp.length() == ans.length() && temp.compareTo(ans) < 0)) {
                ans = temp;
            }
        }
        
        return ans;
    }
}