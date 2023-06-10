// t.c.=O(n), s.c.=O(1)
class Solution {
    public int missingNumber(int[] arr) {
        int n=arr.length, sum=0;
        int d=(arr[n-1]-arr[0])/n;
        int total=(n+1)*arr[0]+(n*(n+1)*d)/2;
        for(int i=0;i<n;i++) 
            sum+=arr[i];
        return total-sum;
    }
}

// using binary search
// t.c.=O(logn), s.c.=O(1)
class Solution {
    public int missingNumber(int[] arr) {
        int n=arr.length, d=(arr[n-1]-arr[0])/n;
        int low=0, high=n-1;
        while(low<high) {
            int mid=(low+high)/2;
            if(arr[mid]==arr[0]+mid*d)
                low=mid+1;
            else
                high=mid;
        }
        return arr[0]+low*d;
    }
}
