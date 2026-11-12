
package FactoryRobotHazardAnalyzer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RobotHazardAuditorTest {

    RobotHazardAuditor auditor = new RobotHazardAuditor();

    @Test
    void shouldCalculateHazardRisk() throws RobotSafetyException {

        double result = auditor.calculateHazardRisk(
                0.5, 10, "Critical"
        );

        assertEquals(37.5, result, 0.001);
    }

    @Test
    void shouldRejectInvalidArmPrecision() {

        assertThrows(
                RobotSafetyException.class,
                () -> auditor.calculateHazardRisk(1.5, 10, "Worn")
        );
    }

    @Test
    void shouldRejectInvalidWorkerDensity() {

        assertThrows(
                RobotSafetyException.class,
                () -> auditor.calculateHazardRisk(0.5, 25, "Worn")
        );
    }

    @Test
    void shouldRejectUnsupportedMachineryState() {

        assertThrows(
                RobotSafetyException.class,
                () -> auditor.calculateHazardRisk(0.5, 10, "Optimal")
        );
    }
}
