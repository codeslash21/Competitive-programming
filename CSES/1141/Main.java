// https://cses.fi/problemset/task/1141/
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt(), left=0, right=0, res=0;
        Map<Integer, Integer> songIdx=new HashMap<>();
        for(right=1;right<=n;right++) {
            int song=sc.nextInt();
            if(songIdx.containsKey(song) && songIdx.get(song)>left)
                left=songIdx.get(song);
            songIdx.put(song, right);
            res=Math.max(res, right-left);
        }
        System.out.println(res);
    }
}
