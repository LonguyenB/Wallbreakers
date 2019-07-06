class MyHashMap {
    // 0 - 1000000 so 1000001
    int[] allMaps = new int[1000001];
    // since int array defaults to 0, need another way to maintain a record of mapped or not
    boolean[] recMaps = new boolean[1000001];

    /** Initialize your data structure here. */
    public MyHashMap() {
        
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        // if recMaps is false, set the value and recMaps
        if (!recMaps[key]) {
            recMaps[key] = true;
        }
        allMaps[key] = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        // if it's not mapped according to records, return -1
        // otherwise, return the value in allMaps;
        if (!recMaps[key]) {
            return -1;
        }
        
        return allMaps[key];
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        // since we always check if the key is mapped, we can just set records to false and basically ignore the
        // current value
        if (recMaps[key]) {
            recMaps[key] = false;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */