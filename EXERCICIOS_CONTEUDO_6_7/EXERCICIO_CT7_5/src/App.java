import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        ArrayList<Produto> listaProdutos = new ArrayList<>();

        int opcao;

        do {

            System.out.println();
            System.out.println("===== MENU =====");
            System.out.println("1 - Adicionar produto");
            System.out.println("2 - Consultar produto por código");
            System.out.println("3 - Atualizar quantidade em estoque");
            System.out.println("4 - Listar produtos com estoque baixo");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = teclado.nextInt();
            teclado.nextLine();

            switch (opcao) {

                case 1:

                    System.out.print("Digite o código do produto: ");
                    int codigo = teclado.nextInt();
                    teclado.nextLine();

                    boolean codigoExiste = false;

                    for (int i = 0; i < listaProdutos.size(); i++) {

                        if (listaProdutos.get(i).getCodigo() == codigo) {
                            codigoExiste = true;
                            break;
                        }
                    }

                    if (codigoExiste == true) {

                        System.out.println("Já existe um produto com esse código.");

                    } else {

                        System.out.print("Digite o nome do produto: ");
                        String nome = teclado.nextLine();

                        Produto produto = new Produto(codigo, nome);

                        System.out.print("Digite a quantidade em estoque: ");
                        int quantidade = teclado.nextInt();
                        teclado.nextLine();

                        produto.setQuantidadeEstoque(quantidade);

                        listaProdutos.add(produto);

                        System.out.println("Produto cadastrado com sucesso!");
                    }

                    break;


                case 2:

                    System.out.print("Digite o código do produto: ");
                    int codigoConsulta = teclado.nextInt();
                    teclado.nextLine();

                    boolean encontrou = false;

                    for (int i = 0; i < listaProdutos.size(); i++) {

                        if (listaProdutos.get(i).getCodigo() == codigoConsulta) {

                            System.out.println(
                                "Nome: " + listaProdutos.get(i).getNome()
                            );

                            System.out.println(
                                "Quantidade em estoque: "
                                + listaProdutos.get(i).getQuantidadeEstoque()
                            );

                            encontrou = true;

                            break;
                        }
                    }

                    if (encontrou == false) {
                        System.out.println("Produto não encontrado.");
                    }

                    break;


                case 3:

                    System.out.print("Digite o código do produto: ");
                    int codigoAtualizar = teclado.nextInt();

                    boolean produtoEncontrado = false;

                    for (int i = 0; i < listaProdutos.size(); i++) {

                        if (listaProdutos.get(i).getCodigo() == codigoAtualizar) {

                            System.out.print("Digite a nova quantidade: ");
                            int novaQuantidade = teclado.nextInt();

                            listaProdutos.get(i)
                                .setQuantidadeEstoque(novaQuantidade);

                            System.out.println(
                                "Estoque atualizado com sucesso!"
                            );

                            produtoEncontrado = true;

                            break;
                        }
                    }

                    teclado.nextLine();

                    if (produtoEncontrado == false) {
                        System.out.println("Produto não encontrado.");
                    }

                    break;


                case 4:

                    System.out.println();
                    System.out.println("===== PRODUTOS COM ESTOQUE BAIXO =====");

                    boolean estoqueBaixo = false;

                    for (int i = 0; i < listaProdutos.size(); i++) {

                        if (
                            listaProdutos.get(i).getQuantidadeEstoque() < 5
                        ) {

                            System.out.println(listaProdutos.get(i));

                            estoqueBaixo = true;
                        }
                    }

                    if (estoqueBaixo == false) {
                        System.out.println(
                            "Nenhum produto com estoque baixo."
                        );
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