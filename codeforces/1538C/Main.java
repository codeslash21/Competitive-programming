// https://codeforces.com/problemset/problem/1538/C
import java.util.*;

public class C_Number_of_Pairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int n=sc.nextInt(), l=sc.nextInt(), r=sc.nextInt();
            long res=0;
            int[] arr = new int[n];
            for(int i=0;i<n;i++)
                arr[i] = sc.nextInt();
            Arrays.sort(arr);
            for(int i=n-1;i>=0;i--) {
                int ele=arr[i], lowEle=l-ele, highEle=r-ele;
                if(lowEle>ele)
                    break;
                int left=0, right=i-1, lowIdx=Integer.MAX_VALUE, highIdx=Integer.MIN_VALUE;
                while(left<=right) {
                    int mid=left+(right-left)/2;
                    if(arr[mid]>=lowEle) {
                        right=mid-1;
                        lowIdx=Math.min(lowIdx, mid);
                    } else
                        left=mid+1;
                }
                left=0; right=i-1;
                while(left<=right) {
                    int mid=left+(right-left)/2;
                    if(arr[mid]<=highEle) {
                        left=mid+1;
                        highIdx=Math.max(highIdx, mid);
                    } else
                        right=mid-1;
                }
                if(lowIdx==Integer.MAX_VALUE || highIdx==Integer.MIN_VALUE)
                    continue;
                res+=(highIdx-lowIdx+1);
            }
            System.out.println(res);
        }
    }
}
