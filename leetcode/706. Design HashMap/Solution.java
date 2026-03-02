// https://leetcode.com/problems/design-hashmap/description/
// using LinkedList
// t.c.=O(n/k), s.c.=O(n+k)
class Pair<U, V> {
    public U first;
    public V second;
    Pair(U first, V second) {
        this.first=first;
        this.second=second;
    }
}
class Bucket {
    LinkedList<Pair> bucket;
    public Bucket() {
        bucket=new LinkedList<>();
    }
    public int get(int key) {
        for(Pair<Integer, Integer> pair: bucket)
            if(pair.first==key)
                return pair.second;
        return -1;
    }
    public void put(int key, int value) {
        boolean found=false;
        for(Pair<Integer, Integer> pair:bucket) 
            if(pair.first==key) {
                pair.second=value;
                found=true;
                break;
            }
        if(!found)
            bucket.add(new Pair<Integer, Integer>(key, value));
    }
    public void remove(int key) {
        for(Pair<Integer, Integer> pair: bucket)
            if(pair.first==key) {
                bucket.remove(pair);
                break;
            }
    }
}
class MyHashMap {
    private int base;
    private Bucket[] hashMap;
    public MyHashMap() {
        base=2069;
        hashMap=new Bucket[base];
        for(int i=0;i<base;i++)
            hashMap[i]=new Bucket();
    }
    public int _hash(int key) {
        return key%base;
    }
    public void put(int key, int value) {
        hashMap[_hash(key)].put(key, value);
    }
    
    public int get(int key) {
        return hashMap[_hash(key)].get(key);
    }
    
    public void remove(int key) {
        hashMap[_hash(key)].remove(key);
    }
}
