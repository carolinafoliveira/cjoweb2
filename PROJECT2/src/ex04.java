import javax.swing.JOptionPane;

public class ex04 {

    public static void main(String[] args) throws Exception {

        int senhaCorreta, senhaUsuario;

        senhaCorreta = 1234;

        senhaUsuario = Integer.parseInt(
            JOptionPane.showInputDialog("Digite a senha:")
        );

        while (senhaUsuario != senhaCorreta) {

            JOptionPane.showMessageDialog(
                null,
                "Senha inválida!"
            );

            senhaUsuario = Integer.parseInt(
                JOptionPane.showInputDialog("Digite a senha novamente:")
            );
        }

        JOptionPane.showMessageDialog(
            null,
            "Senha correta!"
        );
    }
}