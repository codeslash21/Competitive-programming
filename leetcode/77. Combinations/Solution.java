// using backtracking
// t.c.=O(k*(nck)), s.c.=O(k)
class Solution {
    int n,k;
    public List<List<Integer>> combine(int n, int k) {
        this.n=n;
        this.k=k;
        List<List<Integer>> res = new ArrayList<>();
        backtrack(new ArrayList<Integer>(), 1, res);
        return res;
    }
    private void backtrack(List<Integer> curr, int firstNum, List<List<Integer>> res) {
        if(curr.size()==k) {
            res.add(new ArrayList<>(curr));
            return;
        }
        int need=k-curr.size();
        int remain=n-firstNum+1;
        int available=remain-need+1;
        for(int val=firstNum;val<firstNum+available;val++) {
            curr.add(val);
            backtrack(curr, val+1, res);
            curr.remove(curr.size()-1);
        }
    }
}
