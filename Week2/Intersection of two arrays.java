class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> array1 = new HashSet<Integer>();
        Set<Integer> intersect = new HashSet<Integer>();
        
        // check for all unique integers in the first array
        for (int i = 0; i < nums1.length; i++) {
            if (!array1.contains(nums1[i])) {
                array1.add(nums1[i]);
            }
        }
        
        // check for all integers in second array that appear in first array (intersection)
        for (int i = 0; i < nums2.length; i++) {
            if (array1.contains(nums2[i])) {
                intersect.add(nums2[i]);
            }
        }
        
        int[] ans = new int[intersect.size()];
        int count = 0;
        
        // add to array to return
        for (Integer num : intersect) {
            ans[count] = num;
            count++;
        }
        
        return ans;
    }
}