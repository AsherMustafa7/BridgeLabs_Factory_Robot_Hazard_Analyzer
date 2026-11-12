
package FactoryRobotHazardAnalyzer;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FactoryRobotHazardAnalyzerTest {

    @Test
    void shouldDisplayHazardAnalyzerMessage() {

        ByteArrayOutputStream output = new ByteArrayOutputStream();

        PrintStream originalOutput = System.out;

        System.setOut(new PrintStream(output));

        FactoryRobotHazardAnalyzer.main(new String[]{});

        System.setOut(originalOutput);

        assertEquals(
                "Factory Robot Hazard Analyzer",
                output.toString().trim()
        );
    }
}
