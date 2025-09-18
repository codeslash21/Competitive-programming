// https://cses.fi/problemset/task/1630
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long sum=0;
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
            sum+=sc.nextInt();
        }
        Arrays.sort(arr);
        for(int i=n-1;i>=0;i--) {
            sum-=(long)arr[i]*(n-i);
        }
        System.out.println(sum);
    }
}
