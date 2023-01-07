package components;

import java.util.List;

public class GanttChart {

    private List<ProcessItem> processItemList;
    private final int N = 10;

    public GanttChart(List<ProcessItem> processItemList) {
        this.processItemList = processItemList;
    }

    public void build() {
        printLine();

        int i = 0;
        for (var item : processItemList) {
            if (i++ == 0)
                System.out.printf("|%s %7s", item.getName(), "|");
            else
                System.out.printf("%s %7s", item.getName(), "|");
        }
        System.out.println();

        i = 0;
        for (var item : processItemList) {
            System.out.printf("%d %7s", item.getStart(), "");
            if (i == processItemList.size() - 1) {
                System.out.printf("%d %7s", item.getFinish(), "");
            }
            i++;
        }

        System.out.println();

        printLine();
    }

    private String repeat(char DELIMINATOR) {
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < N; i++)
            temp.append(DELIMINATOR);
        return temp.toString();
    }

    private void printLine() {
        for (int i = 0; i < processItemList.size(); i++)
            System.out.print(repeat('='));
        System.out.println();
    }

}
