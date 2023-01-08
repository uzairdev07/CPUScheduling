package schedulingAlgorithms.nonPreemtive;

import components.GanttChart;
import components.ProcessItem;
import components.Table;
import models.Process;
import schedulingAlgorithms.Scheduler;

import java.util.*;

public class SJF implements Scheduler {

    private List<Process> processes;

    public SJF(List<Process> processes) {
        this.processes = processes;
//        processes.sort(new Comparator<Process>() {
//            @Override
//            public int compare(Process o1, Process o2) {
//                if (o1.getArrivalTime() < o2.getArrivalTime()) return -1;
//                if (o1.getArrivalTime() == o2.getArrivalTime()) return 0;
//                return 1;
//            }
//        });
    }

    @Override
    public void schedule() {
        int currTime, completed, prev;
        currTime = completed = prev = 0;

        List<ProcessItem> processItems = new ArrayList<>();

        int n = processes.size();
        int[] isCompleted = new int[n];
        int temp = 0;

        while (completed != n) {
            int index = -1, min = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                Process p = processes.get(i);
                if (p.getArrivalTime() <= currTime && isCompleted[i] == 0) {
                    if (p.getBurstTime() < min) {
                        min = p.getBurstTime();
                        index = i;
                    }
                }

                if (p.getBurstTime() == min) {
                    if (p.getArrivalTime() < processes.get(index).getArrivalTime()) {
                        min = p.getBurstTime();
                        index = i;
                    }
                }
            }

            if (index != -1) {
                if (temp == 0) {
                    processItems.add(
                            new ProcessItem(
                                    "P" + processes.get(index).getID(),
                                    currTime,
                                    processes.get(index).getBurstTime()
                            )
                    );
                } else {
                    int f = processItems.get(temp - 1).getFinish();
                    processItems.add(
                            new ProcessItem(
                                    "P" + processes.get(index).getID(),
                                    f,
                                    f + processes.get(index).getBurstTime()
                            )
                    );
                }
                temp++;
                completed++;
                isCompleted[index] = 1;
                currTime = processes.get(index).getArrivalTime() + processes.get(index).getBurstTime();
                prev = currTime;
            } else {
                currTime++;
            }

        }

        GanttChart ganttChart = new GanttChart(processItems);
        ganttChart.build();

        Table table = new Table(ganttChart, processes);
        table.build();
        table.printDetails();

    }

}
