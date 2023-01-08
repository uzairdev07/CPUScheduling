package models;

public class Process {
    protected int ID;
    protected int arrivalTime;
    protected int burstTime;

    public Process() {}

    public Process(int ID, int arrivalTime, int bustTime) {
        this.ID = ID;
        this.arrivalTime = arrivalTime;
        this.burstTime = bustTime;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }

    @Override
    public String toString() {
        return "P" + ID +
                ", A.T " + arrivalTime +
                ", B.T " + burstTime + "\n";
    }

}
