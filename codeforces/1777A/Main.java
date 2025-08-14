// https://codeforces.com/problemset/problem/1777/A
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        l: while(t-->0) {
            int n = sc.nextInt(), res=0;
            int prev=(sc.nextInt()%2);
            for(int i=1;i<n;i++) {
                int ele=sc.nextInt()%2;
                if(prev==ele)
                    res++;
                prev=ele;
            }
            System.out.println(res);
        }
    }
}
