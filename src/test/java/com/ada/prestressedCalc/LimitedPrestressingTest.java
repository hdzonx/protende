/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.ada.prestressedCalc;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author ada
 */
public class LimitedPrestressingTest {

    @Test()
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
        Assert.assertEquals(1067.0, force, 1.0);

    }

    @Test()
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
        Assert.assertEquals(0.260, stress, 0.001);

    }

    @Test()
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
        Assert.assertEquals(1067.0, f, 1);
    }

    @Test()
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
        Assert.assertEquals(896.0, f, 1);
    }

    @Test()
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
        Assert.assertEquals(923.0, f, 1);
    }

    @Test()
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
        Assert.assertEquals(0.260, s, 0.001);
    }

    @Test()
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
        Assert.assertEquals(785.0, f, 1);
    }

    @Test()
    void testPrestressedForceTypicalValues_03() throws Exception {
        PrestressingForces comp = new PrestressingForces.Builder()
                .inertia(2942254)
                .area(2432)
                .prestressingExcentricity(38)
                .inferiorFiberDistance(47.85)
                .superiorFiberDistance(53.75)
                .selfLoadMoment(29795)
                .othersDeadLoad(7351)
                .liveLoadPrincipalMoment(78898)
                .liveLoadSecundaryMoment(0)
                .psi_1_Coeff(0.7)
                .psi_2_Coeff(0.6)
                .fck(40)
                .sectionType("sectionI")
                .typePrestressing("Limited")
                .build();
        double f = comp.forceInServiceabilityLimitState("descompression");
        Assert.assertEquals(1336.0, f, 1.0);
    }

    @Test()
    void testPrestressedStressSup_03() throws Exception {
        PrestressingForces comp = new PrestressingForces.Builder()
                .inertia(2942254)
                .area(2432)
                .prestressingExcentricity(38)
                .inferiorFiberDistance(47.85)
                .superiorFiberDistance(53.75)
                .selfLoadMoment(29795)
                .othersDeadLoad(7351)
                .liveLoadPrincipalMoment(78898)
                .liveLoadSecundaryMoment(0)
                .psi_1_Coeff(0.7)
                .psi_2_Coeff(0.6)
                .fck(40)
                .sectionType("sectionI")
                .typePrestressing("Limited")
                .build();
        double stress = comp.prestressedStressSup(1336, 53.75);
        Assert.assertEquals(0.378, stress, 0.001);
    }

    @Test()
    void testPrestressedForceTypicalValues_06() throws Exception {
        PrestressingForces comp = new PrestressingForces.Builder()
                .inertia(2942254)
                .area(2432)
                .prestressingExcentricity(38)
                .inferiorFiberDistance(47.85)
                .superiorFiberDistance(53.75)
                .selfLoadMoment(29795)
                .othersDeadLoad(7351)
                .liveLoadPrincipalMoment(78898)
                .liveLoadSecundaryMoment(0)
                .psi_1_Coeff(0.7)
                .psi_2_Coeff(0.6)
                .fck(40)
                .sectionType("sectionI")
                .typePrestressing("Limited")
                .build();
        double f = comp.forceInServiceabilityLimitState("fissuration");
        Assert.assertEquals(1150.0, f, 1.0);
    }

    @Test()
    void testPrestressedStressSup_04() throws Exception {
        PrestressingForces comp = new PrestressingForces.Builder()
                .inertia(2942254)
                .area(2432)
                .prestressingExcentricity(38)
                .inferiorFiberDistance(47.85)
                .superiorFiberDistance(53.75)
                .selfLoadMoment(29795)
                .othersDeadLoad(7351)
                .liveLoadPrincipalMoment(78898)
                .liveLoadSecundaryMoment(0)
                .psi_1_Coeff(0.7)
                .psi_2_Coeff(0.6)
                .fck(40)
                .sectionType("sectionI")
                .typePrestressing("Limited")
                .build();
        double stress = comp.prestressedStressSup(1336, 53.75);
        Assert.assertEquals(0.378, stress, 0.001);
    }

}
