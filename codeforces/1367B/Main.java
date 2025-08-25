// https://codeforces.com/problemset/problem/1367/B
import java.util.*;

public class B_Even_Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int n=sc.nextInt(), evenCnt=0,evenReq=n/2 + (n%2), misplaced=0;
            for(int i=0;i<n;i++) {
                int ele = sc.nextInt();
                if(ele%2==0)
                  evenCnt++;
                if((i%2)!=(ele%2))
                  misplaced++;
            }
            if(evenCnt==evenReq && misplaced%2==0)
                System.out.println(misplaced/2);
            else 
                System.out.println(-1);
        }
    }
}
