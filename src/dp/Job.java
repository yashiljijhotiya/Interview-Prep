package dp;

public class Job {
    int startTime;
    int endTime;
    int profit;

   public  Job(int startTime, int endTime, int profit){
        this.startTime = startTime;
        this.endTime = endTime;
        this.profit = profit;
    }


    @Override
    public String toString() {
        return "startTime : " + startTime + "\t" + "endTime : " + endTime + "\t" + "profit :" + profit ;
    }
}
