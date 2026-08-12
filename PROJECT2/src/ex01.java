/*Crie um programa que utilize if-else para verificar se um usuário possui a idade mínima de 18 anos para acessar um sistema.*/

import javax.swing.JOptionPane;

public class ex01 {
    public static void main(String[] args) throws Exception {
        int idadeMinima = 18;
        int idade;
        
        idade = Integer.parseInt(JOptionPane.showInputDialog("Digite sua idade:"));

        if (idade < idadeMinima){
            JOptionPane.showMessageDialog(null, "Acesso negado!\nVocê não possuí idade mínima para\nacessar o sistema.");
        } else {
            JOptionPane.showMessageDialog(null, "Acesso liberado.");
        }
    }
}

