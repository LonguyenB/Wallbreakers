class Solution {
    public int distributeCandies(int[] candies) {
        // max kinds of candies the sister can get is half of the candies (even if all candies are different
        // she only gets half)
        int max = candies.length / 2;
        Set<Integer> kinds = new HashSet<Integer>();
        
        // using a set, check each candy. If it's a new kind, add it to the set.
        for (int i = 0; i < candies.length; i++) {
            if (!kinds.contains(candies[i])) {
                kinds.add(candies[i]);
            }
        }
        
        // the lower value of kinds or max candies the sister can get, is the number of kinds she can get
        return Math.min(max, kinds.size());
    }
}