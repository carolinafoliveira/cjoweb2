/*Crie um programa que aplique um desconto de 15% apenas se o valor de uma compra for superior a R$ 500,00, usando um if simples*/

import javax.swing.JOptionPane;

public class ex03 {
    public static void main(String[] args) throws Exception {
        float valorCompra;

        valorCompra = Float.parseFloat(JOptionPane.showInputDialog("Informe o valor total da compra:"));

        if (valorCompra > 500) {
            valorCompra = valorCompra - (valorCompra * 0.15f); // poderia ser valorCompra = valorCompra * 0.85f
        }

        JOptionPane.showConfirmDialog(null, "Valor da compra: " + valorCompra);
    }
}