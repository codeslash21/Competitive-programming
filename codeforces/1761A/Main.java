// https://codeforces.com/problemset/problem/1761/A
import java.util.*;

public class A_Two_Permutations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int n = sc.nextInt(), a = sc.nextInt(), b = sc.nextInt(), max=Math.max(a,b), min=Math.min(a,b);
            if(max==n) 
                System.out.println(min==n?"Yes":"No");
            else {
                if((a+b)<=n)
                    System.out.println(n-a-b>1?"Yes":"No");
                else
                    System.out.println("No");
            }
        }
    }
}
