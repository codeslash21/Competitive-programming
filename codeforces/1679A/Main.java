// https://codeforces.com/problemset/problem/1679/A
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            long n = sc.nextLong();
            if(n%4>0 && n%6>0)
                System.out.println(-1);
            else {
                long max = n/4;
                long min = n/6 + (n%6==0?0:1);
                System.out.println(min+" "+max);
            }
        }
    }
}
