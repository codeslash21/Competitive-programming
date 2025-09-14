// https://codeforces.com/problemset/problem/1762/A
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int n = sc.nextInt();
            int res=Integer.MAX_VALUE, sum=0;
            for(int i=0;i<n;i++) {
                int ele = sc.nextInt();
                sum+=ele;
                if(ele%2==0) {
                    int cnt=0;
                    while(ele%2<1) {
                        cnt++;
                        ele/=2;     
                    }
                    res=Math.min(res, cnt);
                } else {
                    int cnt=0;
                    while(ele%2>0) {
                        cnt++;
                        ele/=2;
                    }
                    res = Math.min(res, cnt);
                }
            }
            System.out.println((sum%2)==0?0:res);
        }
    }
}
