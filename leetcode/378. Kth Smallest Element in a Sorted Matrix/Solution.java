// Using minheap
// t.c.=O(x + klogx), s.c.=O(x), where x is min(n,k)
class MyHeapNode {
    int row, col, value;
    public MyHeapNode(int r, int c, int v) {
        row=r;
        col=c;
        value=v;
    }
}
class MyHeapComparator implements Comparator<MyHeapNode> {
    public int compare(MyHeapNode x, MyHeapNode y) {
        return x.value-y.value;
    }
}
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n=matrix.length;
        PriorityQueue<MyHeapNode> minHeap = new PriorityQueue<MyHeapNode>(Math.min(n,k), new MyHeapComparator());
        for(int r=0;r<Math.min(n,k);r++)
            minHeap.offer(new MyHeapNode(r, 0, matrix[r][0]));
        MyHeapNode element = minHeap.peek();
        while(k-->0) {
            element = minHeap.poll();
            int r = element.row, c = element.col;
            if(c<n-1)
                minHeap.offer(new MyHeapNode(r, c+1, matrix[r][c+1]));
        }
        return element.value;
    }
}

// Using binary search
// t.c.=O(n*log(max-min)), s.c.=O(1)
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n=matrix.length;
        int start=matrix[0][0], end=matrix[n-1][n-1];
        while(start<end) {
            int mid=start+(end-start)/2;
            int[] smallLargePair = {matrix[0][0], matrix[n-1][n-1]};
            int count = countLessEqual(matrix, mid, smallLargePair);
            if(count==k)
                return smallLargePair[0];
            if(count>k)
                end=smallLargePair[0];
            else
                start=smallLargePair[1];
        }
        return start;
    }
    public int countLessEqual(int[][]matrix, int mid, int[] pair) {
        int n = matrix.length;
        int row=n-1, col=0, count=0;
        while(row>=0 && col<n) {
            if(matrix[row][col]>mid) {
                pair[1]=Math.min(pair[1], matrix[row][col]);
                row--;
            }
            else {
                count+=(row+1);
                pair[0]=Math.max(pair[0], matrix[row][col]);
                col++;
            }
        }
        return count;
    }
}
