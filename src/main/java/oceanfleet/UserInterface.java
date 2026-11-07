package oceanfleet;

import java.util.Scanner;

/**
 * Project Name : OceanFleet
 * Use Case     : UC5 - Integrate User Interaction (Console App)
 * Author       : Hemang
 * Date         : 07-11-2026
 *
 * Description:
 * Accepts vessel details from the user, stores vessel records,
 * retrieves a vessel by ID, and displays high-performance vessels.
 */

public class UserInterface {

    public static void main(String[] args) {

        // Create Scanner and VesselUtil objects
        Scanner scanner = new Scanner(System.in);
        VesselUtil vesselUtil = new VesselUtil();

        // Read the number of vessels
        System.out.print("Enter number of vessels: ");
        int numberOfVessels = Integer.parseInt(scanner.nextLine());

        // Accept and store vessel details
        for (int i = 0; i < numberOfVessels; i++) {

            System.out.println("Enter vessel details (vesselId:vesselName:averageSpeed:vesselType):");

            String input = scanner.nextLine();

            // Split the input using colon
            String[] details = input.split(":", -1);

            // Check whether all four details are provided
            if (details.length != 4) {
                System.out.println("Invalid vessel details. Please enter all four values.");
                i--;
                continue;
            }

            // Create a Vessel object
            String vesselId = details[0].trim();
            String vesselName = details[1].trim();
            double averageSpeed = Double.parseDouble(details[2].trim());
            String vesselType = details[3].trim();

            Vessel vessel = new Vessel(
                    vesselId,
                    vesselName,
                    averageSpeed,
                    vesselType
            );

            // Store the vessel using VesselUtil
            vesselUtil.addVesselPerformance(vessel);
        }

        // Retrieve a vessel using its ID
        System.out.print("Enter vessel ID to search: ");
        String searchId = scanner.nextLine();

        Vessel foundVessel = vesselUtil.getVesselById(searchId);

        if (foundVessel != null) {
            System.out.println("\nVessel Details:");
            displayVessel(foundVessel);
        } else {
            System.out.println("Vessel Id " + searchId + " not found");
        }

        // Display high-performance vessels
        System.out.println("\nHigh-Performance Vessels:");

        for (Vessel vessel : vesselUtil.getHighPerformanceVessels()) {
            displayVessel(vessel);
        }

        scanner.close();
    }

    // Display vessel details in the required format
    private static void displayVessel(Vessel vessel) {
        System.out.println(
                vessel.getVesselId() + " | " +
                        vessel.getVesselName() + " | " +
                        vessel.getVesselType() + " | " +
                        vessel.getAverageSpeed() + " knots"
        );
    }
}