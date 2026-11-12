
package FactoryRobotHazardAnalyzer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FactoryRobotHazardAnalyzerTest {

    FactoryRobotHazardAnalyzer analyzer =
            new FactoryRobotHazardAnalyzer();

    @Test
    void shouldCalculateHazardRisk() {

        double result = analyzer.calculateHazardRisk(0.5, 10, "Critical");

        assertEquals(37.5, result, 0.001);
    }

    @Test
    void shouldRejectInvalidArmPrecision() {

        double result = analyzer.calculateHazardRisk(1.5, 10, "Worn");

        assertEquals(-1, result);
    }

    @Test
    void shouldRejectInvalidWorkerDensity() {

        double result = analyzer.calculateHazardRisk(0.5, 25, "Worn");

        assertEquals(-1, result);
    }
}
