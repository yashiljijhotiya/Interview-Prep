package linkedList;

public class MultiNode <T> {
    T data;
    MultiNode<T> right;
    MultiNode<T> down;

    MultiNode(T data){
        this.data = data;
        right = down = null;
    }

    MultiNode(){}

}
