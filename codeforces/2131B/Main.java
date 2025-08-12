// https://codeforces.com/contest/2131/problem/B
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int n=sc.nextInt();
            for(int i=0;i<n-1;i++)
                if(i%2==0)
                    System.out.print("-1 ");
                else
                    System.out.print("3 ");
            if(n%2==0)
                System.out.println("2");
            else
                System.out.println("-1");
        }
    }
}
