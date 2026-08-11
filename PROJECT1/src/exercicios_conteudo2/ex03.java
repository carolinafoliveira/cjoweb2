
/*Um hotel deseja fazer uma promoção especial de final de semana, concedendo um desconto no 
valor normal da diária. Faça um programa em Java que recebe o valor da diária e o percentual de 
desconto que será concedido, calcule e mostre o valor da diária com desconto. */

package exercicios_conteudo2; // package organiza o projeto em pastas

import javax.swing.JOptionPane;

public class ex03 {
    public static void main(String[] args) throws Exception {

        float precoDiaria, descontoDiaria, precoFinal, percentual;

        precoDiaria = Float.parseFloat(JOptionPane.showInputDialog("Informe o valor da diaria: "));
        percentual = Float.parseFloat(JOptionPane.showInputDialog("Informe o % de desconto: "));

        descontoDiaria = precoDiaria * (percentual / 100);
        precoFinal = precoDiaria - descontoDiaria;

        JOptionPane.showMessageDialog(null, "Valor final da Diaria" + precoFinal);
    }
}


