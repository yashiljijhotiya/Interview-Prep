package problem_solving;
//Leetcode
public class GasStation {

    private static int canCompleteTour(int gas[], int cost[]){
        int start = 0, deficiency = 0, surplus = 0;

        if(gas.length < cost.length || gas == null || cost == null){
            return -1;
        }
        for(int i = 0; i < gas.length; i++){
            surplus +=  gas[i] - cost[i];
            if(surplus < 0){
                start = i+1;
                deficiency += surplus;
                surplus = 0;
            }
        }

        return deficiency + surplus >= 0 ? start : -1;
    }

    public static void main(String[] args) {
        int gas[] = {1,2,3,4,5};
        int cost[] = {3,4,5,1,2};
        int res = canCompleteTour(gas,cost);
        if(res == -1){
            System.out.println("not possible to complete tour");
        }
        else {
            System.out.println("tour can be completed from starting gas station is :" + res);
        }

    }
}
