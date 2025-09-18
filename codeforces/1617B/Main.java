// https://codeforces.com/contest/1617/problem/B
import java.util.*;

public class B_GCD_Problem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int n = sc.nextInt()-1;
            if(n%2==0) {
                int num = n/2;
                if(num%2==0)
                    System.out.println((num-1)+" "+(num+1)+" "+1);
                else
                    System.out.println((num-2)+" "+(num+2)+" "+1);
            } else 
                System.out.println((n/2)+" "+(n/2+1)+" "+1);
        }
    }
}
