package graph;

public class GNode {
    int src;
    int dst;
    boolean isVisited;
    int weight;
    boolean directed;

    GNode(int src, int dst) {
        this.dst = dst;
        this.src = src;
        this.isVisited = false;
    }

    GNode(int src, int dst, int weight) {
        this.dst = dst;
        this.src = src;
        this.isVisited = false;
        this.weight = weight;
    }

    GNode(int src, int dst, int weight, boolean directed) {
        this.dst = dst;
        this.src = src;
        this.isVisited = false;
        this.weight = weight;
        this.directed = true;
    }

    public void visited() {
        isVisited = true;
    }

    public void unVisited() {
        isVisited = false;
    }
}
