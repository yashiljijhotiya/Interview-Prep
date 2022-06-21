package linkedList;

public class AddList {

    private static SLLNode result = null, last = null;

    private static SLLNode addList(SLLNode node1, SLLNode node2){
        if(node1 == null){
            return node2;
        }
        if(node2 == null){
            return node1;
        }
        SLLNode dummy = new SLLNode(-1);
        SLLNode l1 = node1, l2 = node2, curr = dummy;
        int carry = 0;
        while(l1 != null || l2 != null){
            int x = (l1 != null) ? l1.data : 0;
            int y = (l2 != null) ? l2.data : 0;
            int sum = x + y + carry;
            carry = sum/10;
            curr.next = new SLLNode(sum % 10);
            curr = curr.next;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }

        if(carry > 0){
            curr.next = new SLLNode(carry);
        }

         return dummy.next;
    }

    private static SLLNode addInteger(SLLNode l1, SLLNode l2){
        if(l1 == null && l2 == null){
            return l1;
        }
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        int carry = 0;
        while (l1 != null && l2 != null){
            int first = l1 == null? 0 : l1.data;
            int second = l2 == null ? 0 : l2.data;
            int sum = first+second+carry;
            SLLNode newNode = new SLLNode(sum%10);
            carry = sum/10;
            if(result == null){
                result = newNode;
            }
            else {
                last.next = newNode;
            }
            last = newNode;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        return result;
    }

    private static SLLNode addTwoNum(SLLNode l1, SLLNode l2){
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        l1 = ListUtil.reverse(l1);
        l2 = ListUtil.reverse(l2);
        int l1Size = ListUtil.getSize(l1);
        int l2Size = ListUtil.getSize(l2);
        if(l2Size > l1Size){
            SLLNode temp = l1;
            l1 = l2;
            l2 = temp;
        }
        SLLNode main = l1, prev = null;
        int carry = 0;
        while (l1 != null){
            if(l2 != null){
                l1.data += l2.data;
                l2 = l2.next;
            }
            l1.data += carry;
            carry = l1.data/10;
            l1.data = l1.data%10;
            prev = l1;
            l1 = l1.next;
        }

        while(carry > 0){
            prev.next = new SLLNode(carry);
            prev = prev.next;
            carry = prev.data/10;
            prev.data = prev.data%10;
        }
        return ListUtil.reverse(main);
    }


    public static void main(String[] args) {
        SLLNode node1 = ListUtil.insert(3,null);
        node1 = ListUtil.insert(4,node1);
        node1 = ListUtil.insert(2, node1);
        //2 -> 4 -> 3
        SLLNode node2 = ListUtil.insert(4, null);
        node2 = ListUtil.insert(6, node2);
        node2 = ListUtil.insert(5, node2);
        //5 -> 6 -> 4
        SLLNode result = addTwoNum(node1,node2);
        ListUtil.printList(result);

    }


}
