package schedulingAlgorithms.nonPreemtive;

import components.GanttChart;
import components.ProcessItem;
import components.Table;
import models.Process;
import schedulingAlgorithms.Scheduler;

import java.util.*;

public class FCFS implements Scheduler {

    private List<Process> processes;

    public FCFS(List<Process> processes) {
        this.processes = processes;
        processes.sort(new Comparator<Process>() {
            @Override
            public int compare(Process o1, Process o2) {
                if (o1.getArrivalTime() < o2.getArrivalTime()) return -1;
                if (o1.getArrivalTime() == o2.getArrivalTime()) return 0;
                return 1;
            }
        });
    }

    @Override
    public void schedule() {
        List<ProcessItem> processItems = new ArrayList<>();

        for (int i = 0; i < processes.size(); i++) {
            Process process = processes.get(i);
            if (i == 0) {
                processItems.add(
                        new ProcessItem(
                                "P" + process.getID(),
                                process.getArrivalTime(),
                                process.getBurstTime()
                        )
                );
            } else {
                int f = processItems.get(i - 1).getFinish();
                processItems.add(
                        new ProcessItem(
                                "P" + process.getID(),
                                f,
                                f + process.getBurstTime()
                        )
                );
            }
        }

        GanttChart ganttChart = new GanttChart(processItems);
        ganttChart.build();

        Table table = new Table(ganttChart, processes);
        table.build();
        table.printDetails();


    }
}
