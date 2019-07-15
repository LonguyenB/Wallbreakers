class Solution {
    public List<Integer> partitionLabels(String S) {
        // hashmap takes up more space than array, can just use int array
        // want to find each char's final index
        int[] lastOcc = new int[26];
        List<Integer> ans = new ArrayList<Integer>();
        // trick to get 0 index in the alphabet (similar to using lowercase string of a-z and getting indexOf)
        // could use the hashmap for this too but again, more space
        for (int i = 0; i < S.length(); i++) {
            lastOcc[S.charAt(i) - 'a'] = i;
        }
        
        int newMax = 0;
        int lastMax = 0;
        
        for (int i = 0; i < S.length(); i++) {
            // account for a char within the first and last indices of another char. if its within 
            // but has a last index higher, it becomes the new end for the partition
            newMax = Math.max(lastOcc[S.charAt(i) - 'a'], newMax);
            
            // if they're the same, that means the partition is complete now
            // so add it to the list of sizes and update lastMax to signal the beginning
            // of the new partition.
            if (newMax == i) {
                ans.add(newMax - lastMax + 1);
                lastMax = i + 1;
            }
        }
        
        return ans;
    }
}