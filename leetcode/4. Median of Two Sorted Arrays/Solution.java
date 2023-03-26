// Using merge procedure
// t.c.=O(m+n), s.c.=O(m+n)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n = nums2.length;
        int[] arr = new int[m+n];
        int i=0,j=0,k=0;
        while(i<m && j<n) {
            if(nums1[i]<nums2[j])
                arr[k++]=nums1[i++];
            else
                arr[k++]=nums2[j++];
        }
        while(i<m)
            arr[k++]=nums1[i++];
        while(j<n)
            arr[k++]=nums2[j++];
        if((m+n)%2==1)
            return (double)arr[(m+n)/2];
        return (double)(arr[(m+n)/2 - 1]+arr[(m+n)/2])/2;
    }
}

// Without using extra space, just taking the required values
// t.c.=O(m+n), s.c.=O(1)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n = nums2.length;
        int[] arr = new int[2];
        int i=0,j=0,k=0, mid=(m+n+1)/2+1;
        while(i<m && j<n) {
            k++;
            if(nums1[i]<nums2[j]) {
                if(k==(mid-1))
                    arr[0]=nums1[i];
                else if(k==mid)
                    arr[1]=nums1[i];
                i++;
            }
            else {
                if(k==(mid-1))
                    arr[0]=nums2[j];
                else if(k==mid)
                    arr[1]=nums2[j];
                j++;   
            }
            if(k==mid)
                break;
        }
        while(i<m && k<mid) {
            k++;
            if(k==(mid-1))
                arr[0]=nums1[i];
            else if(k==mid)
                arr[1]=nums1[i];
            i++;
        }
        while(j<n && k<mid) {
            k++;
            if(k==(mid-1))
                arr[0]=nums2[j];
            else if(k==mid)
                arr[1]=nums2[j];
            j++;
        }
        if((m+n)%2==1)
            return (double)arr[0];
        return (double)(arr[0]+arr[1])/2;
    }
}
