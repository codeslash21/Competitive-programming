// Using two pointers
// t.c.=O(nlogn), s.c.=O(1)
class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length;
        int sum=-1;
        int left=0, right=n-1;
        while(left<right) {
            int val = nums[left]+nums[right];
            if(val<k) {
                sum=Math.max(sum, val);
                left++;
            }
            else 
                right--;
        }
        return sum;
    }
}

// using counting sort
// t.c.=O(n+m), s.c.=O(m), where m is the range of the input array
class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        int answer=-1;
        int[] count = new int[1001];
        for(int n:nums)
            count[n]++;
        int lo=1, hi=Math.min(1000, k-1);
        while(lo<=hi) {
            if(lo>k/2)
                break;
            if(lo+hi>=k || count[hi]==0)
                hi--;
            else{
                if(count[lo]>(lo==hi?1:0))
                    answer=Math.max(answer, lo+hi);
                lo++;
            }
        }
        return answer;
    }
}

// Using binary search
// t.c.=O(nlogn), s.c.=O(1)
class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        int answer = -1;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; ++i) {
            int idx = Arrays.binarySearch(nums, i + 1, nums.length, k - nums[i] - 1);
            int j = (idx >= 0 ? idx : ~idx);
            if (j == nums.length || nums[j] > k - nums[i] - 1) {
                j--;
            }
            if (j > i) {
                answer = Math.max(answer, nums[i] + nums[j]);
            }
        }
        return answer;
    }
}
