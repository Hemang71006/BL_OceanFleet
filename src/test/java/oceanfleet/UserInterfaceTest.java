package oceanfleet;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project Name : OceanFleet
 * Use Case     : UC5 - Integrate User Interaction (Console App)
 * Author       : Hemang
 * Date         : 07-11-2026
 *
 * Description:
 * Tests console input, vessel creation, vessel retrieval,
 * and high-performance vessel display.
 */

class UserInterfaceTest {

    // Test complete console interaction with valid vessel details
    @Test
    void testConsoleInteractionWithValidInput() {

        String input =
                "3\n" +
                        "V001:Sea King:25.5:Cargo\n" +
                        "V002:Ocean Star:20.0:Passenger\n" +
                        "V003:Blue Wave:25.5:Cargo\n" +
                        "V002\n";

        InputStream originalInput = System.in;
        PrintStream originalOutput = System.out;

        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try {
            System.setIn(new ByteArrayInputStream(
                    input.getBytes(StandardCharsets.UTF_8)
            ));

            System.setOut(new PrintStream(output));

            UserInterface.main(new String[]{});

            String result = output.toString();

            assertTrue(result.contains("Vessel Details:"));
            assertTrue(result.contains("V002 | Ocean Star | Passenger | 20.0 knots"));

            assertTrue(result.contains("High-Performance Vessels:"));
            assertTrue(result.contains("V001 | Sea King | Cargo | 25.5 knots"));
            assertTrue(result.contains("V003 | Blue Wave | Cargo | 25.5 knots"));

        } finally {
            System.setIn(originalInput);
            System.setOut(originalOutput);
        }
    }

    // Test console interaction when the requested vessel ID is not found
    @Test
    void testConsoleInteractionWithVesselNotFound() {

        String input =
                "2\n" +
                        "V001:Sea King:25.5:Cargo\n" +
                        "V002:Ocean Star:20.0:Passenger\n" +
                        "V999\n";

        InputStream originalInput = System.in;
        PrintStream originalOutput = System.out;

        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try {
            System.setIn(new ByteArrayInputStream(
                    input.getBytes(StandardCharsets.UTF_8)
            ));

            System.setOut(new PrintStream(output));

            UserInterface.main(new String[]{});

            String result = output.toString();

            assertTrue(result.contains("Vessel Id V999 not found"));
            assertTrue(result.contains("High-Performance Vessels:"));

        } finally {
            System.setIn(originalInput);
            System.setOut(originalOutput);
        }
    }

    // Test that vessel details are displayed in the required order
    @Test
    void testVesselDisplayFormat() {

        String input =
                "1\n" +
                        "V001:Sea King:25.5:Cargo\n" +
                        "V001\n";

        InputStream originalInput = System.in;
        PrintStream originalOutput = System.out;

        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try {
            System.setIn(new ByteArrayInputStream(
                    input.getBytes(StandardCharsets.UTF_8)
            ));

            System.setOut(new PrintStream(output));

            UserInterface.main(new String[]{});

            String result = output.toString();

            assertTrue(result.contains(
                    "V001 | Sea King | Cargo | 25.5 knots"
            ));

        } finally {
            System.setIn(originalInput);
            System.setOut(originalOutput);
        }
    }
}