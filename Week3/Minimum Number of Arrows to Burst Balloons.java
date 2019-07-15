class Solution {
    public int findMinArrowShots(int[][] points) {
        // we can't assume there are no balloons based on question
        if (points.length == 0) {
            return 0;
        }
        // realized looping was slow. since we have an array, sort it first
        // have to make a new comparator since this is a 2d array and its not in base
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] x, int[] y) {
                return x[1] - y[1];
            }
        });
        
        // we start with 1 arrow minimum since there's at least one balloon
        int count = 1;
        // use the first balloon as the pos the arrow goes
        int endpoint = points[0][1];
        
        // starting from the next balloon, if its starting point is less or equal to our endpoint,
        // it still gets hit by the same arrow.
        // otherwise, it needs a new arrow and the new endpoint is the end of that balloon
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > endpoint) {
                count++;
                endpoint = points[i][1];
            }
        }
        
        return count;
    }
}