package linkedList;

public class MergeSorted {

    private SLLNode insertNode(int data, SLLNode head){
        SLLNode node = new SLLNode(data);
        if(head == null) {
            head = node;
            return head;
        }
        node.next = head;
        head = node;
        return head;

    }

    private void print(SLLNode head){
        SLLNode temp = head;
        if(temp == null)
            return;
        while(temp != null){
            System.out.println("-> " +temp.data);
            temp = temp.next;
        }
    }

    private SLLNode mergeSortedList(SLLNode headOne, SLLNode headTwo){
        SLLNode head  = null;
        SLLNode end = null;

        if(headOne == null){
            return  headTwo;
        }
        if(headTwo == null){
            return headOne;
        }
        while(headOne != null && headTwo != null){
            if(headOne.data < headTwo.data){
                if(head == null){
                    head = headOne;
                    end = headOne;
                    headOne = headOne.next;
                }
                else {
                    end.next = headOne;
                    end = end.next;
                    headOne = headOne.next;
                }
            }

           else {
               if(head == null){
                   head = headTwo;
                   end = headTwo;
                   headTwo = headTwo.next;
               }
               else {
                   end.next = headTwo;
                   end = end.next;
                   headTwo = headTwo.next;
               }
            }
        }

        if(headOne != null){
            end.next = headOne;
        }
        if (headTwo != null){
            end.next = headTwo;
        }

        return head;
    }

    private static SLLNode optimizeMergeList(SLLNode l1, SLLNode l2){
        SLLNode tempHead = new SLLNode(-1);
        SLLNode head = tempHead;
        while(l1 != null && l2 != null){
            if(l1.data < l2.data){
                tempHead.next = l1;
                l1 = l1.next;
            }
            else{
                tempHead.next = l2;
                l2 = l2.next;
            }
            tempHead = tempHead.next;
        }

        if(l1 != null){
            tempHead.next = l1;
        }
        else{
            tempHead.next = l2;
        }

        return head.next;
    }


    public static void main(String[] args) {
        MergeSorted m = new MergeSorted();
        SLLNode headOne = null;
        SLLNode headTwo = null;
        headOne = m.insertNode(71,headOne);
        headOne = m.insertNode(56, headOne);
        headOne = m.insertNode(51, headOne);
        headOne = m.insertNode(17, headOne);

        headTwo = m.insertNode(100,headTwo);
        headTwo = m.insertNode(19, headTwo);
        headTwo = m.insertNode(15, headTwo);
        headTwo = m.insertNode(14, headTwo);
        System.out.println("print first list");
        m.print(headOne);
        System.out.println("print second list");
        m.print(headTwo);

       //SLLNode mergeHead = m.mergeSortedList(headOne,headTwo);
       SLLNode resultHead = optimizeMergeList(headOne,headTwo);
        System.out.println("merge sorted list");
        m.print(resultHead);
    }
}
