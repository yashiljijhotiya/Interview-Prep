package intervals;

import java.util.*;
//TC: O(nlog(n))
public class CPULoad {

    static class Jobs{
        int start;
        int end;
        int load;

        public Jobs(int start, int end, int load){
            this.start =  start;
            this.end = end;
            this.load = load;
        }
    }

    private static int findMaxCPULoad(List<Jobs> jobs){
        if(jobs == null || jobs.size() == 0){
            return 0;
        }
        Comparator<Jobs> comparator = ((o1, o2) -> o1.start - o2.start);
        Collections.sort(jobs,comparator);
        PriorityQueue<Jobs> priorityQueue = new PriorityQueue<>((o1, o2) -> o1.end - o2.end);
        int maxCPULoad = 0, currentCPULoad = 0;
        for(Jobs job : jobs){
            while (!priorityQueue.isEmpty() && priorityQueue.peek().end < job.start){
                currentCPULoad -= priorityQueue.poll().load;
            }
            priorityQueue.offer(job);
            currentCPULoad += job.load;
            maxCPULoad = Math.max(maxCPULoad, currentCPULoad);
        }
        return maxCPULoad;
    }

    public static void main(String[] args) {
        List<Jobs> cpuJobs = new ArrayList<>();
        cpuJobs.add(new Jobs(1,4,3));
        cpuJobs.add(new Jobs(2,5,4));
        cpuJobs.add(new Jobs(7,9,6));
        System.out.println("max cpu  load : " +findMaxCPULoad(cpuJobs));
    }
}
