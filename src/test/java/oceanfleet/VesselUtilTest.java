
package oceanfleet;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VesselUtilTest {

    // UC2 - Test whether vessel list is initially empty
    @Test
    void testInitialVesselListIsEmpty() {

        VesselUtil vesselUtil = new VesselUtil();

        assertNotNull(vesselUtil.getVesselList());
        assertTrue(vesselUtil.getVesselList().isEmpty());
    }

    // UC2 - Test adding a single vessel
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

    // UC2 - Test adding multiple vessels
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

    // UC2 - Test setter method for vessel list
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

    // UC3 - Test retrieving an existing vessel
    @Test
    void testGetVesselByIdFound() {

        VesselUtil vesselUtil = new VesselUtil();

        Vessel vessel = new Vessel(
                "V001", "Sea King", 25.5, "Cargo"
        );

        vesselUtil.addVesselPerformance(vessel);

        Vessel result = vesselUtil.getVesselById("V001");

        assertNotNull(result);
        assertSame(vessel, result);
        assertEquals("Sea King", result.getVesselName());
    }

    // UC3 - Test retrieving a vessel that does not exist
    @Test
    void testGetVesselByIdNotFound() {

        VesselUtil vesselUtil = new VesselUtil();

        vesselUtil.addVesselPerformance(
                new Vessel("V001", "Sea King", 25.5, "Cargo")
        );

        Vessel result = vesselUtil.getVesselById("V004");

        assertNull(result);
    }

    // UC3 - Test case-sensitive vessel ID search
    @Test
    void testGetVesselByIdCaseSensitive() {

        VesselUtil vesselUtil = new VesselUtil();

        vesselUtil.addVesselPerformance(
                new Vessel("V001", "Sea King", 25.5, "Cargo")
        );

        Vessel result = vesselUtil.getVesselById("v001");

        assertNull(result);
    }

    // UC4 - Test retrieving a vessel with the highest speed
    @Test
    void testGetHighPerformanceVesselsSingleHighest() {

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

        List<Vessel> result =
                vesselUtil.getHighPerformanceVessels();

        assertEquals(1, result.size());
        assertSame(vessel1, result.get(0));
    }

    // UC4 - Test multiple vessels sharing the highest speed
    @Test
    void testGetHighPerformanceVesselsWithTie() {

        VesselUtil vesselUtil = new VesselUtil();

        Vessel vessel1 = new Vessel(
                "V001", "Sea King", 25.5, "Cargo"
        );

        Vessel vessel2 = new Vessel(
                "V002", "Ocean Star", 18.0, "Tanker"
        );

        Vessel vessel3 = new Vessel(
                "V003", "Wave Rider", 25.5, "Cruise"
        );

        vesselUtil.addVesselPerformance(vessel1);
        vesselUtil.addVesselPerformance(vessel2);
        vesselUtil.addVesselPerformance(vessel3);

        List<Vessel> result =
                vesselUtil.getHighPerformanceVessels();

        assertEquals(2, result.size());
        assertSame(vessel1, result.get(0));
        assertSame(vessel3, result.get(1));
    }

    // UC4 - Test that lower-speed vessels are excluded
    @Test
    void testLowerSpeedVesselsAreExcluded() {

        VesselUtil vesselUtil = new VesselUtil();

        Vessel vessel1 = new Vessel(
                "V001", "Sea King", 25.5, "Cargo"
        );

        Vessel vessel2 = new Vessel(
                "V002", "Ocean Star", 18.0, "Tanker"
        );

        vesselUtil.addVesselPerformance(vessel1);
        vesselUtil.addVesselPerformance(vessel2);

        List<Vessel> result =
                vesselUtil.getHighPerformanceVessels();

        assertEquals(1, result.size());
        assertFalse(result.contains(vessel2));
    }

    // UC4 - Test high-performance result with single vessel
    @Test
    void testGetHighPerformanceVesselsWithSingleVessel() {

        VesselUtil vesselUtil = new VesselUtil();

        Vessel vessel = new Vessel(
                "V001", "Sea King", 25.5, "Cargo"
        );

        vesselUtil.addVesselPerformance(vessel);

        List<Vessel> result =
                vesselUtil.getHighPerformanceVessels();

        assertEquals(1, result.size());
        assertSame(vessel, result.get(0));
    }

    // UC4 - Test high-performance result with empty list
    @Test
    void testGetHighPerformanceVesselsWithEmptyList() {

        VesselUtil vesselUtil = new VesselUtil();

        List<Vessel> result =
                vesselUtil.getHighPerformanceVessels();

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }
}
