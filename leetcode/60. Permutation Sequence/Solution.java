// using backtracking
// t.c.=O(n*k), s.c.=O(n)
class Solution {
    boolean found=false;
    boolean[] taken = new boolean[10];
    int k;
    public String getPermutation(int n, int k) {
        this.k=k;
        StringBuilder sb = new StringBuilder();
        backtrack(n, sb);
        return sb.toString();
    }
    private void backtrack(int n, StringBuilder sb) {
        if(sb.length()==n) {
            k--;
            if(k==0) 
                found=true;
            return;
        }
        for(int i=1;i<=n;i++) {
            if(!taken[i]) {
                sb.append(i);
                taken[i]=true;
                backtrack(n, sb);
                if(found)
                    return;
                sb.deleteCharAt(sb.length()-1);
                taken[i]=false;
            }
        }
    }
}

// using factorial number system
// t.c.=O(n^2), s.c.=O(n)
class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>() {{add(1);}};
        int[] fact = new int[n];
        StringBuilder sb = new StringBuilder();
        fact[0]=1;
        for(int i=1;i<n;i++) {
            fact[i]=fact[i-1]*i;
            nums.add(i+1);
        }
        k--;
        for(int i=n-1;i>-1;i--) {
            int idx=k/fact[i];
            k-=idx*fact[i];
            sb.append(nums.get(idx));
            nums.remove(idx);
        }
        return sb.toString();
    }
}
