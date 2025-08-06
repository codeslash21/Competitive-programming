// https://codeforces.com/problemset/problem/1829/B
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int currLen=0, maxLen=0;
            int n = sc.nextInt();
            for(int i=0;i<n;i++) {
                int ele=sc.nextInt();
                if(ele==0) {
                    currLen++;
                    maxLen=Math.max(maxLen, currLen);
                } else
                    currLen=0;
            }
            System.out.println(maxLen);
        }
    }
}
