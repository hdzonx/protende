/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ada.prestressedCalc;

import javax.swing.JOptionPane;

/**
 *
 * @author Hudson
 */
public class CompletePrestressing {

    private final double inertia; //cm4
    private final double area;//cm²
    private final double prestressingExcentricity;//cm
    private final double inferiorFiberDistance;//cm
    private final double superiorFiberDistance;//cm
    private final double selfLoadMoment;//kNcm
    private final double othersDeadLoad;//kNcm
    private final double liveLoadPrincipalMoment;//kNcm
    private final double liveLoadSecundaryMoment;//kNcm
    private final double psi_1_Coeff;
    private final double psi_2_Coeff;
    private final double fck; // kN/cm²
    private final String sectionType;

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
        fck = builder.fck;
        sectionType = builder.sectionType;

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
        private double fck = 0.0;
        private String sectionType = "";

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

        public Builder fck(double val) {
            fck = val;
            return this;
        }

        public Builder sectionType(String val) {
            sectionType = val;
            return this;
        }

        private double normalStress(double moment, double inertia, double distance) {
            double stress = moment * distance / inertia;
            return stress;
        }

        private double concreteStressTension() throws Exception {
            double alpha = 0.0;
            if (sectionType.equalsIgnoreCase("sectionT")) {
                alpha = 1.2;

            } else if (sectionType.equalsIgnoreCase("sectionI")) {
                alpha = 1.3;

            } else if (sectionType.equalsIgnoreCase("rectangularSection")) {
                alpha = 1.5;
            } else {
                JOptionPane.showMessageDialog(null, "Tipo de seção não reconhecido");
                throw new Exception("non-existent section type");
            }
            return 0.1 * alpha * 0.7 * 0.3 * Math.pow(10 * fck, 2.0 / 3.0);
        }

        protected void serviceabilityLimitState() throws Exception {

            //tensões devido aos momentos permanentes
            double selfLoadStressInf = normalStress(selfLoadMoment, inertia, inferiorFiberDistance);
            double othersDeadStressInf = normalStress(othersDeadLoad, inertia, inferiorFiberDistance);
            double selfLoadStressSup = -normalStress(selfLoadMoment, inertia, superiorFiberDistance);
            double othersDeadStressSup = -normalStress(othersDeadLoad, inertia, superiorFiberDistance);
            // tensões devido aos momentos variáveis
            double liveLoadPrincipalStressInf = normalStress(liveLoadPrincipalMoment, inertia, inferiorFiberDistance);
            double liveLoadSecundaryStressInf = normalStress(liveLoadSecundaryMoment, inertia, inferiorFiberDistance);
            double liveLoadPrincipalStressSup = -normalStress(liveLoadPrincipalMoment, inertia, superiorFiberDistance);
            double liveLoadSecundaryStressSup = -normalStress(liveLoadSecundaryMoment, inertia, superiorFiberDistance);

            //tensão de protensão em relação às fibras inferiores para o Estado Limite de Descompressão
            double prestresStressInf = selfLoadStressInf + othersDeadStressInf + psi_1_Coeff * liveLoadPrincipalStressInf + psi_2_Coeff * liveLoadSecundaryStressInf;
            double den = 1 - area * prestressingExcentricity * inferiorFiberDistance / inertia;
            double prestressedForce = prestresStressInf * area / den;

            //verificação das tensões de tração (topo da viga) para o Estado Limite de Descompressão
            double prestressStressSup = prestressedForce / area * (1 - area * prestressingExcentricity * superiorFiberDistance / inertia);
            double compressionStress = selfLoadStressSup + othersDeadStressSup + psi_1_Coeff * liveLoadPrincipalStressSup + psi_2_Coeff * liveLoadSecundaryStressSup - prestressStressSup;

            //Verificação do Estado Limite de Descompressão
            if (compressionStress > 0.5 * fck) {
                JOptionPane.showMessageDialog(null, "Não atende ao estado limite de descompressão");
                throw new Exception("Does not meet the decompression limit state");
            }

            //Tensão de protensão nas fibras inferiores parao Estado Limite de Formação de Fissuras
            double prestresStressInfFiss = selfLoadStressInf + othersDeadStressInf + liveLoadPrincipalStressInf + psi_1_Coeff * liveLoadSecundaryStressInf - concreteStressTension();
            double prestressedForceFiss = prestresStressInfFiss * area / den;
        }
    }

}
