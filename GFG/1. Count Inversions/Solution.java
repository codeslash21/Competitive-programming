// Using merge sort technique
// t.c.=O(nlogn), s.c.=O(n)
class Solution
{
    static long mergeAndCount(long[] arr, int l, int mid, int r) {
        long[] K = new long[r-l+1];
        int i=l,j=mid+1, k=0;
        long cnt=0;
        while(i<=mid && j<= r) {
            if(arr[i]<=arr[j])
                K[k++]=arr[i++];
            else {
                K[k++]=arr[j++];
                cnt+=(mid+1-i);
            }
        }
        while(i<=mid)
            K[k++]=arr[i++];
        while(j<=r)
            K[k++]=arr[j++];
        for(int m=0;m<r-l+1;m++)
            arr[l+m]=K[m];
        return cnt;
    }
    static long mergeSortCount(long[] arr, int l, int r) {
        long cnt=0;
        if(l<r) {
            int mid=(l+r)/2;
            cnt+=mergeSortCount(arr, l, mid);
            cnt+=mergeSortCount(arr, mid+1, r);
            cnt+=mergeAndCount(arr, l, mid, r);
        }
        return cnt;
    }
    static long inversionCount(long arr[], long N)
    {
        return mergeSortCount(arr, 0, (int)N-1);
    }
}

