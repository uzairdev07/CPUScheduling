import models.Process;
import schedulingAlgorithms.nonPreemtive.FCFS;
import schedulingAlgorithms.nonPreemtive.SJF;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.printf("Enter # of Process -> ");
        final int N = input.nextInt();

        List<Process> processes = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            System.out.printf("Enter Process ID: ");
            int id = input.nextInt();
            System.out.printf("\tEnter Arrival Time: ");
            int a = input.nextInt();
            System.out.printf("\tEnter Burst Time: ");
            int b = input.nextInt();
            processes.add(
                    new Process(id, a, b)
            );
        }

        System.out.println("1. FCFS");
        System.out.println("1. SJF");
        System.out.printf("Choose Scheduling Algorithm -> ");

        int choice = input.nextInt();
        if (choice == 1) {
            new FCFS(processes).schedule();
        } else if (choice == 2) {
            new SJF(processes).schedule();
        } else {
            new SJF(processes).schedule();
        }

    }
}