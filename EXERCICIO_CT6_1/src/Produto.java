public class Produto {

    // criando atributos e encapsulamento
    private int codigo;
    private String nome;
    private double preco;

    // construtor
    public Produto(int codigo, String nome) {
        this.codigo = codigo; // isso faz com que o construtor receba os atributos que são privados 
        this.nome = nome;
    }

    // setter do código - acessa e altera o valor do atributo 
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    // getter do código - acessa/consulta o valor de um atributo
    public int getCodigo() {
        return codigo;
    }

    // setter do nome - acessa e altera o valor do atributo 
    public void setNome(String nome) {
        this.nome = nome;
    }

    // getter do nome - acessa/consulta o valor de um atributo
    public String getNome() {
        return nome;
    }

    // setter do preço - acessa e altera o valor do atributo 
    public void setPreco(double preco) {
        this.preco = preco;
    }

    // getter do preço - acessa/consulta o valor de um atributo
    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "Codigo: " + codigo +
               "\nNome: " + nome +
               "\nPreco: R$ " + preco;
    }
}
