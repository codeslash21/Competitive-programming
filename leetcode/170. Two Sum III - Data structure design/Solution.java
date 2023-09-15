// using hashmap
// t.c.=O(n), s.c.=O(n)
class TwoSum {
    List<Integer> list;
    Map<Integer, Integer> map;
    public TwoSum() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }
    
    public void add(int number) {
        list.add(number);
        map.put(number, map.getOrDefault(number, 0)+1);
    }
    
    public boolean find(int value) {
        for(int i=0;i<list.size();i++)
            if(map.containsKey(value-list.get(i)))
                if(list.get(i)!=value-list.get(i))
                    return true;
                else if(list.get(i)==value-list.get(i) && map.get(list.get(i))>1)
                    return true;
        return false;
    }
}
