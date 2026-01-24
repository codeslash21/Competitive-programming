// https://cses.fi/problemset/task/1094
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt(), prev=0, curr=0;
        long minMoves=0;
        while(n-->0) {
            curr=sc.nextInt();
            if(curr<prev) {
                minMoves+=(prev-curr);
                curr=prev;
            }
            prev=curr;
        }
        System.out.println(minMoves);
    }
}
