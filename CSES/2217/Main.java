// https://cses.fi/problemset/task/2217/
import java.util.*;

public class Main {
    public static void swap(int[]arr, int a, int b) {
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m=sc.nextInt(), count=1;
        int[] pos = new int[n+1], val = new int[n+1];
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        for(int i=1;i<=n;i++) {
            int ele = sc.nextInt();
            pos[ele] = i;
            val[i]=ele;
        }
        for(int i=2;i<=n;i++)
            if(pos[i-1]>pos[i])
                count++;
        for(int j=0;j<m;j++) {
            int a=sc.nextInt(), b=sc.nextInt();
            if(val[a]>1)
                set.add(List.of(val[a]-1, val[a]));
            if(val[a]<n)
                set.add(List.of(val[a], val[a]+1));
            if(val[b]>1)
                set.add(List.of(val[b]-1, val[b]));
            if(val[b]<n)
                set.add(List.of(val[b], val[b]+1));
            for(List<Integer> pair : set)
                count-=pos[pair.get(0)]>pos[pair.get(1)]?1:0;
            swap(val, a, b);
            pos[val[a]]=a;
            pos[val[b]]=b;
            for(List<Integer> pair : set)
                count+=pos[pair.get(0)]>pos[pair.get(1)]?1:0;
            System.out.println(count);
            set.clear();
        }
    }
}
