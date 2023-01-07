package components;

import pl.mjaron.etudes.Obj;

import java.util.List;

public class GanttChart {

    private List<ProcessItem> processItemList;

    public GanttChart(List<ProcessItem> processItemList) {
        this.processItemList = processItemList;
    }

    public void build() {
        System.out.println("===========================");
        System.out.printf("%5s\n", "Gantt Chart");
        System.out.println("===========================");
        System.out.println(Obj.asTable(processItemList, ProcessItem.class));
    }

    public List<ProcessItem> getProcessItemList() {
        return processItemList;
    }

    public void setProcessItemList(List<ProcessItem> processItemList) {
        this.processItemList = processItemList;
    }
}
