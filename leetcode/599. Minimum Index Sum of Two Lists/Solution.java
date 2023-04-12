// Without using hashmap
// t.c.=O((l1+l2)^2 * x), s.c.=O(r*x), where r is the size of resultant array
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> list = new ArrayList<>();
        for(int sum=0; sum<list1.length+list2.length-1; sum++) {
            for(int i=0;i<=sum; i++) {
                if(i<list1.length && sum-i<list2.length && list1[i].equals(list2[sum-i]))
                    list.add(list1[i]);
            }
            if(list.size()>0)
                break;
        }
        return list.toArray(new String[list.size()]);
    }
}

// using hashmap
// t.c.=O(l1+l2), s.c.=O(l1*x) where x is the avg length of string
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for(int i=0;i<list1.length;i++)
            map.put(list1[i], i);
        List<String> s = new ArrayList<>();
        for(int i=0;i<list2.length;i++)
            if(map.containsKey(list2[i])) {
                int idx=map.get(list2[i])+i;
                if(idx==min)
                    s.add(list2[i]);
                else if(idx<min) {
                    s.clear();
                    min=idx;
                    s.add(list2[i]);
                }
            }
        return s.toArray(new String[s.size()]);
    }
}
