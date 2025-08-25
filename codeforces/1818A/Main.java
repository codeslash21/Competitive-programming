// https://codeforces.com/problemset/problem/1818/A
import java.util.*;

public class A_Politics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int n=sc.nextInt(), k = sc.nextInt(), count=1;
            String president = sc.next();
            for(int i=1;i<n;i++) {
                String member = sc.next();
                if(president.equals(member))
                    count++;
            }
            System.out.println(count);
        }
    }
}
