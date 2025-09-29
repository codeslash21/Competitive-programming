// https://codeforces.com/problemset/problem/1742/E
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int n=sc.nextInt(), q=sc.nextInt();
            int[] arr = new int[n+1], maxArr = new int[n+1];
            long[] prefix = new long[n+1];
            for(int i=1;i<=n;i++) {
                int ele = sc.nextInt();
                arr[i] = ele;
                prefix[i]=prefix[i-1]+ele;
                maxArr[i] = Math.max(ele, maxArr[i-1]);
            }
            while(q-->0) {
                int left=0, right=n, legLength=sc.nextInt(), maxIdx=0;
                while(left<=right) {
                    int mid=left+(right-left)/2;
                    if(legLength<maxArr[mid])
                        right=mid-1;
                    else {
                        maxIdx=Math.max(maxIdx, mid);
                        left=mid+1;
                    }
                }
                System.out.print((prefix[maxIdx]-prefix[0])+" ");
            }
            System.out.println();
        }
    }
}
