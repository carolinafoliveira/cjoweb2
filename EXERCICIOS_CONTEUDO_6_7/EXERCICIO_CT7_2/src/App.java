import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        ArrayList<Aluno> listaAlunos = new ArrayList<>();

        int opcao;

        do {

            System.out.println();
            System.out.println("===== MENU =====");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Exibir alunos aprovados");
            System.out.println("3 - Exibir média da turma");
            System.out.println("4 - Remover aluno por prontuário");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = teclado.nextInt();
            teclado.nextLine();

            switch (opcao) {

                // CADASTRAR ALUNO
                case 1:

                    System.out.print("Digite o prontuário: ");
                    String prontuario = teclado.nextLine();

                    System.out.print("Digite o nome: ");
                    String nome = teclado.nextLine();

                    System.out.print("Digite a nota: ");
                    double nota = teclado.nextDouble();
                    teclado.nextLine();

                    Aluno aluno = new Aluno(
                        prontuario,
                        nome,
                        nota
                    );

                    listaAlunos.add(aluno);

                    System.out.println("Aluno cadastrado com sucesso!");

                    break;


                // EXIBIR ALUNOS APROVADOS
                case 2:

                    System.out.println();
                    System.out.println("===== ALUNOS APROVADOS =====");

                    for (int i = 0; i < listaAlunos.size(); i++) {

                        Aluno alunoAprovado = listaAlunos.get(i);

                        if (alunoAprovado.getNota() >= 6.0) {

                            System.out.println(alunoAprovado);
                        }
                    }

                    break;


                // EXIBIR MÉDIA DA TURMA
                case 3:

                    if (listaAlunos.size() == 0) {

                        System.out.println("Nenhum aluno cadastrado.");

                    } else {

                        double soma = 0;

                        for (int i = 0; i < listaAlunos.size(); i++) {

                            soma = soma + listaAlunos.get(i).getNota();
                        }

                        double media = soma / listaAlunos.size();

                        System.out.println(
                            "Média da turma: " + media
                        );
                    }

                    break;


                // REMOVER ALUNO
                case 4:

                    System.out.print(
                        "Digite o prontuário do aluno que deseja remover: "
                    );

                    String prontuarioRemover = teclado.nextLine();

                    boolean encontrou = false;

                    for (int i = 0; i < listaAlunos.size(); i++) {

                        if (
                            listaAlunos.get(i)
                                .getProntuario()
                                .equalsIgnoreCase(prontuarioRemover)
                        ) {

                            listaAlunos.remove(i);

                            encontrou = true;

                            System.out.println(
                                "Aluno removido com sucesso!"
                            );

                            break;
                        }
                    }

                    if (encontrou == false) {

                        System.out.println(
                            "Aluno não encontrado."
                        );
                    }

                    break;


                // SAIR
                case 0:

                    System.out.println("Programa encerrado.");

                    break;


                default:

                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        teclado.close();
    }
}