// https://codeforces.com/problemset/problem/1543/A
import java.util.*;

public class Main {
    public static void Main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            long a=sc.nextLong(), b=sc.nextLong();
            long maxValue=Math.abs(a-b), mod=maxValue==0?0:a%maxValue, minOp=0;
            if(Math.min(a,b)!=0 && maxValue>1)
                minOp=Math.min(mod, maxValue-mod);
            System.out.println(maxValue+" "+minOp);
        }
    }
}
