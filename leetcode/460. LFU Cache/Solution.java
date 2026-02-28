// https://leetcode.com/problems/lfu-cache/description/
// t.c.=O(1), s.c.=O(n)
class LFUCache {
    private Map<Integer, Pair<Integer, Integer>> cache;
    private Map<Integer, LinkedHashSet<Integer>> frequencies;
    private int minFreq, capacity;
    public LFUCache(int capacity) {
        cache=new HashMap<>();
        frequencies=new HashMap<>();
        this.capacity=capacity;
        minFreq=0;
    }
    
    private void removeFromFreq(int freq, int key) {
        Set<Integer> keys=frequencies.get(freq);
        keys.remove(key);
        if(keys.isEmpty()) {
            frequencies.remove(freq);
            if(minFreq==freq)
                minFreq++;
        }
    }
    private void insertNewKey(int key, int value, int freq) {
        cache.put(key, new Pair<>(freq, value));
        frequencies.putIfAbsent(freq, new LinkedHashSet<>());
        frequencies.get(freq).add(key);
    }
    public int get(int key) {
        Pair<Integer, Integer> freqAndValue=cache.get(key);
        if(freqAndValue==null)
            return -1;
        int freq=freqAndValue.getKey();
        int value=freqAndValue.getValue();
        removeFromFreq(freq, key);
        insertNewKey(key, value, freq+1);
        return value;
    }
    
    public void put(int key, int value) {
        if(capacity<=0)
            return;
        Pair<Integer, Integer> freqAndValue=cache.get(key);
        if(freqAndValue!=null) {
            cache.put(key, new Pair<>(freqAndValue.getKey(), value));
            get(key);
            return;
        }
        if(capacity==cache.size()) {
            Set<Integer> keys=frequencies.get(minFreq);
            int keyToDelete=keys.iterator().next();
            cache.remove(keyToDelete);
            keys.remove(keyToDelete);
            if(keys.isEmpty())
                frequencies.remove(minFreq);
        }
        insertNewKey(key, value, 1);
        minFreq=1;
    }
}
