// Using stack and hashmap
// t.c.=O(m+n), s.c.=O(n)
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1=nums1.length, n2=nums2.length, max=-1;
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n2;i++){
            while(!stack.isEmpty() && stack.peek()<nums2[i]) {
                map.put(stack.peek(), nums2[i]);
                stack.pop();
            }
            stack.push(nums2[i]);
        }
        while(!stack.isEmpty()) 
            map.put(stack.pop(), -1);
        int[] res = new int[n1];
        for(int i=0;i<n1;i++)
            res[i]=map.get(nums1[i]);
        return res;
    }
}
