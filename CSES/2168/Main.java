// https://cses.fi/problemset/task/2168
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), right=0;
        List<List<Integer>> lists = new ArrayList<>();
        Map<List<Integer>, Integer> map = new HashMap<>();
        int[] contains = new int[n], contained = new int[n];
        for(int i=0;i<n;i++) {
            int start = sc.nextInt(), end = sc.nextInt();
            List<Integer> list = new ArrayList<>(Arrays.asList(start, end));
            lists.add(list);
            map.put(list, i);
        }
        Collections.sort(lists, (a,b)-> {
            if(a.get(0)==b.get(0))
                return b.get(1)-a.get(1);
            return a.get(0)-b.get(0);
        });
        for(int i=0;i<n;i++) {
            List<Integer> curr = lists.get(i);
            if(right>=curr.get(1))
                contained[map.get(curr)]=1;
            right=Math.max(right, curr.get(1));
        }
        right=Integer.MAX_VALUE;
        for(int i=n-1;i>=0;i--) {
            List<Integer> curr = lists.get(i);
            if(curr.get(1)>=right)
                contains[map.get(curr)]=1;
            right=Math.min(right, curr.get(1));
        }
        for(int i=0;i<n;i++)
            System.out.print(contains[i]+" ");
        System.out.println();
        for(int i=0;i<n;i++)
            System.out.print(contained[i]+" ");
    }
}
