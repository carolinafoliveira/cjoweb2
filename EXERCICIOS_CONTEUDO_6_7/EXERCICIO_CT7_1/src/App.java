import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        ArrayList<Tarefa> listaTarefas = new ArrayList<>();

        int opcao;

        do {

            System.out.println();
            System.out.println("===== MENU =====");
            System.out.println("1 - Adicionar tarefa");
            System.out.println("2 - Remover tarefa");
            System.out.println("3 - Listar todas as tarefas");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = teclado.nextInt();
            teclado.nextLine();

            switch (opcao) {

                case 1:

                    System.out.print("Digite o código da tarefa: ");
                    int codigo = teclado.nextInt();
                    teclado.nextLine();

                    System.out.print("Digite o título da tarefa: ");
                    String titulo = teclado.nextLine();

                    Tarefa tarefa = new Tarefa(codigo, titulo);

                    listaTarefas.add(tarefa);

                    System.out.println("Tarefa adicionada com sucesso!");

                    break;

                case 2:

                    System.out.print("Digite o código da tarefa que deseja remover: ");
                    int codigoRemover = teclado.nextInt();

                    boolean encontrou = false;

                    for (int i = 0; i < listaTarefas.size(); i++) {

                        if (listaTarefas.get(i).getCodigo() == codigoRemover) {

                            listaTarefas.remove(i);

                            encontrou = true;

                            System.out.println("Tarefa removida com sucesso!");

                            break;
                        }
                    }

                    if (encontrou == false) {
                        System.out.println("Tarefa não encontrada.");
                    }

                    break;

                case 3:

                    if (listaTarefas.size() == 0) {

                        System.out.println("Nenhuma tarefa cadastrada.");

                    } else {

                        System.out.println();
                        System.out.println("===== LISTA DE TAREFAS =====");

                        for (int i = 0; i < listaTarefas.size(); i++) {

                            System.out.println(listaTarefas.get(i));
                        }
                    }

                    break;

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