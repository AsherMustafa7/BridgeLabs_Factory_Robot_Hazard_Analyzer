
package FactoryRobotHazardAnalyzer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactoryRobotHazardAnalyzerTest {

    FactoryRobotHazardAnalyzer analyzer =
            new FactoryRobotHazardAnalyzer();

    @Test
    void shouldCalculateHazardRisk() throws RobotSafetyException {

        double result = analyzer.calculateHazardRisk(
                0.5, 10, "Critical"
        );

        assertEquals(37.5, result, 0.001);
    }

    @Test
    void shouldThrowExceptionForInvalidArmPrecision() {

        RobotSafetyException exception = assertThrows(
                RobotSafetyException.class,
                () -> analyzer.calculateHazardRisk(1.5, 10, "Worn")
        );

        assertEquals(
                "Arm precision must be between 0.0 and 1.0",
                exception.getMessage()
        );
    }

    @Test
    void shouldThrowExceptionForInvalidWorkerDensity() {

        RobotSafetyException exception = assertThrows(
                RobotSafetyException.class,
                () -> analyzer.calculateHazardRisk(0.5, 25, "Worn")
        );

        assertEquals(
                "Worker density must be between 1 and 20",
                exception.getMessage()
        );
    }
}
