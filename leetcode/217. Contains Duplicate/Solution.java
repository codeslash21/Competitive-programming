// using set
// t.c.=O(n), s.c.=O(n)
class Solution {
    public boolean containsDuplicate(int[] nums) {
        int n=nums.length;
        Set<Integer> set = new HashSet<>();
        for(int i:nums) {
            if(set.contains(i)) return true;
            set.add(i);
        }
        return false;
    }
}
