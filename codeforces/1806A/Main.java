// https://codeforces.com/problemset/problem/1806/A
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            long a=sc.nextLong(), b=sc.nextLong(), c=sc.nextLong(), d=sc.nextLong();
            long xDiff=c-a, yDiff=d-b;
            if(yDiff<0 || (yDiff==0 && xDiff>0) || yDiff<xDiff)
                System.out.println(-1);
            else {
                long res=2*yDiff-xDiff;
                System.out.println(res);
            }
        }
    }
}
