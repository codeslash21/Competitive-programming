// https://cses.fi/problemset/task/1631
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long sum=0, max=Long.MIN_VALUE;
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            int ele = sc.nextInt();
            arr[i] = ele;
            sum += ele;
            max = Math.max(max, ele);
        }
        sum-=max;
        if(max<=sum)
            System.out.println(sum+max);
        else
            System.out.println(2*max);
    }
}
