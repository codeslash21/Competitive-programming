// generating subsets from the previous subsets
// t.c.=O(n*2^n), s.c.=O(n*2^n)
class Solution {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> res=new ArrayList<>();
    res.add(new ArrayList<Integer>());
    for(int num:nums) {
      int n=res.size();
      for(int i=0;i<n;i++)
          res.add(new ArrayList<Integer>(res.get(i)){{add(num);}});
    }
    return res;
  }
}

// using backtracking
// t.c.=O(n*2^n), s.c.=O(n*2^n)
class Solution {
  int n,k;
  List<List<Integer>> res = new ArrayList<>();
  public void backtrack(int first,List<Integer> curr,int[] nums) {
    if(curr.size()==k) {
      res.add(new ArrayList(curr));
      return;
    }
    for(int i=first;i<n;i++) {
      curr.add(nums[i]);
      backtrack(i+1, curr, nums);
      curr.remove(curr.size()-1);
    }
  }
  public List<List<Integer>> subsets(int[] nums) {
    n=nums.length;
    for(k=0;k<n+1;k++)
      backtrack(0, new ArrayList(), nums);
    return res;
  }
}

