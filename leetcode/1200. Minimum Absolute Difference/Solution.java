// using sorting
// t.c.=O(nlogn), s.c.=O(logn)
class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        int minDiff=Integer.MAX_VALUE, n=arr.length;
        for(int i=0;i<n-1;i++)
            minDiff=Math.min(minDiff, arr[i+1]-arr[i]);
        for(int i=0;i<n-1;i++)
            if(arr[i+1]-arr[i]==minDiff)
                res.add(Arrays.asList(arr[i], arr[i+1]));
        return res;
    }
}
