
package FactoryRobotHazardAnalyzer;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class FactoryRobotHazardAnalyzerTest {

    private String runProgram(String input) {

        InputStream originalInput = System.in;
        PrintStream originalOutput = System.out;

        ByteArrayInputStream testInput =
                new ByteArrayInputStream(input.getBytes());

        ByteArrayOutputStream output =
                new ByteArrayOutputStream();

        System.setIn(testInput);
        System.setOut(new PrintStream(output));

        try {
            FactoryRobotHazardAnalyzer.main(new String[]{});
        } finally {
            System.setIn(originalInput);
            System.setOut(originalOutput);
        }

        return output.toString();
    }

    @Test
    void shouldRejectInvalidArmPrecision() {

        String result = runProgram("1.5\n10\nWorn\n");

        assertTrue(result.contains(
                "Error: Arm precision must be 0.0-1.0"
        ));
    }

    @Test
    void shouldRejectInvalidWorkerDensity() {

        String result = runProgram("0.5\n25\nWorn\n");

        assertTrue(result.contains(
                "Error: Worker density must be 1-20"
        ));
    }

    @Test
    void shouldCalculateRiskForValidInputs() {

        String result = runProgram("0.5\n10\nCritical\n");

        assertTrue(result.contains("Robot Hazard Risk Score: 37.5"));
    }
}
