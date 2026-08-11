
/*Faça um programa em Java que receba o custo de um espetáculo teatral e o preço do convite desse espetáculo. 
Esse programa deverá calcular e mostrar a quantidade de convites que devem ser vendidos para que, pelo menos, o custo do espetáculo seja alcançado*/

package exercicios_conteudo2; // package organiza o projeto em pastas

import javax.swing.JOptionPane;

public class ex02 {
    public static void main(String[] args) throws Exception {
        float custoPeca, precoConvite, quantidadeConvite;

        custoPeca = Float.parseFloat(JOptionPane.showInputDialog("Digite o custo total do espetáculo teatral (R$):"));
        precoConvite = Float.parseFloat(JOptionPane.showInputDialog("Digite o preço do convite individual (R$):"));

        quantidadeConvite = custoPeca / precoConvite; // quantidade mínima de convites = custo do espetáculo / preço do convite

        JOptionPane.showMessageDialog(null, "Venda minima deve ser de " + quantidadeConvite + " convites");
    }
}


