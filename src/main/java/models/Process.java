package models;

public class Process implements Comparable<Process> {
    protected int ID;
    protected int arrivalTime;
    protected int bustTime;

    public Process(int ID, int arrivalTime, int bustTime) {
        this.ID = ID;
        this.arrivalTime = arrivalTime;
        this.bustTime = bustTime;
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

    public int getBustTime() {
        return bustTime;
    }

    public void setBustTime(int bustTime) {
        this.bustTime = bustTime;
    }

    @Override
    public String toString() {
        return "P" + ID +
                ", A.T " + arrivalTime +
                ", B.T " + bustTime + "\n";
    }

    @Override
    public int compareTo(Process other) {
        if (arrivalTime < other.arrivalTime) return -1;
        if (arrivalTime == other.arrivalTime) return 0;
        return 1;
    }
}
