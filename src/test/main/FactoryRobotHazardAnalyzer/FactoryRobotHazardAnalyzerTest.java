
package FactoryRobotHazardAnalyzer;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class FactoryRobotHazardAnalyzerTest {

    @Test
    void shouldAcceptAndDisplayRobotInputs() {

        String input = "0.8\n10\nWorn\n";

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

        String result = output.toString();

        assertTrue(result.contains("Arm Precision: 0.8"));
        assertTrue(result.contains("Worker Density: 10"));
        assertTrue(result.contains("Machinery State: Worn"));
    }
}
