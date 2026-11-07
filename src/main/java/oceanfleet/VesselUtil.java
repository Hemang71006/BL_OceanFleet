
package oceanfleet;

import java.util.ArrayList;
import java.util.List;

/**
 * Project Name : OceanFleet
 * Use Case     : UC2 - Store Vessel Records Using List
 * Author       : Hemang
 * Date         : 07-11-2026
 *
 * Description:
 * Stores and manages vessel performance records using a List.
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
}
