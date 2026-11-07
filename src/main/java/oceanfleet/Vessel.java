
package oceanfleet;

/**
 * Project Name : OceanFleet
 * Use Case     : UC1 - Create Vessel Model
 * Author       : Hemang
 * Date         : 06-11-2026
 *
 * Description:
 * Represents a vessel and stores its performance details.
 */

public class Vessel {

    // Declare vessel attributes
    private String vesselId;
    private String vesselName;
    private double averageSpeed;
    private String vesselType;

    // No-argument constructor
    public Vessel() {
    }

    // Four-argument constructor
    public Vessel(String vesselId, String vesselName,
                  double averageSpeed, String vesselType) {

        this.vesselId = vesselId;
        this.vesselName = vesselName;
        this.averageSpeed = averageSpeed;
        this.vesselType = vesselType;
    }

    // Getter and setter methods

    public String getVesselId() {
        return vesselId;
    }

    public void setVesselId(String vesselId) {
        this.vesselId = vesselId;
    }

    public String getVesselName() {
        return vesselName;
    }

    public void setVesselName(String vesselName) {
        this.vesselName = vesselName;
    }

    public double getAverageSpeed() {
        return averageSpeed;
    }

    public void setAverageSpeed(double averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    public String getVesselType() {
        return vesselType;
    }

    public void setVesselType(String vesselType) {
        this.vesselType = vesselType;
    }
}

