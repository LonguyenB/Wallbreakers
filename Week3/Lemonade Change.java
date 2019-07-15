class Solution {
    public boolean lemonadeChange(int[] bills) {
        boolean[] used = new boolean[bills.length];
        // choose the next largest bill (in order) thats less than or equal to the change
        for (int i = 0; i < bills.length; i++) {
            int diff = bills[i] - 5;
            // if its the first customer, you have no change to give
            if (i == 0 && diff > 0) {
                return false;
            }
            int count = 0;
            // while the change is more than 0 and you haven't searched all positions,
            // keep searching for the next largest value
            while (diff > 0 && count < i) {
                int max = 0;
                int pos = -1;
                // search through the bills received so far. if the bill is larger than the current max
                // and less than or equal to the change required and it isn't used, remember the bill and position
                for (int j = 0; j < i; j++) {
                    if (bills[j] > max && bills[j] <= diff && !used[j]) {
                        max = bills[j];
                        pos = j;
                    }
                }
                // if the change that would be given is larger than the change required
                // don't give it
                if (diff > 0 && pos != -1) {
                    diff = diff - max;
                    used[pos] = true;
                }
                count++;
            }
            
            if (diff != 0) {
                return false;
            }
        }
        
        return true;
    }
}