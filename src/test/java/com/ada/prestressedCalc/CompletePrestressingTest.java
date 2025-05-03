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
        CompletePrestressing c = new CompletePrestressing.Builder()
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
                .psi_2_Coeff(1)
                .fck(50)
                .sectionType("doubleT")                
                .build();           
        double result = c.prestressedForce(1.978, 35);
        assertEquals(1083.2, result, 1e-1);
    }

  
    
}
