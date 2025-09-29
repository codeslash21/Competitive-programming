// https://codeforces.com/problemset/problem/1373/B
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            String s=sc.next();
            int cntZero=0, cntOne=0, len=s.length();
            for(int i=0;i<len;i++)
                if(s.charAt(i)=='0')  cntZero++;
                else  cntOne++;
            System.out.println(Math.min(cntZero, cntOne)%2>0?"DA":"NET");
        }
    }
}
