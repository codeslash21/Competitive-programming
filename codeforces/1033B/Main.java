// https://codeforces.com/problemset/problem/1033/B
import java.util.*;

public class B_Square_Difference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        l: while(t-->0) {
            long a=sc.nextLong(), b=sc.nextLong();
            if(a-b!=1)
                System.out.println("NO");
            else {
                long num=a+b;
                for(long i=2;i*i<=num;i++)
                    if(num%i==0) {
                        System.out.println("NO");
                        continue l;
                    } 
                System.out.println("YES");
            }
        }
    }
}
