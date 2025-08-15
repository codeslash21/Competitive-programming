// https://codeforces.com/contest/1629/problem/B
import java.util.*;

public class B_GCD_Arrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        l: while(t-->0) {
            int l=sc.nextInt(), r=sc.nextInt(), k=sc.nextInt();
            int size=(r-l+1);
            if(size==1) {
                System.out.println(l==1?"NO":"YES");
                continue l;
            }
            int numberOfOdd=size-(r/2-(l-1)/2);
            System.out.println(numberOfOdd<=k?"YES":"NO");
        }
    }
}
