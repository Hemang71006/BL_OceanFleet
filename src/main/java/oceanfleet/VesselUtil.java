
package oceanfleet;

import java.util.ArrayList;
import java.util.List;

/**
 * Project Name : OceanFleet
 * Use Case     : UC4 - Identify High-Performance Vessels
 * Author       : Hemang
 * Date         : 07-11-2026
 *
 * Description:
 * Stores vessel performance records, retrieves vessels using
 * their IDs and identifies vessels with the highest average speed.
 */

public class VesselUtil {

    // Declare a list to store vessel objects
    private List<Vessel> vesselList;

    // Constructor to initialize the list
    public VesselUtil() {
        vesselList = new ArrayList<>();
    }

    // Getter for vessel list
    public List<Vessel> getVesselList() {
        return vesselList;
    }

    // Setter for vessel list
    public void setVesselList(List<Vessel> vesselList) {
        this.vesselList = vesselList;
    }

    // Add a new vessel performance record
    public void addVesselPerformance(Vessel vessel) {
        vesselList.add(vessel);
    }

    // Retrieve vessel details using vessel ID
    public Vessel getVesselById(String vesselId) {

        // Search for the vessel in the list
        for (Vessel vessel : vesselList) {

            // Compare vessel IDs (case-sensitive)
            if (vesselId != null
                    && vesselId.equals(vessel.getVesselId())) {

                return vessel;
            }
        }

        // Return null if vessel is not found
        return null;
    }

    // Retrieve all vessels having the highest average speed
    public List<Vessel> getHighPerformanceVessels() {

        // Create a list to store high-performance vessels
        List<Vessel> highPerformanceVessels = new ArrayList<>();

        // Return empty list if no vessels are available
        if (vesselList.isEmpty()) {
            return highPerformanceVessels;
        }

        // Initialize highest speed
        double highestSpeed = Double.NEGATIVE_INFINITY;

        // Find the highest average speed
        for (Vessel vessel : vesselList) {

            if (vessel.getAverageSpeed() > highestSpeed) {
                highestSpeed = vessel.getAverageSpeed();
            }
        }

        // Collect all vessels having the highest speed
        for (Vessel vessel : vesselList) {

            if (Double.compare(
                    vessel.getAverageSpeed(), highestSpeed) == 0) {

                highPerformanceVessels.add(vessel);
            }
        }

        // Return all high-performance vessels
        return highPerformanceVessels;
    }
}
