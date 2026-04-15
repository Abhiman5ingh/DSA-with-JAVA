package GreedyAlgo;
import java.util.*;

public class JobSequnecing {
    static class Jobs{
        int id;
        int deadline;
        int profit;

        public Jobs(int id, int deadline, int profit){
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;   
        }
    }
    public static void main(String args[]){
        int jobsInfo[][] = {{4, 20},{1, 10},{1, 40},{1, 30}};

        ArrayList<Jobs> jobs = new ArrayList<>();

        for(int i=0; i< jobsInfo.length; i++){
            jobs.add(new Jobs(i, jobsInfo[i][0], jobsInfo[i][1]));
        }

        Collections.sort(jobs, (a, b)-> b.profit - a.profit);

        ArrayList<Integer> result = new ArrayList<>();
        int time = 0;

        for(int i=0; i< jobs.size(); i++){
            Jobs curr = jobs.get(i);
            if(curr.deadline > time){
                result.add(curr.id);
                time++;
            }
        }
        System.out.println("The jobs selected are: " + result);
    }
}
