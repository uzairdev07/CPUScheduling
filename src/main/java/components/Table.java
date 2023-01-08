package components;

import models.Process;
import pl.mjaron.etudes.Obj;

import java.util.ArrayList;
import java.util.List;

public class Table {

    private GanttChart ganttChart;
    private List<Process> processes;

    private double averageTurnAroundTime, averageWaitingTime;

    public Table(GanttChart ganttChart, List<Process> processes) {
        this.ganttChart = ganttChart;
        this.processes = processes;
    }

    public void build() {
        List<SchedulingTable> schedulingTableList = new ArrayList<>();
        List<ProcessItem> temp = ganttChart.getProcessItemList();

        for (int i = 0; i < temp.size(); i++) {
            ProcessItem item = temp.get(i);
            String id = item.getName().substring(item.getName().length() - 1);
            Process process = findProcess(Integer.parseInt(id));
            schedulingTableList.add(
                    new SchedulingTable(
                            "P" + process.getID(),
                            process.getArrivalTime(),
                            process.getBurstTime(),
                            item.getStart(),
                            item.getFinish(),
                            item.getFinish() - process.getArrivalTime(),
                            (item.getFinish() - process.getArrivalTime()) - process.getBurstTime()
                    )
            );
            averageTurnAroundTime += schedulingTableList.get(i).getTurnAroundTime();
            averageWaitingTime += schedulingTableList.get(i).getWaitingTime();
        }

        System.out.println("===========================");
        System.out.printf("%5s\n", "Scheduling Table");
        System.out.println("===========================");

        System.out.println(Obj.asTable(schedulingTableList, SchedulingTable.class));
    }

    private Process findProcess(int ID) {
        for (int i = 0; i < processes.size(); i++) {
            if (processes.get(i).getID() == ID)
                return processes.get(i);
        }
        return new Process();
    }

    public void printDetails() {
        System.out.printf("Average Turn Around Time = %.1f\n", averageTurnAroundTime / processes.size());
        System.out.printf("Average Waiting Time = %.1f", averageWaitingTime / processes.size());
    }

}
