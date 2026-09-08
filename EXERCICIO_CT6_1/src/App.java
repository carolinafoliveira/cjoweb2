public class App {

    public static void main(String[] args) {

        // a) instancia um produto
        Produto produto = new Produto(1, "Notebook");

        // b) modifica o nome e o preço
        produto.setNome("Notebook Lenovo"); // set modifica 
        produto.setPreco(3500.00);

        // imprime os dados atualizados
        System.out.println(produto);
    }
}
