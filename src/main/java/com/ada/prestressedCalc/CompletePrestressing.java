/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ada.prestressedCalc;

/**
 *
 * @author Hudson
 */
public class CompletePrestressing {

    private final double inertia;
    private final double area;
    private final double prestressingExcentricity;
    private final double inferiorFiberDistance;
    private final double superiorFiberDistance;
    private final double selfLoadMoment;
    private final double othersDeadLoad;
    private final double liveLoadPrincipalMoment;
    private final double liveLoadSecundaryMoment;
    private final double psi_1_Coeff;
    private final double psi_2_Coeff;

    public CompletePrestressing(Builder builder) {
        inertia = builder.inertia;
        area = builder.area;
        prestressingExcentricity = builder.prestressingExcentricity;
        inferiorFiberDistance = builder.inferiorFiberDistance;
        superiorFiberDistance = builder.superiorFiberDistance;
        selfLoadMoment = builder.selfLoadMoment;
        othersDeadLoad = builder.othersDeadLoad;
        liveLoadPrincipalMoment = builder.liveLoadPrincipalMoment;
        liveLoadSecundaryMoment = builder.liveLoadSecundaryMoment;
        psi_1_Coeff = builder.psi_1_Coeff;
        psi_2_Coeff = builder.psi_2_Coeff;

    }

    public static class Builder {

        private double inertia = 0.0;
        private double area = 0.0;
        private double prestressingExcentricity = 0.0;
        private double inferiorFiberDistance = 0.0;
        private double superiorFiberDistance = 0.0;
        private double selfLoadMoment = 0.0;
        private double othersDeadLoad = 0.0;
        private double liveLoadPrincipalMoment = 0.0;
        private double liveLoadSecundaryMoment = 0.0;
        private double psi_1_Coeff = 0.0;
        private double psi_2_Coeff = 0.0;

        public Builder inertia(double val) {
            inertia = val;
            return this;
        }

        public Builder area(double val) {
            area = val;
            return this;
        }

        public Builder prestressingExcentricity(double val) {
            prestressingExcentricity = val;
            return this;
        }

        public Builder inferiorFiberDistance(double val) {
            inferiorFiberDistance = val;
            return this;
        }

        public Builder superiorFiberDistance(double val) {
            superiorFiberDistance = val;
            return this;
        }

        public Builder selfLoadMoment(double val) {
            selfLoadMoment = val;
            return this;
        }

        public Builder othersDeadLoad(double val) {
            othersDeadLoad = val;
            return this;
        }

        public Builder liveLoadPrincipalMoment(double val) {
            liveLoadPrincipalMoment = val;
            return this;
        }

        public Builder liveLoadSecundaryMoment(double val) {
            liveLoadSecundaryMoment = val;
            return this;
        }

        public Builder psi_1_Coeff(double val) {
            psi_1_Coeff = val;
            return this;
        }

        public Builder psi_2_Coeff(double val) {
            psi_2_Coeff = val;
            return this;
        }
        
        private void descompressionLimiteState(){
            
        }

    }

}
