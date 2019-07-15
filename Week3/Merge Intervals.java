class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][0];
        }
        List<int[]> ans = new ArrayList<int[]>();
        int count = 0;
        
        Arrays.sort(intervals, new Comparator<int[]>() {
           public int compare (int[] x, int[] y) {
               return x[0] - y[0];
           } 
        });
        
        // a temp array with the interval to be added. start with the first array, after sorting
        int[] curInterval = intervals[0];
        
        for (int i = 1; i < intervals.length; i++) {
            // if its overlapping, update the current interval
            // if it's not, the current interval is merged, so add it to list
            // and update the current interval to merge to the current interval in intervals list
            if (curInterval[1] >= intervals[i][0]) {
                curInterval[0] = Math.min(curInterval[0], intervals[i][0]);
                curInterval[1] = Math.max(curInterval[1], intervals[i][1]);
            } else {
                ans.add(curInterval);
                curInterval = intervals[i];
            }
        }
        
        // the loop ends, either by merging all the remaining intervals, or the last interval is by itself
        // so this is needed to add the last interval
        ans.add(curInterval);
        
        // need an array. arraylist was just easier while we didn't know how many elements there would
        return ans.toArray(new int[ans.size()][]);
    }
}