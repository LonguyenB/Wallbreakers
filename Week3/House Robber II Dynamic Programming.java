class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        // a few ways to hit houses; you can do every other house (starting at the beginning, end, one in, etc)
        // but you can also skip a house to maximize value so you want to maintain the values of each possibility
        // you would never skip more than one house in a row () since at that point, you could just visit both houses 
        // (e.g. 1, 2, 3, 4, 5, if you go to 1, you'd got to 3, but you'd skip 3 to go to 4. You would never
        // skip 3 but then also skip 4, since you could just go to 3 and 5)
        int[][] maxVal = new int[nums.length][2];

        // first column is starting from index 0, second column is starting index 1
        // the max value at each step is stored, so by the end you get the maximum value
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                maxVal[i][0] = 0;
                maxVal[i][1] = nums[0];
            } else if (i == 1) {
                maxVal[i][0] = nums[i];
                maxVal[i][1] = Math.max(nums[0], nums[1]);
            } else if (i < nums.length - 1) {
                maxVal[i][0] = Math.max(maxVal[i - 2][0] + nums[i], maxVal[i - 1][0]);
                maxVal[i][1] = Math.max(maxVal[i - 2][1] + nums[i], maxVal[i - 1][1]);
            } else if (i == nums.length - 1) {
                maxVal[i][1] = Math.max(Math.max(maxVal[i - 1][0], maxVal[i - 1][1]),
                                     Math.max(maxVal[i - 2][1], maxVal[i - 2][0] + nums[i]));
            }
        }

        return maxVal[nums.length - 1][1];
    }
}