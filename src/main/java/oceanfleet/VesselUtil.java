
package oceanfleet;

import java.util.ArrayList;
import java.util.List;

/**
 * Project Name : OceanFleet
 * Use Case     : UC3 - Retrieve Vessel by Vessel ID
 * Author       : Hemang
 * Date         : 07-11-2026
 *
 * Description:
 * Stores vessel records and retrieves vessels using their IDs.
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
}
