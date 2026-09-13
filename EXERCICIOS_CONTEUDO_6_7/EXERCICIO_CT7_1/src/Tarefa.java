/* 1. Escreva uma classe em Java para representar tarefas. Toda tarefa possui código e título, e ambos
os valores são obrigatórios durante a instanciação de uma tarefa. Além disso, para cada tarefa,
deve haver uma forma para que se modifiquem e acessem seus dados a qualquer momento.
Considere o conceito de encapsulamento. Crie uma classe, composta pelo método main(), para
gerenciar uma lista de tarefas. Essa classe deve possuir um menu com as seguintes opções:
a. Adicionar uma tarefa: Adiciona uma nova tarefa à lista.
b. Remover uma tarefa: Remove uma tarefa da lista.
c. Listar todas as tarefas: Apresenta a lista de todas as tarefas inseridas.
d. Sair do programa.*/

// Criando a classe
public class Tarefa {

    private int codigo;
    private String titulo;

    // construtor
    public Tarefa(int codigo, String titulo) {
        this.codigo = codigo;
        this.titulo = titulo;
    }

    // setter do codigo
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    // getter do codigo
    public int getCodigo() {
        return codigo;
    }

    // setter do titulo
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    // getter do titulo
    public String getTitulo() {
        return titulo;
    }

    @Override
    public String toString() {
        return "Código: " + codigo +
               " | Título: " + titulo;
    }
}
