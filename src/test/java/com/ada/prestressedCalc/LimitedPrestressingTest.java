/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.ada.prestressedCalc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ada
 */
public class LimitedPrestressingTest {

    @Test
    void testPrestressedForceTypicalValues() {
        PrestressingForces comp = new PrestressingForces.Builder()
                .inertia(6.041E5)
                .area(2.648E3)
                .prestressingExcentricity(25)
                .inferiorFiberDistance(35)
                .superiorFiberDistance(15)
                .selfLoadMoment(18619)
                .othersDeadLoad(13500)
                .liveLoadPrincipalMoment(5063)
                .liveLoadSecundaryMoment(0)
                .psi_1_Coeff(0.4)
                .psi_2_Coeff(0.3)
                .fck(50)
                .sectionType("sectionT")
                .typePrestressing("Limited")
                .build();
        double force = comp.prestressedForce(1.949, 35);
        assertEquals(1067.0, force, 1.0);

    }

    @Test
    void testPrestressedForceTypicalValues_02() {
        PrestressingForces comp = new PrestressingForces.Builder()
                .inertia(6.041E5)
                .area(2.648E3)
                .prestressingExcentricity(25)
                .inferiorFiberDistance(35)
                .superiorFiberDistance(15)
                .selfLoadMoment(18619)
                .othersDeadLoad(13500)
                .liveLoadPrincipalMoment(5063)
                .liveLoadSecundaryMoment(0)
                .psi_1_Coeff(0.4)
                .psi_2_Coeff(0.3)
                .fck(50)
                .sectionType("sectionT")
                .typePrestressing("Limited")
                .build();
        double force = comp.prestressedForce(1.949, 35);
        double stress = comp.prestressedStressSup(1067, 15);
        assertEquals(0.260, stress, 0.001);

    }

    @Test
    void testPrestressedForceTypicalValues_04() throws Exception {
        PrestressingForces comp = new PrestressingForces.Builder()
                .inertia(6.041E5)
                .area(2.648E3)
                .prestressingExcentricity(25)
                .inferiorFiberDistance(35)
                .superiorFiberDistance(15)
                .selfLoadMoment(18619)
                .othersDeadLoad(13500)
                .liveLoadPrincipalMoment(5063)
                .liveLoadSecundaryMoment(0)
                .psi_1_Coeff(0.4)
                .psi_2_Coeff(0.3)
                .fck(50)
                .sectionType("sectionT")
                .typePrestressing("Limited")
                .build();
        double f = comp.forceInServiceabilityLimitState("descompression");
        assertEquals(1067.0, f, 1);
    }

    @Test
    void testPrestressedForceTypicalValues_05() throws Exception {
        PrestressingForces comp = new PrestressingForces.Builder()
                .inertia(6.041E5)
                .area(2.648E3)
                .prestressingExcentricity(25)
                .inferiorFiberDistance(35)
                .superiorFiberDistance(15)
                .selfLoadMoment(18619)
                .othersDeadLoad(13500)
                .liveLoadPrincipalMoment(5063)
                .liveLoadSecundaryMoment(0)
                .psi_1_Coeff(0.4)
                .psi_2_Coeff(0.3)
                .fck(50)
                .sectionType("sectionT")
                .typePrestressing("Limited")
                .build();
        double f = comp.forceInServiceabilityLimitState("fissuration");
        assertEquals(896.0, f, 1);
    }

    @Test
    void testPrestressedDescompression_02() throws Exception {
        PrestressingForces comp = new PrestressingForces.Builder()
                .inertia(3415800)
                .area(3549)
                .prestressingExcentricity(58.7)
                .inferiorFiberDistance(68.8)
                .superiorFiberDistance(32.8)
                .selfLoadMoment(50303)
                .othersDeadLoad(3403)
                .liveLoadPrincipalMoment(33460)
                .liveLoadSecundaryMoment(0)
                .psi_1_Coeff(0.5)
                .psi_2_Coeff(0.4)
                .fck(35)
                .sectionType("sectionT")
                .typePrestressing("Limited")
                .build();
        double f = comp.forceInServiceabilityLimitState("descompression");
        assertEquals(923.0, f, 1);
    }

    @Test
    void testPrestresseedStressSup_02() throws Exception {
        PrestressingForces comp = new PrestressingForces.Builder()
                .inertia(3415800)
                .area(3549)
                .prestressingExcentricity(58.7)
                .inferiorFiberDistance(68.8)
                .superiorFiberDistance(32.8)
                .selfLoadMoment(50303)
                .othersDeadLoad(3403)
                .liveLoadPrincipalMoment(33460)
                .liveLoadSecundaryMoment(0)
                .psi_1_Coeff(0.5)
                .psi_2_Coeff(0.4)
                .fck(35)
                .sectionType("sectionT")
                .typePrestressing("Limited")
                .build();
        double s = comp.prestressedStressSup(923, 32.8);
        assertEquals(0.260, s, 0.001);
    }
        @Test
    void testPrestressedDescompression_03() throws Exception {
        PrestressingForces comp = new PrestressingForces.Builder()
                .inertia(3415800)
                .area(3549)
                .prestressingExcentricity(58.7)
                .inferiorFiberDistance(68.8)
                .superiorFiberDistance(32.8)
                .selfLoadMoment(50303)
                .othersDeadLoad(3403)
                .liveLoadPrincipalMoment(33460)
                .liveLoadSecundaryMoment(0)
                .psi_1_Coeff(0.5)
                .psi_2_Coeff(0.4)
                .fck(35)
                .sectionType("sectionT")
                .typePrestressing("Limited")
                .build();
        double f = comp.forceInServiceabilityLimitState("fissuration");
        assertEquals(785.0, f, 1);
    }
}
