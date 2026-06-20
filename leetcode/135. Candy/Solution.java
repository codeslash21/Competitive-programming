// https://leetcode.com/problems/candy/description/
// using brute force technique
// t.c.=O(n^2), s.c.=O(n)
class Solution {
    public int candy(int[] ratings) {
        int len=ratings.length, minCandy=0;
        int[] candy=new int[len];
        Arrays.fill(candy, 1);
        boolean changed=true;
        while(changed) {
            changed=false;
            for(int i=0;i<len;i++) {
                // check left neighbor
                if(i>0 && ratings[i-1]<ratings[i] && candy[i-1]>=candy[i]) {
                    candy[i]=candy[i-1]+1;
                    changed=true;
                }
                // check right neighbor
                if(i<len-1 && ratings[i]>ratings[i+1] && candy[i]<=candy[i+1]) {
                    candy[i]=candy[i+1]+1;
                    changed=true;
                }
            }
        }
        for(int num:candy)
            minCandy+=num;
        return minCandy;
    }
}
