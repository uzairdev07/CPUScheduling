package models;

public class PriorityProcess extends Process {
    private int priority;
    public PriorityProcess(int ID, int arrivalTime, int bustTime, int priority) {
        super(ID, arrivalTime, bustTime);
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
