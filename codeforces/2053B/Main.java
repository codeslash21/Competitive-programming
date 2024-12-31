//https://codeforces.com/contest/2053/problem/B
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while(t-->0) {
            int n = Integer.parseInt((br.readLine()));
            int[] cnt = new int[2*n+1];
            int[] pref = new int[2*n+1];
            int[] l = new int[n];
            int[] r = new int[n];
            for(int i=0;i<n;i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                l[i] = Integer.parseInt(st.nextToken());
                r[i] = Integer.parseInt(st.nextToken());
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
                        pw.print(1);
                    else
                        pw.print(0);
                } else {
                    if(pref[r[i]]-pref[l[i]-1]==r[i]-l[i]+1)
                        pw.print(0);
                    else
                        pw.print(1);
                }
            }
            pw.println("");
        }
        pw.close();
    }
}
