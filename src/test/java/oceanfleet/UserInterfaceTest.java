package oceanfleet;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project Name : OceanFleet
 * Use Case     : UC6 - Refactor Using OOPS Principles
 * Author       : Hemang
 * Date         : 07-11-2026
 *
 * Description:
 * Tests the refactored UserInterface and verifies that
 * console interaction continues to work correctly.
 */

class UserInterfaceTest {

    // Test complete application flow with valid input
    @Test
    void testConsoleInteractionWithValidInput() {

        String input =
                "3\n" +
                        "V001:Sea King:25.5:Cargo\n" +
                        "V002:Ocean Star:20.0:Passenger\n" +
                        "V003:Blue Wave:25.5:Cargo\n" +
                        "V002\n";

        ByteArrayOutputStream output = new ByteArrayOutputStream();

        Scanner scanner = new Scanner(input);

        UserInterface userInterface = new UserInterface(
                scanner,
                new PrintStream(output),
                new VesselUtil()
        );

        userInterface.run();

        String result = output.toString(StandardCharsets.UTF_8);

        assertTrue(result.contains("Vessel Details:"));
        assertTrue(result.contains(
                "V002 | Ocean Star | Passenger | 20.0 knots"
        ));

        assertTrue(result.contains("High-Performance Vessels:"));
        assertTrue(result.contains(
                "V001 | Sea King | Cargo | 25.5 knots"
        ));
        assertTrue(result.contains(
                "V003 | Blue Wave | Cargo | 25.5 knots"
        ));
    }

    // Test application flow when the requested vessel is not found
    @Test
    void testConsoleInteractionWithVesselNotFound() {

        String input =
                "2\n" +
                        "V001:Sea King:25.5:Cargo\n" +
                        "V002:Ocean Star:20.0:Passenger\n" +
                        "V999\n";

        ByteArrayOutputStream output = new ByteArrayOutputStream();

        Scanner scanner = new Scanner(input);

        UserInterface userInterface = new UserInterface(
                scanner,
                new PrintStream(output),
                new VesselUtil()
        );

        userInterface.run();

        String result = output.toString(StandardCharsets.UTF_8);

        assertTrue(result.contains("Vessel Id V999 not found"));
        assertTrue(result.contains("High-Performance Vessels:"));
    }

    // Test the required vessel display format
    @Test
    void testVesselDisplayFormat() {

        String input =
                "1\n" +
                        "V001:Sea King:25.5:Cargo\n" +
                        "V001\n";

        ByteArrayOutputStream output = new ByteArrayOutputStream();

        Scanner scanner = new Scanner(input);

        UserInterface userInterface = new UserInterface(
                scanner,
                new PrintStream(output),
                new VesselUtil()
        );

        userInterface.run();

        String result = output.toString(StandardCharsets.UTF_8);

        assertTrue(result.contains(
                "V001 | Sea King | Cargo | 25.5 knots"
        ));
    }

    // Test invalid vessel input format
    @Test
    void testInvalidVesselInputFormat() {

        String input =
                "1\n" +
                        "V001:Sea King:25.5\n";

        ByteArrayOutputStream output = new ByteArrayOutputStream();

        Scanner scanner = new Scanner(input);

        UserInterface userInterface = new UserInterface(
                scanner,
                new PrintStream(output),
                new VesselUtil()
        );

        assertThrows(
                IllegalArgumentException.class,
                userInterface::run
        );
    }
}