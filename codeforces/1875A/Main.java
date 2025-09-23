// https://codeforces.com/problemset/problem/1875/A
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int a=sc.nextInt(), b=sc.nextInt(), n=sc.nextInt(), diff=a-1;
            long sum=b;
            for(int i=0;i<n;i++) {
                long val=sc.nextLong();
                sum+=Math.min(val, diff);
            }
            System.out.println(sum);
        }
    }
}
