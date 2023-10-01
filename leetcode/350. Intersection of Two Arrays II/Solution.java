// using hashmap
// t.c.=O(m+n), s.c.=O(min(m,n))
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length<nums2.length)
            return intersect(nums2, nums1);
        ArrayList<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int num:nums2)
            map.put(num, map.getOrDefault(num, 0)+1);
        for(int num:nums1)
            if(map.containsKey(num) && map.get(num)>0) {
                list.add(num);
                map.put(num, map.get(num)-1);
            }
        return list.stream().mapToInt(i->i).toArray();
    }
}
