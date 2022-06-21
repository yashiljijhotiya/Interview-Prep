package linkedList;

import java.util.TreeSet;

/**
 * Soln Approach : You can prove that: say A length = a + c, B length = b + c, after switching pointer,
 * pointer A will move another b + c steps, pointer B will move a + c more steps,
 * since a + c + b + c = b + c + a + c, it does not matter what value c is.
 * Pointer A and B must meet after a + c + b (b + c + a) steps. If c == 0, they meet at NULL.
 *
 *
 * **/
public class IntersectionLL {

    private static SLLNode findIntersectionNode(SLLNode l1, SLLNode l2){
        if(l1 == null || l2 == null){
            return null;
        }
        SLLNode a = l1, b = l2;
        //if a & b have different len, then we will stop the loop after second iteration
        while(a != b){
            a = a == null ? l2 : a.next;
            b = b == null ? l1 : b.next;
        }
        return a;
    }
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        set.first();
    }
}
