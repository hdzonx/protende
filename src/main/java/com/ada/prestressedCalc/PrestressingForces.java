/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ada.prestressedCalc;

import com.ada.protende.OperatedStressTendonLimite;
import javax.swing.JOptionPane;

/**
 *
 * @author Hudson
 */
public class PrestressingForces {

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
    private final String tendonType;
    private final double lossPrestress;
    private final double f_ptk;
    private final String posTensionOrPreTension;
    private final String relaxationType;
    private final String typePrestressing;

    public PrestressingForces(Builder builder) {
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
        tendonType = builder.tendonType;
        lossPrestress = builder.lossPrestress;
        f_ptk = builder.f_ptk;
        posTensionOrPreTension = builder.posTensionOrPreTension;
        relaxationType = builder.relaxationType;
        typePrestressing = builder.typePrestressing;

    }

    public static class Builder {

        private double inertia = 0.0;
        private double area = 0.0;
        private double prestressingExcentricity;
        private double inferiorFiberDistance;
        private double superiorFiberDistance;
        private double selfLoadMoment;
        private double othersDeadLoad;
        private double liveLoadPrincipalMoment;
        private double liveLoadSecundaryMoment;
        private double psi_1_Coeff;
        private double psi_2_Coeff;
        private double fck;
        private String sectionType;
        private String tendonType;
        private double lossPrestress;
        private double f_ptk;
        private String posTensionOrPreTension;
        private String relaxationType;
        private String typePrestressing;

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

        public Builder tendonType(String val) {
            tendonType = val;
            return this;
        }

        public Builder lossPrestress(double val) {
            lossPrestress = val;
            return this;
        }

        public Builder f_ptk(double val) {
            f_ptk = val;
            return this;
        }

        public Builder posTensionOrPreTension(String val) {
            posTensionOrPreTension = val;
            return this;
        }

        public Builder relaxationType(String val) {
            relaxationType = val;
            return this;
        }

        public Builder typePrestressing(String val) {
            typePrestressing = val;
            return this;
        }

        public PrestressingForces build() {
            return new PrestressingForces(this);
        }

    }

    protected double normalStress(double moment, double inertia, double distance) {
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
        return 0.1 * alpha * 0.7 * 0.3 * Math.pow(fck, 2.0 / 3.0);
    }

    protected double prestressedForce(double prestresStress, double fiberDistance) {
        double den = 1 + area * prestressingExcentricity * fiberDistance / inertia;
        return prestresStress * area / den;

    }

    protected double prestressedStressSup(double prestressedForce, double fiberDistance) {
        return -(prestressedForce / area) * (1 - area * prestressingExcentricity * fiberDistance / inertia);

    }

    protected double forceInServiceabilityLimitState(String limiteStateType) throws Exception {
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

        double force = 0.0;
        if (limiteStateType.equalsIgnoreCase("descompression")) {
            double factor1;
            double factor2;
            if (typePrestressing.equalsIgnoreCase("Total")) {
                factor1 = psi_1_Coeff;
                factor2 = psi_2_Coeff;
            } else if (typePrestressing.equalsIgnoreCase("Limited")) {
                factor1 = psi_2_Coeff;
                factor2 = psi_2_Coeff;
            } else {
                JOptionPane.showMessageDialog(null, "Tipo de protensão não identificado.");
                throw new Exception("Type prestressing not found.");
            }
            //tensão de protensão em relação às fibras inferiores para o Estado Limite de Descompressão
            double prestresStressInf = selfLoadStressInf + othersDeadStressInf + factor1 * liveLoadPrincipalStressInf + factor2 * liveLoadSecundaryStressInf;
            force = prestressedForce(prestresStressInf, inferiorFiberDistance);
            //verificação das tensões de tração (topo da viga) para o Estado Limite de Descompressão
            double prestressStressSup = prestressedStressSup(force, superiorFiberDistance);
            double totalCompressionStress = selfLoadStressSup + othersDeadStressSup + factor1 * liveLoadPrincipalStressSup + factor2 * liveLoadSecundaryStressSup - prestressStressSup;
            //Verificação do Estado Limite de Descompressão
            if (totalCompressionStress > 0.5 * fck) {
                JOptionPane.showMessageDialog(null, "Não atende ao estado limite de descompressão");
                throw new Exception("Does not meet the decompression limit state");
            }
        } else if (limiteStateType.equalsIgnoreCase("fissuration")) {
            double factor1;
            double factor2;
            if (typePrestressing.equalsIgnoreCase("Total")) {
                factor1 = 1.0;
                factor2 = psi_1_Coeff;
            } else if (typePrestressing.equalsIgnoreCase("Limited")) {
                factor1 = psi_1_Coeff;
                factor2 = psi_2_Coeff;
            } else {
                JOptionPane.showMessageDialog(null, "Tipo de protensão não identificado.");
                throw new Exception("Type prestressing not found.");
            }
            //Tensão de protensão nas fibras inferiores parao Estado Limite de Formação de Fissuras
            double prestresStressInf = selfLoadStressInf + othersDeadStressInf + factor1 * liveLoadPrincipalStressInf + factor2 * liveLoadSecundaryStressInf - concreteStressTension();
            force = prestressedForce(prestresStressInf, inferiorFiberDistance);
            double prestressStressSup = prestressedStressSup(force, superiorFiberDistance);
            double totalCompressionStress = selfLoadStressSup + othersDeadStressSup + factor1 * liveLoadPrincipalStressSup + factor2 * liveLoadSecundaryStressSup - prestressStressSup;
            if (totalCompressionStress > 0.5 * fck) {
                JOptionPane.showMessageDialog(null, "Não atende ao estado limite de fissuração");
                throw new Exception("Does not meet the fissuration limit state");
            }
        } else {
            throw new IllegalArgumentException("Limit states must be descompression ou fissuration");
        }
        return force;
    }

    protected double finalForceWithLossPrestress() throws Exception {
        double descompressionForce = forceInServiceabilityLimitState("descompression");
        double fissurationForce = forceInServiceabilityLimitState("fissuration");

        double force;
        System.out.println("Força na descompressão (kN)" + descompressionForce);
        System.out.println("Força na abertura de fissuras (kN)" + fissurationForce);
        if (descompressionForce > fissurationForce) {
            force = descompressionForce;
        } else {
            force = fissurationForce;
        }
        //Força de protensão final considerando as perdas de protensão
        return force / (1 - lossPrestress);
    }

    protected double effectivePrestressForce(String tendonType, double operatedStressTendonLimite, double finalForceWithLossPrestress) throws Exception {
        double tendonArea = 0.0;
        if (tendonType.equalsIgnoreCase("CP190_127")) {
            tendonArea = 1.00;
        } else if (tendonType.equalsIgnoreCase("CP190_152")) {
            tendonArea = 1.43;
        } else if (tendonType.equalsIgnoreCase("CP190_157")) {
            tendonArea = 1.50;
        } else {
            JOptionPane.showMessageDialog(null, " Não há especificação desta cordoalha no banco de dados");
            throw new Exception("There is no specification for this tendon in the database");
        }
        double areaReq = finalForceWithLossPrestress / operatedStressTendonLimite;
        int numberTendons = (int) (areaReq / tendonArea);

        while (numberTendons * tendonArea < areaReq) {
            numberTendons += 1;
        }
        double effectiveArea = numberTendons * tendonArea;
        return effectiveArea * operatedStressTendonLimite;

    }

    public void run() throws Exception {
        double finalForceWithLoss = finalForceWithLossPrestress();
        OperatedStressTendonLimite limite = new OperatedStressTendonLimite();
        double operatedStress = limite.run(f_ptk, posTensionOrPreTension, relaxationType);
        double effectivePrestressForce = effectivePrestressForce(tendonType, operatedStress, finalForceWithLoss);
        System.out.println("Força de protensão efetiva = " + effectivePrestressForce);
    }

}
