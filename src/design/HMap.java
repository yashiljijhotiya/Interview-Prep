package design;

public class HMap {
    private static final int SIZE = 500;
    private static EntryNode map[];

    public HMap(){
        map = new EntryNode[SIZE];
    }

    private static void put(int key, int val){
        int hash = hash(key);
        EntryNode node = new EntryNode(key,val);
        boolean isExist = false;
        if(map[hash] == null){
            map[hash] = node;
        }
        else {
            EntryNode curr = map[hash];
            EntryNode root = curr;
            while (curr != null){
                if(curr.key == key){
                    curr.val = val;
                    isExist = true;
                    break;
                }
                curr = curr.next;
            }
            if(!isExist){
                node.next = root;
                map[hash] = node;
            }
            else {
                map[hash] = root;
            }

        }

    }

    private static int get(int key){
     int hash = hash(key);
     EntryNode node = map[hash];
     if(map[hash] == null){
         return -1;
     }
     while (node != null){
         if(node.key == key){
             return node.val;
         }
         node = node.next;
     }
     return -1;
    }

    private static void remove(int key){
     int hash = hash(key);
     EntryNode curr = map[hash];
     EntryNode root = curr;
     if(curr == null){
         return;
     }
     if(curr.key == key){
         map[hash] = curr.next;
     }
     else{
         while (curr.next != null){
             EntryNode temp = curr.next;
             if(temp != null && temp.key == key){
                 curr.next = temp.next;
                 break;
             }
             curr = curr.next;
         }
         map[hash] = root;
     }
    }

    private static int hash(int key){
        return key % SIZE;
    }

    public static void main(String[] args) {
        put(1,5);
        put(501,4);
        System.out.println(get(1));
    }
}
