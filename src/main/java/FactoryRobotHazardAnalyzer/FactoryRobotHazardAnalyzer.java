
package FactoryRobotHazardAnalyzer;

import java.util.Scanner;

public class FactoryRobotHazardAnalyzer {

    public double calculateHazardRisk(double armPrecision,
                                     int workerDensity,
                                     String machineryState) {

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

        // Validate arm precision
        if (armPrecision < 0.0 || armPrecision > 1.0) {
            System.out.println("Error: Arm precision must be 0.0-1.0");
        }

        // Validate worker density
        else if (workerDensity < 1 || workerDensity > 20) {
            System.out.println("Error: Worker density must be 1-20");
        }

        // Calculate only if numeric inputs are valid
        else {
            FactoryRobotHazardAnalyzer analyzer =
                    new FactoryRobotHazardAnalyzer();

            double risk = analyzer.calculateHazardRisk(
                    armPrecision, workerDensity, machineryState
            );

            System.out.println("Robot Hazard Risk Score: " + risk);
        }

        sc.close();
    }
}
