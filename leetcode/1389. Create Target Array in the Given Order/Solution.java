// Using built-in function for ArrayList
// t.c.=O(n^2), s.c.=O(n)
class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        int n=nums.length;
        int[] target = new int[n];
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<n;i++)
            arr.add(index[i], nums[i]);
        for(int i=0;i<n;i++)
            target[i]=arr.get(i);
        return target;
    }
}

// Without using built-in function
// t.c.=O(n^2), s.c.=O(1)
class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        int n=nums.length;
        int[] target = new int[n];
        for(int i=0;i<n;i++) {
            if(index[i]<i) {
                int j=i;
                while(index[i]<j) {
                    target[j]=target[j-1];
                    j--;
                }
            }
            target[index[i]]=nums[i];
        }
        return target;
    }
}
