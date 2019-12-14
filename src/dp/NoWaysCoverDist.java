package dp;
// Count number of ways to cover a distance by using step 1,2,3 .
// ref:- gfg

public class NoWaysCoverDist {

    private int  noOfWaysToCoverDist(int dist){
        int count [] = new int[dist+1];

        count[0] = 1;
        count[1] = 1;
        count[2] = 2;
        for(int i = 3; i <= dist; i++){
            count[i] = count[i-1]+count[i-2]+count[i-3];
        }
        return count[dist];


    }

    public static void main(String[] args) {
     NoWaysCoverDist n = new NoWaysCoverDist();
        System.out.println("no. ways to cover dist: 4 is : "+ n.noOfWaysToCoverDist(4));
    }
}
