class Solution {
    public int[] sortArrayByParity(int[] A) {
        int arraySize = A.length;
        int[] sorted = new int[arraySize];
        
        if (arraySize == 1) {
            return A;
        }
    
        int count = 0;
        int end = arraySize - 1;
        
        for (int i : A) {
            if (i % 2 == 0) {
                sorted[count] = i;
                count++;
            } else {
                sorted[end] = i;
                end--;
            }
        }
        
        return sorted;
    }
}