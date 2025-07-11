/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author olgierd
 */
public class Converter {
    
    /**
     * Convert text string in double
     * @param textField 
     * @return double value converted
     */
    public static double textToDouble(JTextField textField) {
        String textoDigitado = textField.getText();
        double value = 0.0;
        try {
            value = Double.parseDouble(textoDigitado);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Erro: Entrada inválida. Digite um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return value;
    }
    /**
     * Convert text string in integer
     * @param textField 
     * @return int value converted
     */
    public static int textToInteger(JTextField textField) {
        String textoDigitado = textField.getText();
        int value = 0;
        try {
            value = Integer.parseInt(textoDigitado);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Erro: Entrada inválida. Digite um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return value;

    }

}
