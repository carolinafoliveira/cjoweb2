
/*Adriana comprou um saco de ração com peso em quilos. Ela possui dois gatos, para os quais fornece a quantidade de ração em gramas. 
A quantidade diária de ração fornecida para cada gato é sempre a mesma. Faça um programa em Java que receba o peso do saco de ração e
a quantidade de ração fornecida para cada gato, calcule e mostre quanto restará de ração no saco após cinco dias.*/

package exercicios_conteudo2; // package organiza o projeto em pastas

import javax.swing.JOptionPane;

public class ex01 {
    public static void main(String[] args) throws Exception {
        float pesoSaco, racao, pesoGr, consumoTotal, resultado;

        pesoSaco = Float.parseFloat(JOptionPane.showInputDialog("Digite o peso do saco (Kg):"));
        racao = Float.parseFloat(JOptionPane.showInputDialog("Digite a quantidade de ração fornecida para os gatos (Gr):"));

        pesoGr = pesoSaco * 1000; //conversão de kg para gramas
        consumoTotal = racao * 2 * 5; // dois gatos em 5 dias
        resultado = pesoGr - consumoTotal;

        JOptionPane.showMessageDialog(null, "Ração restante após 5 dias = = " + resultado);
    }
}


