// Using bruteforce
// t.c.=O(n^2), s.c.=O(1)
class Solution {
    public int trap(int[] heights) {
        int n=heights.length, rain=0;
        for(int i=1;i<n-1;i++) {
            int lmax=0, rmax=0;
            for(int j=i;j>=0;j--)
                lmax=Math.max(lmax, heights[j]);
            for(int j=i;j<n;j++)
                rmax=Math.max(rmax, heights[j]);
            rain+=Math.min(lmax, rmax)-heights[i];
        }
        return rain;
    }
}

// Using DP
// t.c.=O(n), s.c.=O(n)
class Solution {
    public int trap(int[] heights) {
        int n=heights.length, rain=0;
        int[] left=new int[n], right = new int[n];
        left[0]=heights[0];
        right[n-1]=heights[n-1];
        for(int i=1;i<n;i++)
            left[i]=Math.max(heights[i], left[i-1]);
        for(int i=n-2;i>=0;i--)
            right[i]=Math.max(heights[i], right[i+1]);
        for(int i=1;i<n-1;i++)
            rain+=Math.min(left[i], right[i])-heights[i];
        return rain;
    }
}

// using stack
// t.c.=O(n), s.c.=O(n)
class Solution {
    public int trap(int[] heights) {
        int n=heights.length, rain=0, i=0;
        Stack<Integer> stack = new Stack<>();
        while(i<n) {
            while(!stack.isEmpty() && heights[stack.peek()]<heights[i]) {
                int curr=heights[stack.pop()];
                if(stack.isEmpty())
                    break;
                int height=Math.min(heights[stack.peek()], heights[i])-curr;
                rain+=height*(i-stack.peek()-1);
            }
            stack.add(i++);
        }
        return rain;
    }
}

// Using two pointers
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int trap(int[] heights) {
        int n=heights.length, rain=0, l=0, r=n-1, lMax=0, rMax=0;
        while(l<r) {
            if(heights[l]<heights[r]) {
                if(heights[l]>lMax)
                    lMax=heights[l];
                rain+=lMax-heights[l++];
            }
            else {
                if(heights[r]>rMax)
                    rMax=heights[r];
                rain+=rMax-heights[r--];
            }
        }
        return rain;
    }
}

