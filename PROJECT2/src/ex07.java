/*Desenvolva um programa que gere dois números aleatórios entre 1 e 10 e peça ao usuário para digitar a soma deles. 
Use um if para verificar se ele acertou (simulando um sistema de segurança). */

import java.util.Random;
import javax.swing.JOptionPane;

public class ex07 {
    public static void main(String[] args) throws Exception {

        Random sorteador = new Random();

        int numero1, numero2, respostaUsuario, soma;

        numero1 = sorteador.nextInt(10) + 1;
        numero2 = sorteador.nextInt(10) + 1;

        respostaUsuario = Integer.parseInt(JOptionPane.showInputDialog("Quanto é " + numero1 + " + " + numero2 + "?"));

        soma = numero1 + numero2;

        if (respostaUsuario == soma) {
            JOptionPane.showMessageDialog(null,"Resposta correta! Acesso permitido.");
        }

        if (respostaUsuario != soma) {
            JOptionPane.showMessageDialog(null,"Resposta incorreta! Acesso negado.");
        }
    }
}