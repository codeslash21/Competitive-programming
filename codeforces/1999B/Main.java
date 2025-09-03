// https://codeforces.com/problemset/problem/1999/B
import java.util.*;

public class B_Card_Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int a1=sc.nextInt(), a2=sc.nextInt(), b1=sc.nextInt(), b2=sc.nextInt();
            int res=0;
            if(a1>b1 && a2>=b2 || a1>=b1 && a2>b2)
                res++;
            if(a1>b2 && a2>=b1 || a1>=b2 && a2>b1)
                res++;
            System.out.println(res*2);
        }
    }
}
