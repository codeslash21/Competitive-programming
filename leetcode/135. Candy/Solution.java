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

// using greedy
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int candy(int[] ratings) {
        int len=ratings.length, minCandy=len, idx=1;
        while(idx<len) {
            while(idx<len && ratings[idx-1]==ratings[idx])
                idx++;
            int inc=0, dec=0;
            while(idx<len && ratings[idx-1]<ratings[idx]) {
                inc++;
                minCandy+=inc;
                idx++;
            }
            while(idx<len && ratings[idx-1]>ratings[idx]) {
                dec++;
                minCandy+=dec;
                idx++;
            }
            minCandy-=Math.min(inc, dec);
        }
        return minCandy;
    }
}
