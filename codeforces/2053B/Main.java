//https://codeforces.com/contest/2053/problem/B
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int n = sc.nextInt();
            int[] cnt = new int[2*n+1];
            int[] pref = new int[2*n+1];
            int[] l = new int[n];
            int[] r = new int[n];
            for(int i=0;i<n;i++) {
                l[i] = sc.nextInt();
                r[i] = sc.nextInt();
                if(l[i]==r[i])
                    cnt[l[i]]++;
            }
            for(int i=1;i<=2*n;i++) {
                if(cnt[i]>0)
                    pref[i]++;
                pref[i]+=pref[i-1];
            }
            for(int i=0;i<n;i++) {
                if(l[i]==r[i]) {
                    if(cnt[l[i]]<2)
                        System.out.print(1);
                    else
                        System.out.print(0);
                } else {
                    if(pref[r[i]]-pref[l[i]-1]==r[i]-l[i]+1)
                        System.out.print(0);
                    else
                        System.out.print(1);
                }
            }
            System.out.println("");
        }
    }
}
