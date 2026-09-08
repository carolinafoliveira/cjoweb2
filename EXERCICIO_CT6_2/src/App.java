import javax.swing.JOptionPane;

public class App {

    public static void main(String[] args) {

        // a) instancia uma data com valores predefinidos
        Data data = new Data(10, 5, 2026);

        // b) leitura dos novos valores
        int novoDia = Integer.parseInt(
            JOptionPane.showInputDialog("Digite o dia:")
        );

        int novoMes = Integer.parseInt(
            JOptionPane.showInputDialog("Digite o mes:")
        );

        int novoAno = Integer.parseInt(
            JOptionPane.showInputDialog("Digite o ano:")
        );

        // modifica a data usando os setters
        data.setDia(novoDia);
        data.setMes(novoMes);
        data.setAno(novoAno);

        // mostra a nova data
        JOptionPane.showMessageDialog(
            null,
            "Nova data: " + data
        );
    }
}