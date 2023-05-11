// Using arraylist
class MedianFinder {
    List<Integer> list;
    int n=0;
    public MedianFinder() {
        list = new ArrayList<Integer>();
    }
    private int findIdx(int val) {
        int l=0, r=n-1;
        while(l<r) {
            int mid=(l+r)/2;
            if(list.get(mid)>val)
                r=mid;
            else
                l=mid+1;
        }
        return l;
    }
    public void addNum(int num) {
        if(n==0 || num>list.get(n-1))
            list.add(num);
        else if(num<list.get(0))
            list.add(0, num);
        else {
            int idx = findIdx(num);
            list.add(idx, num);
        }
        n++;
    }
    
    public double findMedian() {
        if(n%2==1) 
            return list.get((int)n/2);
        else {
            return (double)(list.get(n/2-1)+list.get(n/2))/2;
        }
    }
}
