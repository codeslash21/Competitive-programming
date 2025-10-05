// https://codeforces.com/problemset/problem/1913/B
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            String s=sc.next();
            int sLen=s.length(), cntZero=0, cntOne=0, idx=0;
            for(int i=0;i<sLen;i++) 
                if(s.charAt(i)=='0')
                    cntZero++;
                else
                    cntOne++;
            for(idx=0;idx<sLen;idx++)
                if(s.charAt(idx)=='0' && cntOne>0)
                    cntOne--;
                else if(s.charAt(idx)=='1' && cntZero>0)
                    cntZero--;
                else
                    break;
            System.out.println(sLen - idx);
        }
    }
}
