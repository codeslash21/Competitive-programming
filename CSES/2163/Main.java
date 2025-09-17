// https://cses.fi/problemset/task/2163
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt(), root = (int) Math.sqrt(n), count = 0, row=0, col=0;
        List<List<Integer>> arr = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        for(int i=1;i<=n;i++) {
            if(count>=root) {
                arr.add(new ArrayList(curr));
                curr.clear();
                count=0;
            }
            curr.add(i);
            count++;
        }
        if(count>0)
            arr.add(curr);
        for(int i=0;i<n;i++) {
            int idx = k%(n-i);
            while(idx>0) {
                if (col + idx < arr.get(row).size()) {
                    col += idx;
                    idx = 0;
                } else {
                    idx -= arr.get(row).size() - col;
                    col=0;
                    row++;
                }
                if (row >= arr.size())
                    row = 0;
            }
            while(col>=arr.get(row).size()) {
                col=0;
                row++;
                if(row>=arr.size())
                    row=0;
            }
            System.out.print(arr.get(row).get(col)+" ");
            if(i!=n-1) {
                arr.get(row).remove(col);
                while(col>=arr.get(row).size()) {
                    col=0;
                    row++;
                    if(row>=arr.size())
                        row=0;
                }
            }
        }
    }
}
