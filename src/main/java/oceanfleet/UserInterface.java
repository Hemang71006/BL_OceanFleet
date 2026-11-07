package oceanfleet;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Project Name : OceanFleet
 * Use Case     : UC6 - Refactor Using OOPS Principles
 * Author       : Hemang
 * Date         : 07-11-2026
 *
 * Description:
 * Handles user interaction separately from vessel data and
 * vessel management logic using OOPS principles.
 */

public class UserInterface {

    // Declare dependencies
    private final Scanner scanner;
    private final PrintStream output;
    private final VesselUtil vesselUtil;

    // Constructor to initialize dependencies
    public UserInterface(Scanner scanner, PrintStream output,
                         VesselUtil vesselUtil) {

        this.scanner = scanner;
        this.output = output;
        this.vesselUtil = vesselUtil;
    }

    // Main method - application entry point
    public static void main(String[] args) {

        // Create required objects
        Scanner scanner = new Scanner(System.in);
        VesselUtil vesselUtil = new VesselUtil();

        // Create UserInterface object and start application
        UserInterface userInterface =
                new UserInterface(scanner, System.out, vesselUtil);

        userInterface.run();
    }

    // Control the complete application flow
    public void run() {

        // Read the number of vessels
        int numberOfVessels = readNumberOfVessels();

        // Read and store vessel records
        readAndStoreVessels(numberOfVessels);

        // Search for a vessel using its ID
        searchAndDisplayVessel();

        // Display high-performance vessels
        displayHighPerformanceVessels();
    }

    // Read the number of vessels from the user
    private int readNumberOfVessels() {

        output.print("Enter number of vessels: ");

        return Integer.parseInt(scanner.nextLine());
    }

    // Accept vessel details and store them using VesselUtil
    private void readAndStoreVessels(int numberOfVessels) {

        for (int i = 0; i < numberOfVessels; i++) {

            Vessel vessel = readVesselDetails();

            vesselUtil.addVesselPerformance(vessel);
        }
    }

    // Read and convert console input into a Vessel object
    private Vessel readVesselDetails() {

        output.println(
                "Enter vessel details (vesselId:vesselName:averageSpeed:vesselType):"
        );

        String input = scanner.nextLine();

        // Split input into four fields
        String[] details = input.split(":", -1);

        // Validate the number of fields
        if (details.length != 4) {
            throw new IllegalArgumentException(
                    "Invalid vessel details. Expected four values."
            );
        }

        // Extract vessel attributes
        String vesselId = details[0].trim();
        String vesselName = details[1].trim();
        double averageSpeed = Double.parseDouble(details[2].trim());
        String vesselType = details[3].trim();

        // Return the created Vessel object
        return new Vessel(
                vesselId,
                vesselName,
                averageSpeed,
                vesselType
        );
    }

    // Search for a vessel and display its details
    private void searchAndDisplayVessel() {

        output.print("Enter vessel ID to search: ");

        String vesselId = scanner.nextLine();

        Vessel vessel = vesselUtil.getVesselById(vesselId);

        if (vessel != null) {
            output.println("\nVessel Details:");
            displayVessel(vessel);
        } else {
            output.println("Vessel Id " + vesselId + " not found");
        }
    }

    // Display all vessels having the highest average speed
    private void displayHighPerformanceVessels() {

        output.println("\nHigh-Performance Vessels:");

        for (Vessel vessel : vesselUtil.getHighPerformanceVessels()) {
            displayVessel(vessel);
        }
    }

    // Display a single vessel in the required format
    private void displayVessel(Vessel vessel) {

        output.println(
                vessel.getVesselId() + " | " +
                        vessel.getVesselName() + " | " +
                        vessel.getVesselType() + " | " +
                        vessel.getAverageSpeed() + " knots"
        );
    }
}