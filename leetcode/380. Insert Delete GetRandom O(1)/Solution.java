// https://leetcode.com/problems/insert-delete-getrandom-o1/description/
class RandomizedSet {
    List<Integer> list;
    Map<Integer, Integer> valToIndex;
    Random rand;
    public RandomizedSet() {
        list=new ArrayList<>();
        valToIndex=new HashMap<>();
        rand=new Random();
    }
    
    public boolean insert(int val) {
        if(valToIndex.containsKey(val)) return false;
        valToIndex.put(val, list.size());
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!valToIndex.containsKey(val))    return false;
        int idx=valToIndex.get(val);
        int lastVal=list.get(list.size()-1);
        list.set(idx, lastVal);
        valToIndex.put(lastVal, idx);
        list.remove(list.size()-1);
        valToIndex.remove(val);
        return true;
    }
    
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

