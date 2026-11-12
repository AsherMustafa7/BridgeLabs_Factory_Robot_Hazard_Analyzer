
package FactoryRobotHazardAnalyzer;

import java.util.Scanner;

public class FactoryRobotHazardAnalyzer {

    // Validates inputs and calculates the hazard risk
    public double calculateHazardRisk(double armPrecision,
                                     int workerDensity,
                                     String machineryState) {

        if (armPrecision < 0.0 || armPrecision > 1.0) {
            System.out.println("Error: Arm precision must be 0.0-1.0");
            return -1;
        }

        if (workerDensity < 1 || workerDensity > 20) {
            System.out.println("Error: Worker density must be 1-20");
            return -1;
        }

        double machineRiskFactor;

        if (machineryState.equals("Worn")) {
            machineRiskFactor = 1.3;
        } else if (machineryState.equals("Faulty")) {
            machineRiskFactor = 2.0;
        } else {
            machineRiskFactor = 3.0;
        }

        return ((1.0 - armPrecision) * 15.0)
                + (workerDensity * machineRiskFactor);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Arm Precision (0.0 - 1.0): ");
        double armPrecision = sc.nextDouble();

        System.out.print("Enter Worker Density (1 - 20): ");
        int workerDensity = sc.nextInt();

        System.out.print("Enter Machinery State (Worn/Faulty/Critical): ");
        String machineryState = sc.next();

        FactoryRobotHazardAnalyzer analyzer =
                new FactoryRobotHazardAnalyzer();

        // main() only calls the method and displays the result
        double risk = analyzer.calculateHazardRisk(
                armPrecision, workerDensity, machineryState
        );

        if (risk != -1) {
            System.out.println("Robot Hazard Risk Score: " + risk);
        }

        sc.close();
    }
}
