import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        ArrayList<ItemCarrinho> carrinho = new ArrayList<>();

        int opcao;

        do {

            System.out.println();
            System.out.println("===== CARRINHO DE COMPRAS =====");
            System.out.println("1 - Adicionar item ao carrinho");
            System.out.println("2 - Exibir detalhes do carrinho");
            System.out.println("3 - Exibir valor total da compra");
            System.out.println("4 - Limpar carrinho");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = teclado.nextInt();
            teclado.nextLine();

            switch (opcao) {

                case 1:

                    System.out.print("Digite o nome do produto: ");
                    String nomeProduto = teclado.nextLine();

                    System.out.print("Digite o preço unitário: R$ ");
                    double precoUnitario = teclado.nextDouble();

                    System.out.print("Digite a quantidade: ");
                    int quantidade = teclado.nextInt();
                    teclado.nextLine();

                    ItemCarrinho item = new ItemCarrinho(
                        nomeProduto,
                        precoUnitario,
                        quantidade
                    );

                    carrinho.add(item);

                    System.out.println("Item adicionado com sucesso!");

                    break;

                case 2:

                    if (carrinho.size() == 0) {

                        System.out.println("O carrinho está vazio.");

                    } else {

                        System.out.println();
                        System.out.println("===== ITENS DO CARRINHO =====");

                        for (int i = 0; i < carrinho.size(); i++) {

                            System.out.println(carrinho.get(i));
                        }
                    }

                    break;

                case 3:

                    if (carrinho.size() == 0) {

                        System.out.println("O carrinho está vazio.");

                    } else {

                        double total = 0;

                        for (int i = 0; i < carrinho.size(); i++) {

                            total = total + carrinho.get(i).calcularSubtotal();
                        }

                        System.out.println(
                            "Valor total da compra: R$ " + total
                        );
                    }

                    break;

                case 4:

                    carrinho.clear();

                    System.out.println("Carrinho limpo com sucesso!");

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