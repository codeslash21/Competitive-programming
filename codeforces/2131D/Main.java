// https://codeforces.com/contest/2131/problem/D
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        l: while(t-->0) {
            int n=sc.nextInt(), totalLeaf=0, totalLeafAtZero=0;
            Map<Integer, List<Integer>> edges = new HashMap<>();
            int[] deg = new int[n+1];
            for(int i=0;i<n-1;i++) {
                int u=sc.nextInt();
                int v=sc.nextInt();
                if(!edges.containsKey(u))
                    edges.put(u, new ArrayList());
                edges.get(u).add(v);
                if(!edges.containsKey(v))
                    edges.put(v, new ArrayList());
                edges.get(v).add(u);
                deg[u]++;
                deg[v]++;
            }
            if(n<3) {
                System.out.println(0);
                continue l;
            }
            for(int i=1;i<=n;i++)
                if(deg[i]==1)
                    totalLeaf++;
            for(List<Integer> neighbours:edges.values()) {
                int currLeaves=0;
                for(Integer neighbour:neighbours)
                    if(deg[neighbour]==1)
                        currLeaves++;
                totalLeafAtZero=Math.max(totalLeafAtZero, currLeaves);
            }
            System.out.println(totalLeaf-totalLeafAtZero);
        }
    }
}
