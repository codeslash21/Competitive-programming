// https://codeforces.com/problemset/problem/1714/A
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int n = sc.nextInt(), H = sc.nextInt(), M = sc.nextInt();
            int res=Integer.MAX_VALUE, curr = 0;
            for(int i=0;i<n;i++) {
                int hi = sc.nextInt(), mi = sc.nextInt();
                if(hi < H || (hi == H && mi < M)) {
                    hi += 24;
                    curr = (hi - H) * 60 + (mi - M);
                    res=Math.min(res, curr);
                } else {
                    curr = (hi - H) * 60 + (mi - M);
                    res=Math.min(res, curr);
                }
            }
            System.out.println(res/60 + " " + res%60);
        }
    }
}
