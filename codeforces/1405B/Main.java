// https://codeforces.com/problemset/problem/1405/B
import java.util.*;

public class B_Array_Cancellation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int n = sc.nextInt();
            long currSum = 0, res = 0;
            for(int i=0;i<n;i++) {
                currSum += sc.nextInt();
                if(currSum < 0)
                    res = Math.min(res, currSum);
            }
            System.out.println(-res);
        }
    }
}
