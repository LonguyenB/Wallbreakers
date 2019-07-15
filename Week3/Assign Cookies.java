class Solution {
    public int findContentChildren(int[] g, int[] s) {
        // find the child with the largest greed factor, give that child the smallest cookie that
        // will satisfy them. This should maximize the number of children you can satisfy
        boolean[] has = new boolean[g.length];
        boolean[] given = new boolean[s.length];
        int content = 0;
        int count = 0;

        // you want to check each child to potentially satisfy
        while (count < g.length) {
            int maxG = 0;
            int posG = -1;
            int minS = 0;
            int posS = -1;
            // find the child with the largest greed factor
            for (int i = 0; i < g.length; i++) {
                if (g[i] > maxG && !has[i]) {
                    maxG = g[i];
                    posG = i;
                }
            }
            // find the smallest size that will satisfy the child
            for (int i = 0; i < s.length; i++) {
                if (s[i] >= maxG && !given[i]) {
                    if (minS == 0) {
                        minS = s[i];
                        posS = i;
                    } else if (s[i] < minS) {
                        minS = s[i];
                        posS = i;
                    }
                }
            }
            // this case means no one cookie will satisfy the child
            if (posG > -1 && posS == -1) {
                has[posG] = true;
            }
            if (posG > -1 && posS > -1) {
                has[posG] = true;
                given[posS] = true;
                content++;
            }
            
            count++;
        }
        
        return content;
    }
}