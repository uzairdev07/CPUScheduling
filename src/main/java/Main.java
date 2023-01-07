import models.Process;
import schedulingAlgorithms.nonPreemtive.FCFS;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final int N = 4;
        List<Process> processes = new ArrayList<>();
        int[] aTime = {1, 2, 0, 3}, bTime = {4, 2, 8, 3};
        for (int i = 0; i < N; i++)
            processes.add(
                    new Process(i+1, aTime[i], bTime[i])
            );

        new FCFS(processes).schedule();
    }
}