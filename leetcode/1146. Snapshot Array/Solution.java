// https://leetcode.com/problems/snapshot-array/description/
// t.c.=O(1) for set, O(logS) for get, where S is the number of records in queried index's history
class SnapshotArray {
    private List<int[]>[] history;
    private int snapCount;
    public SnapshotArray(int length) {
        history=new ArrayList[length];
        for(int i=0;i<length;i++) {
            history[i]=new ArrayList<>();
            // Initial value: snap_id=0, value=0
            history[i].add(new int[]{0, 0});
        }
        snapCount=0;
    }
    
    public void set(int index, int val) {
        List<int[]> list=history[index];
        int[] lastRecord=list.get(list.size()-1);
        if(lastRecord[0]==snapCount)  // same snap_id, update the existing value
            lastRecord[1]=val;
        else    // new snap_id, append new record
            list.add(new int[]{snapCount, val});

    }
    
    public int snap() {
        return snapCount++;
    }
    
    public int get(int index, int snap_id) {
        List<int[]> list=history[index];
        // binary search to find largest snap_id <= queried snap_id
        int low=0, high=list.size()-1;
        while(low<high) {
            int mid=low+(high-low+1)/2;
            if(list.get(mid)[0]<=snap_id)
                low=mid;
            else
                high=mid-1;
        }
        return list.get(low)[1];
    }
}

