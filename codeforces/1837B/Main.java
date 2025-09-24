// https://codeforces.com/problemset/problem/1837/B
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int n=sc.nextInt(), cnt=1, res=0;
            String s=sc.next();
            for(int i=1;i<n;i++) 
                if(s.charAt(i)==s.charAt(i-1))
                    cnt++;
                else {
                    res=Math.max(res, cnt);
                    cnt=1;
                }
            res=Math.max(res, cnt);
            System.out.println(res+1);
        }
    }
}
