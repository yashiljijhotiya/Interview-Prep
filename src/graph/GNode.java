package graph;

public class GNode {
    int src;
    int dst;
    boolean isVisited;
    GNode(int src, int dst ){
        this.dst = dst;
        this.src = src;
        this.isVisited = false;
    }

    public void visited(){
        isVisited = true;
    }

   public void  unVisited(){
        isVisited = false;
    }
}
