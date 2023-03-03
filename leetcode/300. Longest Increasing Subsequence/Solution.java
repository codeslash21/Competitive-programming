// Using DP
// t.c.=O(n^2), s.c.=O(n)
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length, largest=0;
        int[] dp=new int[n];
        Arrays.fill(dp, 1);
        for(int i=1;i<n;i++)
            for(int j=0;j<i;j++)
                if(nums[i]>nums[j])
                    dp[i]=Math.max(dp[i], dp[j]+1);
        for(int c:dp)
            largest=Math.max(largest, c);
        return largest;
    }
}

// Build subsequence on the way
// t.c.=O(n^2), s.c.=O(n)
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        ArrayList<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);
        for(int i=1;i<n;i++) {
            int num=nums[i];
            if(num>sub.get(sub.size()-1))
                sub.add(num);
            else {
                int j=0;
                while(num>sub.get(j))
                    j+=1;
                sub.set(j, num);
            }
        }
        return sub.size();
    }
}

// Using binary search
// t.c.=O(nlogn), s.c.=O(1)
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        ArrayList<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);
        for(int i=1;i<n;i++) {
            int num=nums[i];
            if(num>sub.get(sub.size()-1))
                sub.add(num);
            else {
                int j = binSearch(sub, num);
                sub.set(j, num);
            }
        }
        return sub.size();
    }

    public int binSearch(ArrayList<Integer> sub, int num) {
        int left=0, right=sub.size()-1;
        int mid=(left+right)/2;
        while(left<right) {
            mid=(left+right)/2;
            if(sub.get(mid)==num)
                return mid;
            if(sub.get(mid)<num)
                left=mid+1;
            else    
                right=mid;
        }
        return right;
    }
}
