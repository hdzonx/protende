/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ada.prestressedCalc;
import org.testng.Assert;
import org.testng.annotations.Test;
/**
 *
 * @author Hudson
 */
public class PrestressingForcesTestNG {
     @Test()
    public void testEffectivePrestressForce03() throws Exception {
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
                .posTensionOrPreTension("preTension")
                .relaxationType("low")
                .tendonType("CP190_127")
                .lossPrestress(0.30)
                .f_ptk(190)
                .build();

        comp.run();
        double operatedStress = comp.getOperatedStress();
        double forceWithLoss = comp.getFinalForceWithLoss();
        double f = comp.getEffectivePrestressForce();
        
        // Teste de assertiva
        Assert.assertEquals(f, 1598.9, 1.0);
    }
}
