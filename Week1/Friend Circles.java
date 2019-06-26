class Solution {
    public int findCircleNum(int[][] M) {
        if (M.length == 1) {
            return 1;
        }
        
        int size = M.length;
        
        UnionFind unionFind = new UnionFind(size);
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (M[i][j] == 1) {
                    unionFind.union(i, j);
                }
            }
        }
        
        return unionFind.circles;
    }
    
    class UnionFind {
                
        int[] friends;
        int circles;
        
        public UnionFind(int n) {
            friends = new int[n];
            
            for (int i = 0; i < n; i++) {
                friends[i] = i;
            }
            
            circles = n;
        }

        
        public void union(int i, int j) {
            int friendI = find(i);
            int friendJ = find(j);
            
            if (friendI == friendJ) {
                return;
            }
            
            friends[friendI] = friendJ;
            circles = circles - 1;
        }
        
        public int find(int i) {
            if (friends[i] != i) {
                friends[i] = find(friends[i]);
            }
            
            return friends[i];
        }
    }
}