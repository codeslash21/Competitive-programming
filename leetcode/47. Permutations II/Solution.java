// https://leetcode.com/problems/permutations-ii/description/
// using hashmap
// t.c.=O(n*k), s.c.=O(n), n=number of elements, k=number of unique permutation
class Solution {
    private void backtrack(int[] nums, Map<Integer, Integer> freq, List<List<Integer>> permutations, List<Integer> permutation) {
        if(permutation.size()==nums.length) {
            permutations.add(new ArrayList<>(permutation));
            return;
        }
        for(Integer key:freq.keySet()) {
            if(freq.get(key)==0)    continue;
            freq.put(key, freq.get(key)-1);
            permutation.add(key);
            backtrack(nums, freq, permutations, permutation);
            permutation.remove(permutation.size()-1);
            freq.put(key, freq.get(key)+1);
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> permutations=new ArrayList<>();
        Map<Integer, Integer> freq=new HashMap<>();
        for(int num:nums)
            freq.put(num, freq.getOrDefault(num, 0)+1);
        backtrack(nums, freq, permutations, new ArrayList<>());
        return permutations;
    }
}
