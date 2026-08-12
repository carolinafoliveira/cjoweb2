/*Utilizando a estrutura switch com String, peça ao usuário o nome de um mês e informe a qual estação do ano ele pertence 
(ex: "Dezembro" -> "Verão"), tratando meses não reconhecidos no bloco default. */

import javax.swing.JOptionPane;

public class ex02 {
    public static void main(String[] args) throws Exception {
        String mes;

        mes = JOptionPane.showInputDialog("Digite o mês desejado:");

        switch (mes) {
            case "Janeiro": 
                JOptionPane.showMessageDialog(null, "Verão");
                break;
            case "Fevereiro":
                JOptionPane.showMessageDialog(null, "Verão");
                break;
            case "Março":
                JOptionPane.showMessageDialog(null, "Outono");
                break;
            case "Abril":
                JOptionPane.showMessageDialog(null, "Outono");
                break;
            case "Maio":
                JOptionPane.showMessageDialog(null, "Outono");
                break;
            case "Junho":
                JOptionPane.showMessageDialog(null, "Inverno");
                break;
            case "Julho":
                JOptionPane.showMessageDialog(null, "Inverno");
                break;
            case "Agosto":
                JOptionPane.showMessageDialog(null, "Inverno");
                break;
            case "Setembro":
                JOptionPane.showMessageDialog(null, "Primavera");
                break;
            case "Outubro":
                JOptionPane.showMessageDialog(null, "Primavera");
                break;
            case "Novembro":
                JOptionPane.showMessageDialog(null, "Primavera");
                break;
            case "Dezembro":
                JOptionPane.showMessageDialog(null, "Verão");
                break;                
            default: 
                JOptionPane.showMessageDialog(null, "Mês não reconhecido");
                break;
        }
        
    }
}

