/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ada.protende;

import javax.swing.JOptionPane;

/**
 *
 * @author Hudson
 */
public class OperatedStressTendonLimite {

    public OperatedStressTendonLimite() {
    }

    public double run(double f_ptk, String posTensionOrPreTension, String relaxationType) {
        double operatedStress;
        if (posTensionOrPreTension.equalsIgnoreCase("posTension")) {
            if (relaxationType.equalsIgnoreCase("normal")) {
                operatedStress = posTensionNormalRelaxation(f_ptk);
            } else if (relaxationType.equalsIgnoreCase("Low")) {
                operatedStress = posTensionLowRelaxation(f_ptk);
            } else if (relaxationType.equalsIgnoreCase("LowAndGreased")) {
                operatedStress = posTensionGreasedTendon(f_ptk);
            } else {
                JOptionPane.showMessageDialog(null, "Tipo de  cordoalha inexistente");
                throw new IllegalArgumentException("Tendon non-exist. Look class OperatedStressTendonLimite");
            }
        } else if (posTensionOrPreTension.equalsIgnoreCase("preTension")) {
            if (relaxationType.equalsIgnoreCase("normal")) {
                operatedStress = preTensionNormalRelaxation(f_ptk);

            } else if (relaxationType.equalsIgnoreCase("Low")) {
                operatedStress = preTensionLowRelaxation(f_ptk);

            } else {
                JOptionPane.showMessageDialog(null, "Tipo de  cordoalha inexistente");
                throw new IllegalArgumentException("Tendon non-exist. Look class OperatedStressTendonLimite");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Tipo de tração é inexistente");
            throw new IllegalArgumentException("Tension type non-exist. Look class OperatedStressTendonLimite");

        }
        return operatedStress;
    }

    private double posTensionNormalRelaxation(double f_ptk) {
        double stress1 = 0.74 * f_ptk;
        double stress2 = 0.87 * 0.85 * f_ptk;
        double result;
        if (stress1 < stress2) {
            result = stress1;
        } else {
            result = stress2;
        }
        return result;
    }

    private double posTensionLowRelaxation(double f_ptk) {
        double stress1 = 0.74 * f_ptk;
        double stress2 = 0.82 * 0.90 * f_ptk;
        double result;
        if (stress1 < stress2) {
            result = stress1;
        } else {
            result = stress2;
        }
        return result;
    }

    private double posTensionGreasedTendon(double f_ptk) {
        //Relaxação baixa
        double stress1 = 0.80 * f_ptk;
        double stress2 = 0.88 * 0.90 * f_ptk;
        double result;
        if (stress1 < stress2) {
            result = stress1;
        } else {
            result = stress2;
        }
        return result;
    }

    private double preTensionNormalRelaxation(double f_ptk) {
        double stress1 = 0.77 * f_ptk;
        double stress2 = 0.90 * 0.85 * f_ptk;
        double result;
        if (stress1 < stress2) {
            result = stress1;
        } else {
            result = stress2;
        }
        return result;
    }

    private double preTensionLowRelaxation(double f_ptk) {
        double stress1 = 0.77 * f_ptk;
        double stress2 = 0.85 * 0.90 * f_ptk;
        double result;
        if (stress1 < stress2) {
            result = stress1;
        } else {
            result = stress2;
        }
        return result;
    }
}
