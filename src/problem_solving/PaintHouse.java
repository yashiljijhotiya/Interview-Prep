package problem_solving;

public class PaintHouse {

    private static int minCostPaintHouse(int cost[][]){
        if(cost.length == 0 || cost == null){
            return 0;
        }
        for(int i = 1; i < cost.length; i++){
            cost[i][0] += Math.min(cost[i-1][1], cost[i-1][2]);
            cost[i][1] += Math.min(cost[i-1][0], cost[i-1][2]);
            cost[i][2] += Math.min(cost[i-1][0], cost[i-1][1]);
        }
        return Math.min(Math.min(cost[cost.length-1][0], cost[cost.length-1][1]), cost[cost.length-1][2]);
    }

    public static void main(String[] args) {
        int cost[][] = {{17,2,17},
                        {16,16,5},
                        {14,3,19}};

        System.out.println("Min cost to paint house is :" + cost) ;
    }
}
