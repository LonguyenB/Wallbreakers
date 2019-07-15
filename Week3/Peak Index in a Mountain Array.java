class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int start = 0;
        int end = A.length - 1;
        int middle;
        
        // basically, keep searching and lowering the range until you find the index 
        // where A[middle - 1] < A[middle] < A[middle + 1]
        // oops, remove the <= and make it < since theres no return in the while.
        while (start < end) {
            middle = (start + end) / 2;
            if (A[middle] < A[middle + 1]) {
                start = middle + 1;
            } else {
                end = middle;
            }
        }
        
        return end;
    }
}