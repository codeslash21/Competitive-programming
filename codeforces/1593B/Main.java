// https://codeforces.com/problemset/problem/1593/B
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String[] suffix = {"00", "25", "50", "75"};
        while(t-->0) {
            String num = sc.next();
            int res=Integer.MAX_VALUE, len=num.length();
            for(String s:suffix) {
                int i=len-1, j=1;
                while(i>=0 && j>=0) {
                    if(num.charAt(i)==s.charAt(j))
                        j--;
                    i--;
                }
                if(j<0)
                    res=Math.min(res, len-i-3);
            }
            System.out.println(res);
        }
    }
}
