// https://leetcode.com/problems/build-a-matrix-with-conditions/description/
// using Kahn's algorithm
// t.c.=O(k+m+n), s.c.=O(k+m+n)
class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[] rowIndegrees=new int[k+1], colIndegrees=new int[k+1];
        List<List<Integer>> rowGraph=new ArrayList<>(), colGraph=new ArrayList<>();
        int[][] resMatrix=new int[k][k];
        Queue<Integer> queue=new LinkedList<>();
        Map<Integer, Integer> valueToRow=new HashMap<>();
        for(int i=0;i<=k;i++) {
            rowGraph.add(new ArrayList<>());
            colGraph.add(new ArrayList<>());
        }
        for(int[] pair:rowConditions) {
            rowIndegrees[pair[1]]++;
            rowGraph.get(pair[0]).add(pair[1]);
        }
        for(int[] pair:colConditions) {
            colIndegrees[pair[1]]++;
            colGraph.get(pair[0]).add(pair[1]);
        }
        // process the rows
        for(int i=1;i<=k;i++)
            if(rowIndegrees[i]==0)
                queue.offer(i);
        int processed=0, rowIdx=0, colIdx=0;
        while(!queue.isEmpty()) {
            int value=queue.poll();
            processed++;
            resMatrix[rowIdx][colIdx]=value;
            valueToRow.put(value, rowIdx++);
            for(int next:rowGraph.get(value)) {
                rowIndegrees[next]--;
                if(rowIndegrees[next]==0)
                    queue.offer(next);
            }
        }
        if(processed!=k)    return new int[0][0];
        // process the cols
        for(int i=1;i<=k;i++)
            if(colIndegrees[i]==0)
                queue.offer(i);
        processed=0;
        while(!queue.isEmpty()) {
            int value=queue.poll();
            processed++;
            rowIdx=valueToRow.get(value);
            resMatrix[rowIdx][0]=0;
            resMatrix[rowIdx][colIdx++]=value;
            for(int next:colGraph.get(value)) {
                colIndegrees[next]--;
                if(colIndegrees[next]==0)
                    queue.offer(next);
            }
        }
        return processed!=k?   new int[0][0]:resMatrix;
    }
}
