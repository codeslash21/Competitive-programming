// https://codeforces.com/problemset/problem/1805/A
import java.util.*;

public class Main {
    public static void findSetBit(int[] bits, int n) {
        int i=31;
        while(n>0) {
            if((n&1)>0)
                bits[i]+=1;
            n>>=1;
            i--;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(), res=0;
        while(t-->0) {
            int[] bits = new int[32];
            int n=sc.nextInt();
            for(int i=0;i<n;i++) {
                int num = sc.nextInt();
                findSetBit(bits, num);
            }
            for(int i=0;i<32;i++) {
                res=res*2+(bits[i]%2);
            }
            if(n%2==0 && res>0)
                System.out.println(-1);
            else
                System.out.println(res);
        }
    }
}
