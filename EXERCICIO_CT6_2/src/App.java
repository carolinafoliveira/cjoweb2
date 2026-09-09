import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {
        // a. Instanciar uma data com valores predefinidos
        Data data = new Data(15, 6, 2023);
        JOptionPane.showMessageDialog(null, "Data predefinida: " + data);

        // b. Modificar a data a partir de dados lidos do usuário
        
        // Lê o dia e tenta atualizar
        int dia = Integer.parseInt(JOptionPane.showInputDialog("Digite o novo dia (1-30):"));
        data.setDia(dia);

        // Lê o mês e tenta atualizar
        int mes = Integer.parseInt(JOptionPane.showInputDialog("Digite o novo mês (1-12):"));
        data.setMes(mes);

        // Lê o ano e tenta atualizar
        int ano = Integer.parseInt(JOptionPane.showInputDialog("Digite o novo ano (>= 1900):"));
        data.setAno(ano);

        // Exibe a data (se o usuário digitou algo inválido, o valor anterior permanece)
        JOptionPane.showMessageDialog(null, "Nova data: " + data);
    }
}