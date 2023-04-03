// Using backtracking
// t.c.=O(n.n!), s.c.=O(n)
class Solution {
    public boolean backtrack(int[] nums, int count, int currSum, int k, int targetSum, boolean[] taken) {
        int n=nums.length;
        if(count==k-1)
            return true;
        if(currSum==targetSum)
            return backtrack(nums, count+1, 0, k, targetSum, taken);
        if(targetSum<currSum)
            return false;
        for(int i=0;i<n;i++) {
            if(!taken[i]) {
                taken[i]=true;
                if(backtrack(nums, count, currSum+nums[i], k, targetSum, taken))
                    return true;
                taken[i]=false;
            }
        }
        return false;
    }
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n=nums.length, totalSum=0;
        for(int i=0;i<n;i++)
            totalSum+=nums[i];
        if(totalSum%k!=0)
            return false;
        boolean[] taken = new boolean[n];
        return backtrack(nums, 0, 0, k, totalSum/k, taken);
    }
}

// Optimize backtracking by using sorting in descending order
// t.c.=O(k*2^n), s.c.=O(n)
class Solution {
    public boolean backtrack(int[] nums, int index, int count, int currSum, int k, int targetSum, boolean[] taken) {
        int n=nums.length;
        if(count==k-1)
            return true;
        if(currSum==targetSum)
            return backtrack(nums, 0, count+1, 0, k, targetSum, taken);
        if(targetSum<currSum)
            return false;
        for(int i=index;i<n;i++) {
            if(!taken[i]) {
                taken[i]=true;
                if(backtrack(nums, i+1, count, currSum+nums[i], k, targetSum, taken))
                    return true;
                taken[i]=false;
            }
        }
        return false;
    }
    public void reverse(int[] arr) {
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) { 
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n=nums.length, totalSum=0;
        for(int i=0;i<n;i++)
            totalSum+=nums[i];
        if(totalSum%k!=0)
            return false;
        Arrays.sort(nums);
        reverse(nums);
        boolean[] taken = new boolean[n];
        return backtrack(nums, 0, 0, 0, k, totalSum/k, taken);
    }
}

// Using backtracking and memoization
// t.c.=O(k*2^n), s.c.=O(n*2^n)
class Solution {
    public boolean backtrack(int[] nums, int index, int count, int currSum, int k, int targetSum, char[] taken, Map<String, Boolean> memo) {
        int n=nums.length;
        String takenStr = new String(taken);
        if(memo.containsKey(takenStr))
            return memo.get(takenStr);
        if(count==k-1)
            return true;
        if(currSum==targetSum){
            boolean ans = backtrack(nums, 0, count+1, 0, k, targetSum, taken, memo);
            memo.put(takenStr, ans);
            return ans;
        }
        if(targetSum<currSum){
            memo.put(takenStr, false);
            return false;
        }
        for(int i=index;i<n;i++) {
            if(taken[i]=='0') {
                taken[i]='1';
                if(backtrack(nums, i+1, count, currSum+nums[i], k, targetSum, taken, memo))
                    return true;
                taken[i]='0';
            }
        }
        memo.put(takenStr, false);
        return false;
    }
    public void reverse(int[] arr) {
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) { 
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n=nums.length, totalSum=0;
        for(int i=0;i<n;i++)
            totalSum+=nums[i];
        if(totalSum%k!=0)
            return false;
        Arrays.sort(nums);
        reverse(nums);
        char[] taken = new char[n];
        for(int i=0;i<n;i++)
            taken[i]='0';
        Map<String, Boolean> memo = new HashMap<>();
        return backtrack(nums, 0, 0, 0, k, totalSum/k, taken, memo);
    }
}

// using mask integer instead of char array
// t.c.=O(k*2^n), s.c.=O(2^n)
class Solution {
    public boolean backtrack(int[] nums, int index, int count, int currSum, int k, int targetSum, int mask, Map<Integer, Boolean> memo) {
        int n=nums.length;
        if(memo.containsKey(mask))
            return memo.get(mask);
        if(count==k-1)
            return true;
        if(currSum==targetSum){
            boolean ans = backtrack(nums, 0, count+1, 0, k, targetSum, mask, memo);
            memo.put(mask, ans);
            return ans;
        }
        if(targetSum<currSum){
            memo.put(mask, false);
            return false;
        }
        for(int i=index;i<n;i++) {
            if(((mask>>i)&1)==0) {
                mask |= (1<<i);
                if(backtrack(nums, i+1, count, currSum+nums[i], k, targetSum, mask, memo))
                    return true;
                mask ^= (1<<i);
            }
        }
        memo.put(mask, false);
        return false;
    }
    public void reverse(int[] arr) {
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) { 
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n=nums.length, totalSum=0;
        for(int i=0;i<n;i++)
            totalSum+=nums[i];
        if(totalSum%k!=0)
            return false;
        Arrays.sort(nums);
        reverse(nums);
        int mask=0;
        Map<Integer, Boolean> memo = new HashMap<>();
        return backtrack(nums, 0, 0, 0, k, totalSum/k, mask, memo);
    }
}
