// https://cses.fi/problemset/task/1620
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt(), minTime = Integer.MAX_VALUE;
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            int ele = sc.nextInt();
            arr[i] = ele;
            minTime = Math.min(minTime, ele);
        }
        long left = 1, right = (long)k*minTime, res=Long.MAX_VALUE;
        while(left<=right) {
            long mid = left+(right-left)/2, total=0;
            for(int i=0;i<n;i++)
                total+=(long)mid/arr[i];
            if(total<k)
                left=mid+1;
            else {
                res=Math.min(res, mid);
                right=mid-1;
            }
        }
        System.out.println(res);
    }
}
