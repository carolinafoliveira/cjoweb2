/*. Implemente um laço while que solicite uma senha ao usuário e continue repetindo a
solicitação até que a senha correta (ex: "1234") seja digitada. */
import javax.swing.JOptionPane;

public class ex04 {
    public static void main(String[] args) throws Exception {
        int senhaCorreta = 1234, senhaUsuario;

        do {
            senhaUsuario = Integer.parseInt(JOptionPane.showInputDialog("Digite a senha:"));

            if (senhaUsuario != senhaCorreta) {
                JOptionPane.showMessageDialog(null, "Senha incorreta!\nDeseja tenhar n");

            }
        } while (senhaUsuario != senhaCorreta);
    }
}