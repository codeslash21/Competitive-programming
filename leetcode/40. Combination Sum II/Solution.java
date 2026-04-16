// https://leetcode.com/problems/combination-sum-ii/description/
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        Map<Integer, Integer> freq=new HashMap<>();
        List<int[]> pairs=new ArrayList<>();
        for(int candidate:candidates) 
            freq.put(candidate, freq.getOrDefault(candidate, 0)+1);
        for(Map.Entry<Integer, Integer> entry:freq.entrySet())
            pairs.add(new int[]{entry.getKey(), entry.getValue()});
        backtrack(pairs, target, 0, new ArrayList<>(), res);
        return res;
    }
    private void backtrack(List<int[]> pairs, int target, int index, List<Integer> current, List<List<Integer>> res) {
        if(target==0) {
            res.add(new ArrayList<>(current));
            return;
        }
        if(index==pairs.size())
            return;
        int value=pairs.get(index)[0], count=pairs.get(index)[1];
        for(int i=0;i<=count;i++) {
            if(i*value>target)  break;
            for(int j=0;j<i;j++)
                current.add(value);
            backtrack(pairs, target-i*value, index+1, current, res);
            for(int j=0;j<i;j++)
                current.remove(current.size()-1);
        }
    }
}
