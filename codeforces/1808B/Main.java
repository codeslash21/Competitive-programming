// https://codeforces.com/contest/1808/problem/B
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int n = sc.nextInt(), m = sc.nextInt();
            long sum = 0;
            Long[][] arr = new Long[m][n];
            for(int i=0;i<n;i++)
                for(int j=0;j<m;j++)
                    arr[j][i] = sc.nextLong();
            for(int j=0;j<m;j++) {
                Arrays.sort(arr[j], Collections.reverseOrder());
                for(int i=0;i<n;i++) 
                    sum+=(n-1-i-i)*arr[j][i];
            }
            System.out.println(sum);
        }
    }
}
