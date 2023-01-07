package schedulingAlgorithms.nonPreemtive;

import components.GanttChart;
import components.ProcessItem;
import models.Process;
import schedulingAlgorithms.Scheduler;

import java.util.*;

public class FCFS implements Scheduler {

    private List<Process> processes;

    public FCFS(List<Process> processes) {
        this.processes = processes;
        Collections.sort(processes);
    }

    @Override
    public void schedule() {
        Queue<Process> processQueue = new ArrayDeque<>();
        List<ProcessItem> processItems = new ArrayList<>();

        for (int i = 0; i < processes.size(); i++) {
            Process process = processes.get(i);
            processQueue.add(process);
            if (i == 0) {
                processItems.add(
                        new ProcessItem(
                                "P" + process.getID(),
                                process.getArrivalTime(),
                                process.getBustTime()
                        )
                );
            } else {
                int f = processItems.get(i - 1).getFinish();
                processItems.add(
                        new ProcessItem(
                                "P" + process.getID(),
                                f,
                                f + process.getBustTime()
                        )
                );
            }
        }

        new GanttChart(processItems).build();

    }
}
