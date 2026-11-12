
package FactoryRobotHazardAnalyzer;

import java.util.Scanner;

public class FactoryRobotHazardAnalyzer {

    // Maps machinery state to its risk factor
    private double getMachineRiskFactor(String machineryState)
            throws RobotSafetyException {

        switch (machineryState) {
            case "Worn":
                return 1.3;

            case "Faulty":
                return 2.0;

            case "Critical":
                return 3.0;

            default:
                throw new RobotSafetyException(
                        "Error: Unsupported machinery state"
                );
        }
    }

    public double calculateHazardRisk(double armPrecision,
                                      int workerDensity,
                                      String machineryState)
            throws RobotSafetyException {

        if (armPrecision < 0.0 || armPrecision > 1.0) {
            throw new RobotSafetyException(
                    "Error: Arm precision must be 0.0-1.0"
            );
        }

        if (workerDensity < 1 || workerDensity > 20) {
            throw new RobotSafetyException(
                    "Error: Worker density must be 1-20"
            );
        }

        double machineRiskFactor =
                getMachineRiskFactor(machineryState);

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
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}
