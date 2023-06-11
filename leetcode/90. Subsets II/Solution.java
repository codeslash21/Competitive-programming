// using backtracking
// t.c.=O(n*2^n), s.c.=O(n) because of sorting
class Solution {
    List<List<Integer>> set = new ArrayList<>();
    void backtrack(int first, List<Integer> curr, int[] nums) {
        set.add(new ArrayList(curr));
        for(int i=first;i<nums.length;i++) {
            if(i!=first && nums[i]==nums[i-1])
                continue;
            curr.add(nums[i]);
            backtrack(i+1, curr, nums);
            curr.remove(curr.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(0, new ArrayList(), nums);
        return set;
    }
}
