// https://codeforces.com/problemset/problem/266/B
import java.util.*;

public class B_Queue_at_the_School {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), t = sc.nextInt();
        char[] chars = sc.next().toCharArray();
        for(int i=0;i<t;i++) {
            for(int j=0;j<n-1;j++) 
                if(chars[j]=='B' && chars[j+1]=='G') {
                    chars[j]='G';
                    chars[j+1]='B';
                    j+=1;
                }
        }
        System.out.println(String.valueOf(chars));
    }
}
