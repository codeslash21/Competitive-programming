// https://codeforces.com/problemset/problem/1883/C
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int n=sc.nextInt(), k=sc.nextInt(), res=Integer.MAX_VALUE, cnt=0;
            for(int i=0;i<n;i++) {
                int ele=sc.nextInt();
                if(ele%2==0)
                    cnt++;
                if(ele%k==0)
                    res=0;
                else
                    res=Math.min(res, k-ele%k);
            }
            if(k==4)                 
                res=n==1?res:Math.min(res, Math.max(0, 2-cnt));
            System.out.println(res);
        }
    }
}
