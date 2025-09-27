// Using sorted map (TreeMap)
class TimeMap {
    private Map<String, TreeMap<Integer, String>> timeMap;
    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        timeMap.computeIfAbsent(key, k->new TreeMap<>()).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if(!timeMap.containsKey(key)) return "";
        Map.Entry<Integer, String> treeMapEntry = timeMap.get(key).floorEntry(timestamp);
        return treeMapEntry==null?"":treeMapEntry.getValue();
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
