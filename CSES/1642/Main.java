// https://cses.fi/problemset/task/1642
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), x = sc.nextInt();
        int[][] arr = new int[n][2];
        for(int i=0;i<n;i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = i+1;
        }
        Arrays.sort(arr, (a,b)->a[0]-b[0]);
        for(int i=0;i<n-3;i++) {
            for(int j=i+1;j<n-2;j++) {
                int left=j+1, right=n-1;
                while(left<right) {
                    long sum = (long) arr[i][0] + arr[j][0] + arr[left][0] + arr[right][0];
                    if (sum == x) {
                        System.out.println(arr[i][1] + " " + arr[j][1] + " " + arr[left][1] + " " + arr[right][1]);
                        return;
                    } else if (sum > x)
                        right--;
                    else
                        left++;
                }
            }
        }
        System.out.println("IMPOSSIBLE");
    }
}
