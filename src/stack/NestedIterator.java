package stack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Leetcode: 341
 * Approach:-
 * For every value there is 2 possibilities
 * -> First the val could be integer.
 * -> Second the val could be list.
 */
public class NestedIterator implements Iterator<Integer> {

    List<Integer> flattenList = null;
    int current = 0;

    public NestedIterator(List<NestedInteger> nestedList) {
        flattenList = new ArrayList<>();
        for (NestedInteger integer : nestedList) {
            flattenUtil(integer);
        }

    }


    //TC: O(1)
    @Override
    public boolean hasNext() {
        return current < flattenList.size();
    }

    //TC: O(1)
    @Override
    public Integer next() {
        return flattenList.get(current++);
    }

    void flattenUtil(NestedInteger val) {
        if (val.isInteger()) {
            flattenList.add(val.getInteger());
        } else {
            for (NestedInteger integer : val.getList()) {
                flattenUtil(integer);
            }
        }
    }

    public static void main(String[] args) {

    }
}

interface NestedInteger {
    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    List<NestedInteger> getList();

}
