import java.util.Arrays;

public class JobSequencingProblem {
    public int[] JobScheduling(int[][] Jobs) {
        //your code goes here

        Arrays.sort(Jobs,(o1, o2) ->o2[2]-o1[2] );
        int maxDeadline=0;
        for (int i = 0; i <Jobs.length ; i++) {
            maxDeadline=   Math.max(maxDeadline,Jobs[i][1]);
        }
        int[] Deadline=new int[maxDeadline+1];
        int maxProfitCount=0, jobCount=0;

        for (int i = 0; i < Jobs.length ; i++) {
            int index=Jobs[i][1];
            while(index>0) {
                if (Deadline[index] == 0) {
                    Deadline[index] = -1;
                    maxProfitCount +=Jobs[i][2];
                    jobCount += 1;
                    break;
                }
                else index--;
            }
        }
        return new int[]{jobCount,maxProfitCount};
    }
}

class JobSequencingProblemMain {
    public static void main(String[] args) {
        JobSequencingProblem jp = new JobSequencingProblem();
        //jobId,deadline,profit
        int[][] job = {{1, 1, 100}
                , {2, 2, 200}
                , {3, 3, 300}
                , {4, 4, 400}};
        jp.JobScheduling(job);
    }
}