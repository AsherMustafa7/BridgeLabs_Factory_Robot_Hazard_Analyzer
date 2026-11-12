
package FactoryRobotHazardAnalyzer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactoryRobotHazardAnalyzerTest {

    FactoryRobotHazardAnalyzer analyzer =
            new FactoryRobotHazardAnalyzer();

    @Test
    void shouldCalculateWornMachineryRisk() throws RobotSafetyException {
        double result = analyzer.calculateHazardRisk(0.5, 10, "Worn");

        assertEquals(20.5, result, 0.001);
    }

    @Test
    void shouldCalculateFaultyMachineryRisk() throws RobotSafetyException {
        double result = analyzer.calculateHazardRisk(0.5, 10, "Faulty");

        assertEquals(27.5, result, 0.001);
    }

    @Test
    void shouldCalculateCriticalMachineryRisk() throws RobotSafetyException {
        double result = analyzer.calculateHazardRisk(0.5, 10, "Critical");

        assertEquals(37.5, result, 0.001);
    }

    @Test
    void shouldThrowExceptionForUnsupportedState() {

        RobotSafetyException exception = assertThrows(
                RobotSafetyException.class,
                () -> analyzer.calculateHazardRisk(0.5, 10, "Optimal")
        );

        assertEquals(
                "Error: Unsupported machinery state",
                exception.getMessage()
        );
    }
}
