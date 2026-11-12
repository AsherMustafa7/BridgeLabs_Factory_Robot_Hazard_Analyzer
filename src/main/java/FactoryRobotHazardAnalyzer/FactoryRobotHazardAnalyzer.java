
package FactoryRobotHazardAnalyzer;

import java.util.Scanner;

public class FactoryRobotHazardAnalyzer {

    public double calculateHazardRisk(double armPrecision,
                                     int workerDensity,
                                     String machineryState)
                                     throws RobotSafetyException {

        if (armPrecision < 0.0 || armPrecision > 1.0) {
            throw new RobotSafetyException(
                    "Arm precision must be between 0.0 and 1.0"
            );
        }

        if (workerDensity < 1 || workerDensity > 20) {
            throw new RobotSafetyException(
                    "Worker density must be between 1 and 20"
            );
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

        try {
            double risk = analyzer.calculateHazardRisk(
                    armPrecision, workerDensity, machineryState
            );

            System.out.println("Robot Hazard Risk Score: " + risk);

        } catch (RobotSafetyException e) {
            System.out.println("Safety Error: " + e.getMessage());
        }

        sc.close();
    }
}
