/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.ada.prestressedCalc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Hudson
 */
public class CompletePrestressingTest {

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
                .typePrestressing("Total")
                .build();
        double force = comp.prestressedForce(1.978, 35);
        assertEquals(1083.2, force, 1e-1);

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
                .typePrestressing("Total")
                .build();
        double force = comp.prestressedForce(1.978, 35);
        double stress = comp.prestressedStressSup(1083.2, 15);
        assertEquals(0.264, stress, 0.001);

    }

    @Test
    void testPrestressedForceTypicalValues_03() {
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
                .typePrestressing("Total")
                .build();
        double stress = comp.normalStress(18619, 6.041E5, 35);
        assertEquals(1.079, stress, 0.001);
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
                .typePrestressing("Total")
                .build();
        double f = comp.forceInServiceabilityLimitState("descompression");
        assertEquals(1083.3, f, 0.1);
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
                .typePrestressing("Total")
                .build();
        double f = comp.forceInServiceabilityLimitState("fissuration");
        assertEquals(992.4, f, 0.1);
    }

    @Test
    void testFinalForceWithLossPrestress() throws Exception {
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
                .typePrestressing("Total")
                .lossPrestress(0.3)
                .build();
        double f = comp.finalForceWithLossPrestress();
        assertEquals(1547.6, f, 0.1);
    }
        @Test
    void testeffectivePrestressStress02() throws Exception {
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
                .typePrestressing("Total")
                .build();

        double f = comp.effectivePrestressForce("CP190_127", 145.35, 1547.6);
        assertEquals(1598.9, f, 1.0);
    }

    @Test
    void testeffectivePrestressForce02() throws Exception {
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
                .typePrestressing("Total")
                .build();

        double f = comp.effectivePrestressForce("CP190_127", 145.35, 1547.6);
        assertEquals(1598.9, f, 1.0);
    }

}
