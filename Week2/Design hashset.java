class MyHashSet {
    // record whether the int is there
    boolean[] rec = new boolean[1000001];

    /** Initialize your data structure here. */
    public MyHashSet() {
        
    }
    
    // if not recorded, record it (set to true)
    public void add(int key) {
        if (!rec[key]) {
            rec[key] = true;
        }
    }
    
    // if recorded, "unrecord" it (set to false)
    public void remove(int key) {
        if (rec[key]) {
            rec[key] = false;
        }
    }
    
    /** Returns true if this set contains the specified element */
    // just return value at rec[key] since its boolean
    public boolean contains(int key) {
        return rec[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */