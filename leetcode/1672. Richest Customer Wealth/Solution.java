class Solution {
    public int maximumWealth(int[][] accounts) {
        int r=accounts.length, c=accounts[0].length;
        int res=0;
        for(int i=0;i<r;i++) {
            int sum=0;
            for(int j=0;j<c;j++)
                sum+=accounts[i][j];
            if(sum>res)
                res=sum;
        }
        return res;
    }
}

