// Using bruteforce method
// t.c.=O(n^2), s.c.=O(1)
class Solution {
    public int[] replaceElements(int[] arr) {
        int n=arr.length;
        for(int i=0;i<n-1;i++) {
            int max=Integer.MIN_VALUE;
            for(int j=i+1;j<n;j++) {
                if(arr[j]>max)
                    max=arr[j];
            }
            arr[i]=max;
        }
        arr[n-1]=-1;
        return arr;
    }
}
// Optimized bruteforce method
//t.c.=O(n^2), s.c.=O(1)
class Solution {
    public int[] replaceElements(int[] arr) {
        int n=arr.length;
        int max=Integer.MIN_VALUE;
        int max_i=0;
        for(int i=0;i<n-1;i++) {
            if(i>=max_i) {
                max=0;
                for(int j=i+1;j<n;j++) {
                    if(arr[j]>max) {
                        max=arr[j];
                        max_i=j;
                    }
                }
            }
            arr[i]=max;
        }
        arr[n-1]=-1;
        return arr;
    }
}

// Using linear search
// t.c.=O(n) s.c.=O(1)
class Solution {
    public int[] replaceElements(int[] arr) {
        int n=arr.length;
        int max=-1;
        int temp_max;
        for(int i=n-1;i>=0;i--) {
            temp_max=arr[i];
            arr[i]=max;
            if(temp_max>max)
                max=temp_max;
        }
        return arr;
    }
}
