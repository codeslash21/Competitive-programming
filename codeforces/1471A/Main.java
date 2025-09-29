// https://codeforces.com/problemset/problem/1471/A
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int n=sc.nextInt(), x=sc.nextInt();
            long sum=0, totalSum=0;
            for(int i=0;i<n;i++) {
                int ele=sc.nextInt();
                sum+=Math.ceil((double)ele/x);
                totalSum+=ele;
            }
            System.out.println((long)Math.ceil((double)totalSum/x)+" "+sum);
        }
    }
}
