class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> selfDivideNum = new ArrayList<Integer>();
        
        for (int i = left; i <= right; i++) {
            int nextNum = i;
            boolean isSDN = true;

            String nextNumString = String.valueOf(nextNum);

            for (int j = 0; j < nextNumString.length(); j++) {
                int nextDigit = Integer.parseInt(String.valueOf(nextNumString.charAt(j)));

                if (nextDigit == 0) {
                    isSDN = false;
                } else {
                    if (nextNum % nextDigit != 0) {
                        isSDN = false;
                    } else if (j == (nextNumString.length() - 1)) {
                        if (isSDN) {
                            selfDivideNum.add(nextNum);
                        }
                    }
                }
            }
            
        }
        
        return selfDivideNum;
    }
}