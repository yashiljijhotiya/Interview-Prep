package linkedList;

public class SwapNodes {
    private static void swapNodes(SLLNode head, int x, int y){
        if(x == y){
            return;
        }
        SLLNode prevX = null, currX = head;

        while(currX != null && currX.data != x){
            prevX = currX;
            currX = currX.next;
        }

        SLLNode prevY = null, currY = head;

        while (currY != null && currY.data != y){
            prevY = currY;
            prevY = prevY.next;
        }

        if(currX == null || currY == null){
            return;
        }

        if(prevX != null){
            prevX.next = currY;
        }
        else {
            head = currY;
        }

        if(prevY != null){
            prevY.next = currX;
        }
        else {
            head = currX;
        }
        SLLNode temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
    }

    private static void swapOptimize(SLLNode head, int x, int y){
        if(x == y){
            return;
        }
        SLLNode temp = head, prevX = null, prevY = null;

        while (temp.next != null){
            if(temp.next.data ==  x){
                prevX = temp;
            }
            else if(temp.next.data == y){
                prevY = temp;
            }
            else if(prevX != null && prevY != null){
                break;
            }
            temp = temp.next;
        }

        if(prevX != null && prevY != null){
            SLLNode temp1 = prevX.next;
            prevX.next = prevY.next;
            prevY.next = temp1;
            temp1 = prevX.next.next;
            prevX.next.next = prevY.next.next;
            prevY.next.next = temp1;
        }
        //10->15->12->13->20->14,  x = 12, y = 20
        //    x   t1   y
    }


    public static void main(String[] args) {

    }
}
