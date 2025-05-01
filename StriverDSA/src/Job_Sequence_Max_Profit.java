import java.util.*;

class Job {
    int index;
    int deadline;
    int profit;

    public Job(int index, int deadline, int profit) {
        this.index = index;
        this.deadline = deadline;
        this.profit = profit;
    }
}

class Job_Sequence_Max_Profit {

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        // code here
        // new array of pairs, sort by profit in descending order of profit

        List<Job> jobs = new ArrayList<>();

        for (int i=0;i<deadline.length;i++) {
            Job job = new Job(i,deadline[i],profit[i]);
            jobs.add(job);
        }

        // sort on the basis of profit in descending order

        jobs.sort((a,b) -> b.profit - a.profit);

        // create new array if size maxDeadline, to cover all possible max deadlines

        int maxDeadline = 0;

        for (int i=0;i<deadline.length;i++) {
            if (maxDeadline < deadline[i]) {
                maxDeadline = deadline[i];
            }
        }

        int[] slots = new int[maxDeadline+1]; // 1-based indexing

        Arrays.fill(slots,-1);

        int count = 0;
        int maxProfit = 0;

        for (Job job: jobs) {
            // for each job, find if suitable empty slot exists before its deadline
            for (int j=job.deadline;j>0;j--) {
                if (slots[j] == -1) {
                    slots[j] = 1;
                    count++;
                    maxProfit+=job.profit;
                    break;
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(count);
        result.add(maxProfit);

        return result;
    }

    /**
     * Input: deadline[] = [4, 1, 1, 1], profit[] = [20, 10, 40, 30]
     * Output: [2, 60]
     * Explanation: Job1 and Job3 can be done with maximum profit of 60 (20+40).
     * @param args
     */

    public static void main(String args[]) {
        int[] deadline = {4,1,1,1};
        int[] profit = {20,10,40,30};

        Job_Sequence_Max_Profit jobSequenceMaxProfit = new Job_Sequence_Max_Profit();

        System.out.println("Max jobs, Max Profit: " + jobSequenceMaxProfit.jobSequencing(deadline, profit));
    }
}