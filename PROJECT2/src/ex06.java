/*Utilize a classe Random para sortear um número de 1 a 100, representando o ID de um cliente que ganhará um brinde. */

import java.util.Random;

import javax.swing.JOptionPane;

public class ex06 {

    public static void main(String[] args) throws Exception {
        Random numeroSorteado = new Random();

        int idCliente;

        idCliente = numeroSorteado.nextInt(100) + 1; //usa o +1 porque começa em 0 e vai ate 99

        JOptionPane.showMessageDialog(null, "Cliente sorteado: " + idCliente);
    }
}