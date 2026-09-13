public class ItemCarrinho {

    private String nomeProduto;
    private double precoUnitario;
    private int quantidade;

    // construtor
    public ItemCarrinho(String nomeProduto, double precoUnitario, int quantidade) {
        this.nomeProduto = nomeProduto;
        this.precoUnitario = precoUnitario;
        this.quantidade = quantidade;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    // calcula o subtotal do item
    public double calcularSubtotal() {
        return precoUnitario * quantidade;
    }

    @Override
    public String toString() {
        return "Produto: " + nomeProduto +
               " | Quantidade: " + quantidade +
               " | Preço unitário: R$ " + precoUnitario +
               " | Subtotal: R$ " + calcularSubtotal();
    }
}