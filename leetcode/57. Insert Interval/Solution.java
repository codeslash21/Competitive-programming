// Usinng linear search
// t.c.=O(n), s.c.=O(1)
class Solution {
    public boolean doesOverlap(int[] a, int[] b) {
        return Math.min(a[1], b[1])-Math.max(a[0], b[0])>=0;
    }
    public int[] mergeInterval(int[] a, int[] b) {
        return new int[]{Math.min(a[0],b[0]), Math.max(a[1],b[1])};
    }
    public int[][] insertInterval(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>(Arrays.asList(intervals));
        boolean isInserted = false;
        for(int i=0;i<intervals.length;i++)
            if(newInterval[0]<intervals[i][0]) {
                list.add(i, newInterval);
                isInserted=true;
                break;
            }
        if(!isInserted)
            list.add(newInterval);
        return list.toArray(new int[list.size()][2]);
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        intervals = insertInterval(intervals, newInterval);
        int n=intervals.length;
        List<int[]> answer = new ArrayList<>();
        for(int i=0;i<n;i++) {
            int[] currInterval = intervals[i];
            while(i<n && doesOverlap(currInterval, intervals[i])) {
                currInterval = mergeInterval(currInterval, intervals[i]);
                i++;
            }
            answer.add(currInterval);
            i--;
        }
        return answer.toArray(new int[answer.size()][2]);
    }
}

// Using binary search to find position
// t.c.=O(n), s.c.=O(1)
class Solution {
    public boolean doesOverlap(int[] a, int[] b) {
        return Math.min(a[1], b[1])-Math.max(a[0], b[0])>=0;
    }
    public int[] mergeInterval(int[] a, int[] b) {
        return new int[]{Math.min(a[0],b[0]), Math.max(a[1],b[1])};
    }
    public int upperBound(int[][] intervals, int[] interval) {
        int n = intervals.length;
        int ans = n, start=0, end=n-1;
        while(start<=end) {
            int mid=(start+end)/2;
            if(intervals[mid][0]>interval[0]) {
                ans=mid;
                end=mid-1;
            }
            else 
                start=mid+1;
        }
        return ans;
    }
    public int[][] insertInterval(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>(Arrays.asList(intervals));
        int index = upperBound(intervals, newInterval);
        if(index!=intervals.length)
            list.add(index, newInterval);
        else
            list.add(newInterval);
        return list.toArray(new int[list.size()][2]);
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        intervals = insertInterval(intervals, newInterval);
        int n=intervals.length;
        List<int[]> answer = new ArrayList<>();
        for(int i=0;i<n;i++) {
            int[] currInterval = intervals[i];
            while(i<n && doesOverlap(currInterval, intervals[i])) {
                currInterval = mergeInterval(currInterval, intervals[i]);
                i++;
            }
            answer.add(currInterval);
            i--;
        }
        return answer.toArray(new int[answer.size()][2]);
    }
}
