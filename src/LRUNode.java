public class LRUNode {

    int key;
    int value;
    LRUNode prv;
    LRUNode next;

    public LRUNode(int key, int value){

        this.key = key;
        this.value = value;
        prv = next = null;
    }
}
