// Using custom comparator
// t.c.=O(nlogn + klogk), s.c.=O(n)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> sorted = new ArrayList<>();
        for(int num:arr)
            sorted.add(num);
        Collections.sort(sorted, (a,b)->Math.abs(a-x)-Math.abs(b-x));
        sorted=sorted.subList(0,k);
        Collections.sort(sorted);
        return sorted;
    }
}
