/*.Use um laço for para ler 5 temperaturas e, ao final, calcule e exiba a média aritmética delas. */

import javax.swing.JOptionPane;

public class ex05 {

    public static void main(String[] args) throws Exception {
        float temperatura, media, soma = 0;

        for(int i = 1; i <= 5; i++){
            temperatura = Float.parseFloat(JOptionPane.showInputDialog("Digite a " + i + "ª temperatura:"));
            soma = soma + temperatura;
        }

        media = soma / 5;

        JOptionPane.showMessageDialog(null, "Media das temperaturas = " + media);
    }
}