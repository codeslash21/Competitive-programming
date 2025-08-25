// https://codeforces.com/problemset/problem/1845/A
Copy
import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int n = sc.nextInt(), k = sc.nextInt(), x = sc.nextInt();
            StringBuilder sb = new StringBuilder();
            int min_odd = x == 1 ? 3 : 1, min_even = x == 2 ? 4 : 2;
            if(x!=1) {
                System.out.println("YES");
                System.out.println(n);
                for(int i=0;i<n;i++)
                    System.out.print("1 ");
                System.out.println();
            } else if(k==1 || (k==2 && n%2>0)) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
                System.out.println(n/2);
                int first = n%2>0?3:2;
                System.out.print(first + " ");
                n-=first;
                for(int i=0;i<n/2;i++)
                    System.out.print("2 ");
                System.out.println();
            }
        }
    }
}
