import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        ArrayList<Musica> playlist = new ArrayList<>();

        int opcao;

        do {

            System.out.println();
            System.out.println("===== PLAYLIST =====");
            System.out.println("1 - Adicionar música");
            System.out.println("2 - Buscar música por título");
            System.out.println("3 - Remover música por título");
            System.out.println("4 - Listar playlist e tempo total");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = teclado.nextInt();
            teclado.nextLine();

            switch (opcao) {

                case 1:

                    System.out.print("Digite o título da música: ");
                    String titulo = teclado.nextLine();

                    System.out.print("Digite o artista: ");
                    String artista = teclado.nextLine();

                    System.out.print("Digite a duração em segundos: ");
                    int duracao = teclado.nextInt();
                    teclado.nextLine();

                    Musica musica = new Musica(
                        titulo,
                        artista,
                        duracao
                    );

                    playlist.add(musica);

                    System.out.println("Música adicionada com sucesso!");

                    break;

                case 2:

                    System.out.print("Digite o título da música: ");
                    String tituloBusca = teclado.nextLine();

                    boolean encontrou = false;

                    for (int i = 0; i < playlist.size(); i++) {

                        if (playlist.get(i).getTitulo().equalsIgnoreCase(tituloBusca)) {

                            System.out.println(playlist.get(i));

                            encontrou = true;

                            break;
                        }
                    }

                    if (encontrou == false) {
                        System.out.println("Música não encontrada na playlist.");
                    }

                    break;

                case 3:

                    System.out.print("Digite o título da música que deseja remover: ");
                    String tituloRemover = teclado.nextLine();

                    boolean removida = false;

                    for (int i = 0; i < playlist.size(); i++) {

                        if (playlist.get(i).getTitulo().equalsIgnoreCase(tituloRemover)) {

                            playlist.remove(i);

                            removida = true;

                            System.out.println("Música removida com sucesso!");

                            break;
                        }
                    }

                    if (removida == false) {
                        System.out.println("Música não encontrada.");
                    }

                    break;

                case 4:

                    if (playlist.size() == 0) {

                        System.out.println("A playlist está vazia.");

                    } else {

                        int totalSegundos = 0;

                        System.out.println();
                        System.out.println("===== PLAYLIST =====");

                        for (int i = 0; i < playlist.size(); i++) {

                            System.out.println(playlist.get(i));

                            totalSegundos =
                                totalSegundos
                                + playlist.get(i).getDuracaoSegundos();
                        }

                        int minutos = totalSegundos / 60;
                        int segundos = totalSegundos % 60;

                        System.out.println();
                        System.out.println(
                            "Tempo total da playlist: "
                            + minutos
                            + " minutos e "
                            + segundos
                            + " segundos"
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
}