class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int middle;
        
        // don't use 1 pointer (middle), change it to 2 (Start and end)
        while(start <= end) {
            middle = (start + end) / 2;
            if (target == nums[middle]) {
                return middle;
            }
            if (target < nums[middle]) {
                end = middle - 1;
            } else if (target > nums[middle]) {
                start = middle + 1;
            }
        }
        
        return -1;
    }
}