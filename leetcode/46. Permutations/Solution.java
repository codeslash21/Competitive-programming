// using backtracking
// t.c.=O(n*n!), s.c.=O(n)
class Solution {
    boolean[] contains = new boolean[21];
    int n;
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        n=nums.length;
        backtrack(new ArrayList<>(), nums);
        return res;
    }
    private void backtrack(List<Integer> perm, int[] nums) {
        if(perm.size()==n) {
            res.add(new ArrayList<>(perm));
            return;
        }
        for(int num:nums) {
            if(!contains[num+10]) {
                perm.add(num);
                contains[num+10]=true;
                backtrack(perm, nums);
                perm.remove(perm.size()-1);
                contains[num+10]=false;
            }
        }
    }
}
