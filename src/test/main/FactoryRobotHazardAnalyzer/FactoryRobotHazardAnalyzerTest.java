
package FactoryRobotHazardAnalyzer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FactoryRobotHazardAnalyzerTest {

    @Test
    void shouldCalculateCriticalMachineryRisk() {

        FactoryRobotHazardAnalyzer analyzer =
                new FactoryRobotHazardAnalyzer();

        double result = analyzer.calculateHazardRisk(0.5, 10, "Critical");

        assertEquals(37.5, result, 0.001);
    }

    @Test
    void shouldCalculateWornMachineryRisk() {

        FactoryRobotHazardAnalyzer analyzer =
                new FactoryRobotHazardAnalyzer();

        double result = analyzer.calculateHazardRisk(0.5, 10, "Worn");

        assertEquals(20.5, result, 0.001);
    }

    @Test
    void shouldCalculateFaultyMachineryRisk() {

        FactoryRobotHazardAnalyzer analyzer =
                new FactoryRobotHazardAnalyzer();

        double result = analyzer.calculateHazardRisk(0.5, 10, "Faulty");

        assertEquals(27.5, result, 0.001);
    }
}
