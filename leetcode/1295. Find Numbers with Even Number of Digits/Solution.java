// Linear scan
// t.c.=O(nlogm), s.c=O(1), where m is the max number
class Solution {
    public int checkDigits(int num) {
        int digit=0;
        while(num>0) {
            digit++;
            num/=10;
        }
        return digit;
    }
    public int findNumbers(int[] nums) {
        int n=nums.length;
        int cnt=0;
        for(int i=0;i<n;i++) {
            int noOfDigits = checkDigits(nums[i]);
            if(noOfDigits%2==0)
                cnt++;
        }
        return cnt;
    }
}

// Converting number to string
// t.c.=O(nk), s.c.=O(1), where k is the max digit in a number
class Solution {
    public int findNumbers(int[] nums) {
        int n=nums.length;
        int cnt=0;
        for(int i=0;i<n;i++)
            if(String.valueOf(nums[i]).length()%2==0)
                cnt++;
        return cnt;
    }
}
