// https://codeforces.com/problemset/problem/1607/B
import java.util.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        l: while(t-->0) {
            long x=sc.nextLong(), n=sc.nextLong(), pos=n%4, parity=((x%2)+2)%2, val=0;
            BigInteger currPos = BigInteger.valueOf(x);
            if(n==0) {
                System.out.println(x);
                continue l;
            }
            if(pos==0)
                val = 0;
            else if(pos==1)
                val = parity==1?n:n*(-1);
            else if(pos==2)
                val = parity==1?-1:1;
            else
                val = parity==1?(-1)*(n+1):(n+1);
            BigInteger res = currPos.add(BigInteger.valueOf(val));
            System.out.println(res);
        }
    }
}
