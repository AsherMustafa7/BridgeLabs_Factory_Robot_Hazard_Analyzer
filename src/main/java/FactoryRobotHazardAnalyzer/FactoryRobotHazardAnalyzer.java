
package FactoryRobotHazardAnalyzer;

import java.util.Scanner;

public class FactoryRobotHazardAnalyzer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Factory Robot Hazard Analyzer");

        System.out.print("Enter Arm Precision: ");
        double armPrecision = sc.nextDouble();

        System.out.print("Enter Worker Density: ");
        int workerDensity = sc.nextInt();

        System.out.print("Enter Machinery State: ");
        String machineryState = sc.next();

        System.out.println("\nEntered Details:");
        System.out.println("Arm Precision: " + armPrecision);
        System.out.println("Worker Density: " + workerDensity);
        System.out.println("Machinery State: " + machineryState);
    }
}
