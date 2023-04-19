// Using linear scan
// t.c.=O(n), s.c.=O(1)
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len=flowerbed.length, planted=0, cnt0;
        cnt0=flowerbed[0]==0?1:0;
        for(int i=0;i<len;i++) {
            if(flowerbed[i]==1) {
                planted+=cnt0==0?0:(cnt0-1)/2;
                cnt0=0;
            }
            else
                cnt0++;
        }
        if(cnt0!=0)
            planted+=cnt0/2;
        return planted>=n;
    }
}
