// using brute-force method
// t.c.=O(n^2), s.c.=O(1)
class Solution {
    public int largestRectangleArea(int[] heights) {
        int rec=0, n=heights.length;
        for(int i=0;i<n;i++){
            int min=Integer.MAX_VALUE;
            for(int j=i;j<n;j++) {
                min=Math.min(min, heights[j]);
                rec=Math.max(rec, min*(j-i+1));
            }
        }
        return rec;
    }
}

// Using devide and conquer
// t.c.=O(nlogn), in worst case O(n^2), s.c.=O(n)
class Solution {
    private int calculateRec(int[] heights, int start, int end) {
        if(start>end)
            return 0;
        int minIdx=start;
        for(int i=start+1;i<=end;i++)
            if(heights[i]<heights[minIdx])
                minIdx=i;
        return Math.max(heights[minIdx]*(end-start+1),
                Math.max(calculateRec(heights, start, minIdx-1), calculateRec(heights, minIdx+1, end)));
    }
    public int largestRectangleArea(int[] heights) {
        return calculateRec(heights, 0, heights.length-1);
    }
}

// using stack
// t.c.=O(n), s.c.=O(n)
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length, sum=0;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        for(int i=0;i<n;i++) {
            while(stack.peek()!=-1 && heights[i]<heights[stack.peek()])
                sum=Math.max(sum, heights[stack.pop()]*(i-stack.peek()-1));
            stack.push(i);
        }
        while(stack.peek()!=-1)
            sum=Math.max(sum, heights[stack.pop()]*(n-stack.peek()-1));
        return sum;
    }
}
