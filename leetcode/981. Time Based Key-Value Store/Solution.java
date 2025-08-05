// Using sorted map (TreeMap)
class TimeMap {
    Map<String, TreeMap<Integer, String>> timeMap;
    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!timeMap.containsKey(key)) {
            TreeMap<Integer, String> treeMap = new TreeMap<>();
            timeMap.put(key, treeMap);
        }
        timeMap.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> timestampMap = timeMap.get(key);
        if(timestampMap==null || timestampMap.floorKey(timestamp)==null)
            return "";
        else
            return timestampMap.get(timestampMap.floorKey(timestamp));
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
