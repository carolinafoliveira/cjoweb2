public class Produto {

    private int codigo;
    private String nome;
    private int quantidadeEstoque;

    public Produto(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
        this.quantidadeEstoque = 0;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    @Override
    public String toString() {
        return "Código: " + codigo +
               " | Nome: " + nome +
               " | Estoque: " + quantidadeEstoque;
    }
}