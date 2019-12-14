//Find the first circular tour that visits all petrol pumps
// ref :- gfg
package arrays;

public class TourComplete {

    static  class PetrolPump{
        int cap;
        int dist;
        PetrolPump(int cap, int dist){
            this.cap = cap;
            this.dist = dist;
        }
    }

    private int findTour(PetrolPump arr[], int n ){
        int start =0;
        int end = 1;
        int curVal = arr[start].cap - arr[start].dist;
        while( start != end || curVal < 0){

            while(start != end && start != end ){
                curVal -= arr[start].cap - arr[start].dist;
                start = (start+1)%n;
                if(start == 0)
                    return  -1;
            }
            curVal += arr[end].cap - arr[end].dist;
            end = (end+1)%n;

        }

        return start;
    }


    public static void main(String[] args) {
       TourComplete t = new TourComplete();
       PetrolPump p[] = {new PetrolPump(6, 4),
                         new PetrolPump(3, 6),
                         new PetrolPump(7, 3)};
       int s = t.findTour(p, p.length);
        System.out.println(s == -1 ? "No solution" : "starting point: " + s);
    }
}
