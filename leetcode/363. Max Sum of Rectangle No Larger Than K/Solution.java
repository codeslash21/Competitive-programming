// using prefix sum
// t.c.=O(m^2*n*logn), s.c.=O(n)
class Solution {
  int result=Integer.MIN_VALUE;
  void updateResult(int[] arr, int k) {
    int sum=0;
    TreeSet<Integer> sortedSum = new TreeSet<>();
    sortedSum.add(0);
    for(int num:arr) {
      sum+=num;
      Integer x = sortedSum.ceiling(sum-k);
      if(x!=null)
        result=Math.max(result, sum-x);
      sortedSum.add(sum);
    }
  }
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m=matrix.length, n=matrix[0].length;
        int[] rowSum=new int[n];
        for(int i=0;i<m;i++) {
          Arrays.fill(rowSum, 0);
          for(int j=i;j<m;j++) {
            for(int col=0; col<n; col++)
              rowSum[col]+=matrix[j][col];
            updateResult(rowSum, k);
            if(result==k)
              return k;
          }
        }
        return result;
    }
}
