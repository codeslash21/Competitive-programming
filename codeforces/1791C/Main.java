// https://codeforces.com/problemset/problem/1791/C
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(), res=0;
        while(t-->0) {
            int n=sc.nextInt(), left=0, right=n-1;
            String s = sc.next();
            while(left<right) {
                char lch=s.charAt(left), rch=s.charAt(right);
                if(Math.abs(lch-rch)!=1)
                    break;
                left++;
                right--;
            }
            System.out.println(right-left+1);
        }
    }
}
