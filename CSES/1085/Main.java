// https://cses.fi/problemset/task/1085
import java.util.*;

public class Main {
    public static boolean isValid(int[] arr, int n, int k, long mid) {
        int count = 1;
        long sum = 0;
        for(int i=0;i<n;i++) {
            sum+=arr[i];
            if(sum>mid) {
                count++;
                sum = arr[i];
            }
        }
        return count<=k;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        long left=0, right=0, res = Long.MAX_VALUE;
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            int ele = sc.nextInt();
            arr[i] = ele;
            left=Math.max(left, ele);
            right+=ele;
        }
        while(left<=right) {
            long mid = left + (right-left)/2;
            if(isValid(arr, n, k, mid)) {
                res = Math.min(res, mid);
                right = mid - 1;
            } else
                left = mid + 1;
        }
        System.out.println(res);
    }
}
