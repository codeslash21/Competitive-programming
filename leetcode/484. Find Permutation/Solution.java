// https://leetcode.com/problems/find-permutation/description/
// linear algorithm
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int[] findPermutation(String s) {
        int len=s.length();
        int[] arr=new int[len+1];
        for(int i=1;i<=len+1;i++)
            arr[i-1]=i;
        for(int i=0;i<len;i++)
            if(s.charAt(i)=='D') {
                int start=i, end=i;
                while(end<len && s.charAt(end)=='D')
                    end++;
                i=end-1;
                while(start<end) {
                    int temp=arr[start];
                    arr[start++]=arr[end];
                    arr[end--]=temp;
                }
            }
        return arr;
    }
}
