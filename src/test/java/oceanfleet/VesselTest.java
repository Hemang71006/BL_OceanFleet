
package oceanfleet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VesselTest {

    // Test no-argument constructor
    @Test
    void testNoArgumentConstructor() {

        Vessel vessel = new Vessel();

        assertNull(vessel.getVesselId());
        assertNull(vessel.getVesselName());
        assertEquals(0.0, vessel.getAverageSpeed());
        assertNull(vessel.getVesselType());
    }

    // Test four-argument constructor
    @Test
    void testParameterizedConstructor() {

        Vessel vessel = new Vessel(
                "V001", "Sea King", 25.5, "Cargo"
        );

        assertEquals("V001", vessel.getVesselId());
        assertEquals("Sea King", vessel.getVesselName());
        assertEquals(25.5, vessel.getAverageSpeed());
        assertEquals("Cargo", vessel.getVesselType());
    }

    // Test getter methods
    @Test
    void testGetterMethods() {

        Vessel vessel = new Vessel(
                "V002", "Ocean Star", 18.0, "Tanker"
        );

        assertEquals("V002", vessel.getVesselId());
        assertEquals("Ocean Star", vessel.getVesselName());
        assertEquals(18.0, vessel.getAverageSpeed());
        assertEquals("Tanker", vessel.getVesselType());
    }

    // Test setter methods
    @Test
    void testSetterMethods() {

        Vessel vessel = new Vessel();

        vessel.setVesselId("V003");
        vessel.setVesselName("Wave Rider");
        vessel.setAverageSpeed(22.3);
        vessel.setVesselType("Cruise");

        assertEquals("V003", vessel.getVesselId());
        assertEquals("Wave Rider", vessel.getVesselName());
        assertEquals(22.3, vessel.getAverageSpeed());
        assertEquals("Cruise", vessel.getVesselType());
    }
}

