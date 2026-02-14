// https://leetcode.com/problems/flatten-nested-list-iterator/description/
// N=total number of integers, D=maximum nesting depth, L=total number of lists within the nested list.

// using recursion
// t.c.=O(N+L), s.c.=O(N+D)
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
import java.util.NoSuchElementException;

public class NestedIterator implements Iterator<Integer> {
    private List<Integer> integers = new ArrayList<Integer>();
    private int position=0;
    public NestedIterator(List<NestedInteger> nestedList) {
        flattenList(nestedList);
    }
    private void flattenList(List<NestedInteger> nestedList) {
        for(NestedInteger nestedInteger:nestedList)
            if(nestedInteger.isInteger())
                integers.add(nestedInteger.getInteger());
            else
                flattenList(nestedInteger.getList());
    } 
    @Override
    public Integer next() {
        if(!hasNext())
            throw new NoSuchElementException();
        return integers.get(position++);
    }
    @Override
    public boolean hasNext() {
        return position<integers.size();
    }
}

// using stack of ListIterator
// t.c.=O(N/L), s.c.=O(D)
import java.util.NoSuchElementException;

public class NestedIterator implements Iterator<Integer> {
    private Deque<ListIterator<NestedInteger>> stackOfIterators=new ArrayDeque<>();
    private Integer peeked=null;
    public NestedIterator(List<NestedInteger> nestedList) {
        stackOfIterators.addFirst(nestedList.listIterator());
    }

    @Override
    public Integer next() {
        if(!hasNext())
            throw new NoSuchElementException();
        Integer result=peeked;
        peeked=null;
        return result;
    }

    private void setPeeked() {
        if(peeked!=null)
            return;
        while(!stackOfIterators.isEmpty()) {
            if(!stackOfIterators.peekFirst().hasNext()) {
                stackOfIterators.pollFirst();
                continue;
            }
            NestedInteger next=stackOfIterators.peekFirst().next();
            if(next.isInteger()) {
                peeked=next.getInteger();
                return;
            }
            stackOfIterators.addFirst(next.getList().listIterator());
        }
    }

    @Override
    public boolean hasNext() {
        setPeeked();
        return peeked!=null;
    }
}
