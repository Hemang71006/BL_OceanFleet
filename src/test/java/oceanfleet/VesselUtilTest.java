
package oceanfleet;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VesselUtilTest {

    // Test whether vessel list is initially empty
    @Test
    void testInitialVesselListIsEmpty() {

        VesselUtil vesselUtil = new VesselUtil();

        assertNotNull(vesselUtil.getVesselList());
        assertTrue(vesselUtil.getVesselList().isEmpty());
    }

    // Test adding a single vessel
    @Test
    void testAddSingleVessel() {

        VesselUtil vesselUtil = new VesselUtil();

        Vessel vessel = new Vessel(
                "V001", "Sea King", 25.5, "Cargo"
        );

        vesselUtil.addVesselPerformance(vessel);

        assertEquals(1, vesselUtil.getVesselList().size());
        assertSame(vessel, vesselUtil.getVesselList().get(0));
    }

    // Test adding multiple vessels
    @Test
    void testAddMultipleVessels() {

        VesselUtil vesselUtil = new VesselUtil();

        Vessel vessel1 = new Vessel(
                "V001", "Sea King", 25.5, "Cargo"
        );

        Vessel vessel2 = new Vessel(
                "V002", "Ocean Star", 18.0, "Tanker"
        );

        Vessel vessel3 = new Vessel(
                "V003", "Wave Rider", 22.3, "Cruise"
        );

        vesselUtil.addVesselPerformance(vessel1);
        vesselUtil.addVesselPerformance(vessel2);
        vesselUtil.addVesselPerformance(vessel3);

        assertEquals(3, vesselUtil.getVesselList().size());

        assertSame(vessel1, vesselUtil.getVesselList().get(0));
        assertSame(vessel2, vesselUtil.getVesselList().get(1));
        assertSame(vessel3, vesselUtil.getVesselList().get(2));
    }

    // Test setter method for vessel list
    @Test
    void testSetVesselList() {

        VesselUtil vesselUtil = new VesselUtil();

        List<Vessel> vessels = new ArrayList<>();

        Vessel vessel = new Vessel(
                "V004", "Blue Horizon", 20.0, "Cargo"
        );

        vessels.add(vessel);

        vesselUtil.setVesselList(vessels);

        assertSame(vessels, vesselUtil.getVesselList());
        assertEquals(1, vesselUtil.getVesselList().size());
        assertSame(vessel, vesselUtil.getVesselList().get(0));
    }
}
